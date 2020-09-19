package com.shopmanagement.shopmanagement.controller;

import com.shopmanagement.shopmanagement.dto.ResponseDto;
import com.shopmanagement.shopmanagement.dto.SalesDto;
import com.shopmanagement.shopmanagement.service.SalesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class SalesController {

    private final SalesService salesService;

    public SalesController(SalesService salesService) {
        super();
        this.salesService = salesService;
    }

    @PostMapping("/item/{id}/addSales")
    public ResponseEntity<ResponseDto> addSales(@PathVariable(value = "id") UUID id,
                                                @RequestBody SalesDto sales) {
        return ResponseEntity.ok(new ResponseDto(true, "add item", salesService.addSales(id, sales)));
    }


}
