package com.shopmanagement.shopmanagement.service;

import com.shopmanagement.shopmanagement.dto.CategoryDto;
import com.shopmanagement.shopmanagement.model.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    Category addCategory(CategoryDto category);

    List<Category> getCategory();

    void deleteCategory(UUID cid);

    Category updateCategory(UUID cid, CategoryDto category);

    Category getCategoryByCid(UUID cid);
}
