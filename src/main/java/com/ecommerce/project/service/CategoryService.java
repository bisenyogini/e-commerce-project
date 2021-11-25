package com.ecommerce.project.service;

import com.ecommerce.project.entity.Category;

import java.util.List;


public interface CategoryService {
 Integer saveCategory(Category category);
 List<Category>getAll();
Category GetOneCategoryById(Integer catId);
 void updateOneById(Category category);

}
