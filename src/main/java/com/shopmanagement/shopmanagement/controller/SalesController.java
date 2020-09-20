package com.shopmanagement.shopmanagement.controller;

import com.shopmanagement.shopmanagement.dto.ItemDto;
import com.shopmanagement.shopmanagement.dto.ResponseDto;
import com.shopmanagement.shopmanagement.dto.SalesDto;
import com.shopmanagement.shopmanagement.service.SalesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class SalesController {

    private final SalesService salesService;

    public SalesController(SalesService salesService) {
        super();
        this.salesService = salesService;
    }

    @PostMapping("/item/{id}/sales")
    public ResponseEntity<ResponseDto> addSales(@PathVariable(value = "id") UUID id,
                                                @RequestBody SalesDto sales) {
        return ResponseEntity.ok(new ResponseDto(true, "add sales", salesService.addSales(id, sales)));
    }

    @GetMapping("/sales")
    public ResponseEntity<ResponseDto> getSales() {
        return ResponseEntity.ok(new ResponseDto(true, "show sales", salesService.getSales()));
    }

    @GetMapping("/sale")
    public ResponseEntity<ResponseDto> getSale(@RequestParam UUID id) {
        return ResponseEntity.ok(new ResponseDto(true, "show sales by id", salesService.getSale(id)));
    }

    @DeleteMapping("/sales/{sid}")
    public ResponseEntity<ResponseDto> deleteSales(@PathVariable(value = "sid") UUID sid) {
        salesService.deleteSales(sid);
        return ResponseEntity.ok(new ResponseDto(true, "sales deleted"));
    }

    @PatchMapping("/sales/{sid}")
    public ResponseEntity<ResponseDto> updateSales(@PathVariable(value = "sid") UUID sid, @RequestBody SalesDto sales) {
        return ResponseEntity.ok(new ResponseDto(true, "sales updated", salesService.updateSales(sid, sales)));
    }

}
