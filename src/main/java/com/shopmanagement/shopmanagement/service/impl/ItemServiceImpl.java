package com.shopmanagement.shopmanagement.service.impl;

import com.shopmanagement.shopmanagement.dao.ItemRepo;
import com.shopmanagement.shopmanagement.dto.ItemDto;
import com.shopmanagement.shopmanagement.exception.BadRequestException;
import com.shopmanagement.shopmanagement.exception.ResourceNotFoundException;
import com.shopmanagement.shopmanagement.model.Item;
import com.shopmanagement.shopmanagement.service.CategoryService;
import com.shopmanagement.shopmanagement.service.ItemService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepo itemRepo;

    private final CategoryService categoryService;

    public ItemServiceImpl(ItemRepo itemRepo, CategoryService categoryService) {
        this.itemRepo = itemRepo;
        this.categoryService = categoryService;
    }

    @Override
    public Item addItem(UUID cid, ItemDto itemDto) {
        Item item = new Item();
        item.setName(itemDto.getName());
        item.setAmount(itemDto.getAmount());
        item.setQuantity(itemDto.getQuantity());
        item.setStatus(itemDto.getStatus());
        item.setCategory(categoryService.getCategoryByCid(cid));
        return itemRepo.save(item);
    }

    @Override
    public List<Item> getItems() {
        return itemRepo.findAll();
    }

    @Override
    public List<Item> getItem(UUID cid) {
        List<Item> itemList = itemRepo.findByCategoryCid(cid);
        if(itemList.isEmpty()){
            throw new ResourceNotFoundException("Category Id "+cid+" not found");
        }
        return itemList;
    }

    @Override
    public void deleteItem(UUID id) {
        itemRepo.deleteById(id);
    }

    @Override
    public Item updateItem(UUID id, ItemDto itemDto) {
        Optional<Item> itemData = itemRepo.findById(id);
        itemData.orElseThrow(() -> new ResourceNotFoundException("Id " + id + " not found"));
        Item item = itemData.get();
        int itemQuantity = item.getQuantity() + itemDto.getQuantity();
        if(itemQuantity < 0){
            throw new BadRequestException("Quantity cannot be negative");
        }
        item.setQuantity(itemQuantity);
        return itemRepo.save(item);
    }

    @Override
    public Item getItemById(UUID id) {
        return itemRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id + " not found"));
    }


}
