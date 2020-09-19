package com.shopmanagement.shopmanagement.controller;

import com.shopmanagement.shopmanagement.dto.ItemDto;
import com.shopmanagement.shopmanagement.dto.ResponseDto;
import com.shopmanagement.shopmanagement.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }


    @PostMapping("/category/{cid}/addItem")
    public ResponseEntity<ResponseDto> addItem(@PathVariable(value = "cid") UUID cid,
                                               @RequestBody ItemDto item) {
        return ResponseEntity.ok(new ResponseDto(true, "add item", itemService.addItem(cid, item)));
    }

    @GetMapping("/")
    public ResponseEntity<ResponseDto> getItems() {
        return ResponseEntity.ok(new ResponseDto(true, "show item", itemService.getItems()));
    }

    @GetMapping("/getItem")
    public ResponseEntity<ResponseDto> getItem(@RequestParam UUID cid) {
        return ResponseEntity.ok(new ResponseDto(true, "show item", itemService.getItem(cid)));
    }

    @DeleteMapping("deleteItem/{id}")
    public ResponseEntity<ResponseDto> deleteItem(@PathVariable(value = "id") UUID id) {
        itemService.deleteItem(id);
        return ResponseEntity.ok(new ResponseDto(true, "item deleted"));
    }

    @PatchMapping("/updateItem/{id}")
    public ResponseEntity<ResponseDto> updateItem(@PathVariable(value = "id") UUID id, @RequestBody ItemDto item) {
        return ResponseEntity.ok(new ResponseDto(true, "item updated", itemService.updateItem(id, item)));
    }

}
