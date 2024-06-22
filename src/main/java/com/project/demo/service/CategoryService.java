package com.project.demo.service;


import java.util.List;
import java.util.Optional;

import com.project.demo.repository.CategoryRepository;
import org.springframework.stereotype.Service;


import com.project.demo.entity.Category;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CategoryService {
    
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> listCategories(){
        return categoryRepository.findAll();
    }

    public void createCategory(Category category){
        categoryRepository.save(category);
    }

    public Category readCategory(String categoryName){
        return categoryRepository.findByCategoryName(categoryName);
    }

    public Optional<Category> readCategory(Integer categoryId){
        return categoryRepository.findById(categoryId);
    }

    public void updateCategory(Integer categoryId, Category newCategory){
        Category category = categoryRepository.findById(categoryId).get();
        category.setCategoryName(newCategory.getCategoryName());
        category.setDescription(newCategory.getDescription());
        category.setProducts(newCategory.getProducts());
        category.setImgUrl(newCategory.getImgUrl());

        categoryRepository.save(category);
    }
}
