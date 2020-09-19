package com.shopmanagement.shopmanagement.dao;

import com.shopmanagement.shopmanagement.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ItemRepo extends JpaRepository<Item, UUID> {

    List<Item> findByCategoryCid(UUID cid);

}
