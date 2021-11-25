package com.ecommerce.project.repository;

import com.ecommerce.project.entity.CategoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface CatTypeRepo extends JpaRepository<CategoryType,Integer> {

    @Query("SELECT catTypeId,catType FROM CategoryType")
    List<Object[]> getCatTypeIdAndName();
}
