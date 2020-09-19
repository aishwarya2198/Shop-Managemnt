package com.shopmanagement.shopmanagement.service.impl;

import com.shopmanagement.shopmanagement.dao.CategoryRepo;
import com.shopmanagement.shopmanagement.dto.CategoryDto;
import com.shopmanagement.shopmanagement.exception.ResourceNotFoundException;
import com.shopmanagement.shopmanagement.model.Category;
import com.shopmanagement.shopmanagement.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;

    public CategoryServiceImpl(CategoryRepo cateRepo) {
        this.categoryRepo = cateRepo;
    }

    @Override
    public Category addCategory(CategoryDto category) {
        Category cat = new Category();
        cat.setName(category.getName());
        cat.setType(category.getType());
        cat.setStatus(category.getStatus());
        return categoryRepo.save(cat);
    }

    @Override
    public List<Category> getCategory() {
        return categoryRepo.findAll();
    }

    @Override
    public void deleteCategory(UUID cid) {
        categoryRepo.deleteById(cid);
    }

    @Override
    public Category updateCategory(UUID cid, CategoryDto category) {
        Optional<Category> categoryData = categoryRepo.findById(cid);
        categoryData.orElseThrow(() -> new ResourceNotFoundException("Category Id " + cid + " not found"));
            Category _category = categoryData.get();
            _category.setStatus(category.getStatus());

            return categoryRepo.save(_category);

    }

    @Override
    public Category getCategoryByCid(UUID cid) {
        return categoryRepo.findById(cid).orElseThrow(() -> new ResourceNotFoundException("Category Id " + cid + " not found"));
    }

}
