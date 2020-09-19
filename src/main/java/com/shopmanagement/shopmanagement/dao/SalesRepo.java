package com.shopmanagement.shopmanagement.dao;

import com.shopmanagement.shopmanagement.model.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SalesRepo extends JpaRepository<Sales, UUID> {

}
