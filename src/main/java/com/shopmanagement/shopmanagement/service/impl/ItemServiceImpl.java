package com.shopmanagement.shopmanagement.service.impl;

import com.shopmanagement.shopmanagement.dao.ItemRepo;
import com.shopmanagement.shopmanagement.dto.ItemDto;
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
    public Item addItem(UUID cid, ItemDto item) {
        Item it = new Item();
        it.setName(item.getName());
        it.setAmount(item.getAmount());
        it.setQuantity(item.getQuantity());
        it.setStatus(item.getStatus());
        it.setCategory(categoryService.getCategoryByCid(cid));
        return itemRepo.save(it);
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
    public Item updateItem(UUID id, ItemDto item) {
        Optional<Item> itemData = itemRepo.findById(id);
        itemData.orElseThrow(() -> new ResourceNotFoundException("Id " + id + " not found"));
            Item _item = itemData.get();
            int itemQuantity = _item.getQuantity() + item.getQuantity();
            if(itemQuantity < 0){
                throw new ResourceNotFoundException("Quantity cannot be negative");
            }
            _item.setQuantity(itemQuantity);
            return itemRepo.save(_item);
    }

    @Override
    public Item getItemById(UUID id) {
        return itemRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id + " not found"));
    }


}
