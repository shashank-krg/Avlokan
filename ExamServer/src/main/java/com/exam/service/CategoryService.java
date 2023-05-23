package com.exam.service;

import com.exam.model.exam.Category;
import java.util.Set;
import java.util.UUID;

public interface CategoryService {

	public Category addCategory(Category category);
	public Category updateCategory(Category category);
	
	public Set<Category> getCategories();
	
	public Category getCategory(UUID categoryId);
	
	public void deleteCategory(UUID categoryId);
}
