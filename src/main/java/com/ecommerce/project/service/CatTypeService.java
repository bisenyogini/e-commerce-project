package com.ecommerce.project.service;

import com.ecommerce.project.entity.CategoryType;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface CatTypeService {
    Integer saveCatType(CategoryType categoryType);
    List<CategoryType> getAllCatType();
    CategoryType getOneCatTypeById(Integer catTypeId);
   void updateCatType(CategoryType categoryType);
    void deleteCatType(Integer catTypeId);
   Map<Integer,String> getCatTypeIdAndName();
}
