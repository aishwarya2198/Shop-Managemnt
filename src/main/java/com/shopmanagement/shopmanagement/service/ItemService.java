package com.shopmanagement.shopmanagement.service;

import com.shopmanagement.shopmanagement.dto.ItemDto;
import com.shopmanagement.shopmanagement.model.Item;

import java.util.List;
import java.util.UUID;

public interface ItemService {

    Item addItem(UUID cid, ItemDto item);

    List<Item> getItems();

    List<Item> getItem(UUID cid);

    void deleteItem(UUID id);

    Item updateItem(UUID id, ItemDto item);

    Item getItemById(UUID id);

}
