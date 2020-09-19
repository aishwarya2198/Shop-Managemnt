package com.shopmanagement.shopmanagement.service;

import com.shopmanagement.shopmanagement.dto.SalesDto;
import com.shopmanagement.shopmanagement.model.Sales;

import java.util.UUID;

public interface SalesService {

    Sales addSales(UUID id, SalesDto sales);
}
