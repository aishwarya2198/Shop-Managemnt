package com.shopmanagement.shopmanagement.service;

import com.shopmanagement.shopmanagement.dto.SalesDto;
import com.shopmanagement.shopmanagement.model.Sales;

import java.util.List;
import java.util.UUID;

public interface SalesService {

    Sales addSales(UUID id, SalesDto sales);

    List<Sales> getSales();

    List<Sales> getSale(UUID id);

    void deleteSales(UUID sid);

    Sales updateSales(UUID sid, SalesDto sales);
}
