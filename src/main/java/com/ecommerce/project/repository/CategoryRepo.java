package com.ecommerce.project.repository;

import com.ecommerce.project.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface CategoryRepo extends JpaRepository<Category,Integer>
{

}

