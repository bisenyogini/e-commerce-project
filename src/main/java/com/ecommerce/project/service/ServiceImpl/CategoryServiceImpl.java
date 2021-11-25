package com.ecommerce.project.service.ServiceImpl;

import com.ecommerce.project.entity.Category;
import com.ecommerce.project.exception.CategoryNotFoundException;
import com.ecommerce.project.repository.CategoryRepo;
import com.ecommerce.project.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;


    @Override
    public Integer saveCategory(Category category) {

        return categoryRepo.save(category).getCatId();
    }

    @Override
    public List<Category> getAll() {
        return categoryRepo.findAll();
    }

    @Override
    public Category GetOneCategoryById(Integer catId) {
        Optional<Category> opt = categoryRepo.findById(catId);
        if (opt.isPresent()) {
            return opt.get();
        } else {
        return opt.orElseThrow(CategoryNotFoundException::new);
        }
    }

    @Override
    public void updateOneById(Category category) {
       categoryRepo.save(category);

    }


}
