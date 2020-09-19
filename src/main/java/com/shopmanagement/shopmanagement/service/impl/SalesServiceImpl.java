package com.shopmanagement.shopmanagement.service.impl;

import com.shopmanagement.shopmanagement.dao.SalesRepo;
import com.shopmanagement.shopmanagement.dto.SalesDto;
import com.shopmanagement.shopmanagement.model.Item;
import com.shopmanagement.shopmanagement.model.Sales;
import com.shopmanagement.shopmanagement.service.ItemService;
import com.shopmanagement.shopmanagement.service.SalesService;
import org.springframework.stereotype.Service;

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


}
