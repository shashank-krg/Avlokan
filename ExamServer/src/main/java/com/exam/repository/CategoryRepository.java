package com.exam.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.model.exam.Category;


public interface CategoryRepository extends JpaRepository<Category,UUID> {

}
