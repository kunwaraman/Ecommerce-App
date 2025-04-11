package com.ecom.productcatalog.service;

import com.ecom.productcatalog.Repository.CategoryRepository;
import com.ecom.productcatalog.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository=categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

}
