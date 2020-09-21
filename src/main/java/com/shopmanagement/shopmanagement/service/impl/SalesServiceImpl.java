package com.shopmanagement.shopmanagement.service.impl;

import com.shopmanagement.shopmanagement.dao.SalesRepo;
import com.shopmanagement.shopmanagement.dto.SalesDto;
import com.shopmanagement.shopmanagement.exception.BadRequestException;
import com.shopmanagement.shopmanagement.exception.ResourceNotFoundException;
import com.shopmanagement.shopmanagement.model.Item;
import com.shopmanagement.shopmanagement.model.Sales;
import com.shopmanagement.shopmanagement.service.ItemService;
import com.shopmanagement.shopmanagement.service.SalesService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SalesServiceImpl implements SalesService {

    private final SalesRepo salesRepo;
    private final ItemService itemService;

    public SalesServiceImpl(SalesRepo salesRepo, ItemService itemService) {
        this.salesRepo = salesRepo;
        this.itemService = itemService;
    }

    @Override
    public Sales addSales(UUID id, SalesDto sales) {
        Sales sale = new Sales();
        sale.setAmount(sales.getAmount());
        sale.setQuantity(sales.getQuantity());
        Item item = itemService.getItemById(id);
        item.setQuantity(item.getQuantity() - sale.getQuantity());
        sale.setItem(item);
        return salesRepo.save(sale);
    }

    @Override
    public List<Sales> getSales(){
        return salesRepo.findAll();
    }

    @Override
    public List<Sales> getSale(UUID id){
        List<Sales> salesList = salesRepo.findByItemId(id);
        if(salesList.isEmpty()){
            throw new ResourceNotFoundException("Id "+id+" not found");
        }
        return salesList;
    }

    @Override
    public void deleteSales(UUID sid){
        salesRepo.deleteById(sid);
    }

    @Override
    public Sales updateSales(UUID sid, SalesDto salesDto){
        Optional<Sales> salesData = salesRepo.findById(sid);
        salesData.orElseThrow(() -> new ResourceNotFoundException("Sales Id " + sid + " not found"));
        Sales sales = salesData.get();
        int salesQuantity = sales.getQuantity() + salesDto.getQuantity();
        if(salesQuantity < 0){
            throw new BadRequestException("Quantity cannot be negative");
        }
        if (salesDto.getQuantity() != 0){ sales.setQuantity(salesQuantity);}
        if (salesDto.getAmount() != 0){ sales.setAmount(salesDto.getAmount());}
        return salesRepo.save(sales);
    }
}
