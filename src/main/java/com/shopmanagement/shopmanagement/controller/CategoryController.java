package com.shopmanagement.shopmanagement.controller;

import com.shopmanagement.shopmanagement.dto.CategoryDto;
import com.shopmanagement.shopmanagement.dto.ResponseDto;
import com.shopmanagement.shopmanagement.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/category")
    public ResponseEntity<ResponseDto> addCategory(@RequestBody CategoryDto category) {
        return ResponseEntity.ok(new ResponseDto(true, "add category", categoryService.addCategory(category)));
    }

    @GetMapping("/categories")
    public ResponseEntity<ResponseDto> getCategory() {
        return ResponseEntity.ok(new ResponseDto(true, "show category", categoryService.getCategory()));
    }


    @DeleteMapping("/category/{cid}")
    public ResponseEntity<ResponseDto> deleteCategory(@PathVariable("cid") UUID cid) {
        categoryService.deleteCategory(cid);
        return ResponseEntity.ok(new ResponseDto(true, "category deleted"));
    }

    @PatchMapping("/category/{cid}")
    public ResponseEntity<ResponseDto> updateCategory(@PathVariable UUID cid, @RequestBody CategoryDto category) {
        return ResponseEntity.ok(new ResponseDto(true, "category updated", categoryService.updateCategory(cid, category)));
    }
}
