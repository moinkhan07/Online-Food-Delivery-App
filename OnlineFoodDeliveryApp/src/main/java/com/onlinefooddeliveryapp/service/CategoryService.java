package com.onlinefooddeliveryapp.service;

import java.util.List;

import com.onlinefooddeliveryapp.exception.CategoryException;
import com.onlinefooddeliveryapp.model.Category;

public interface CategoryService {
	
	public Category addCategory(Category category)throws CategoryException;
	
	public Category updateCategory(Category category) throws CategoryException;
	
	public Category removeCategoryByCategoryId(Integer catId) throws CategoryException;
	
	public Category viewCategoryByCategoryId(Integer catId) throws CategoryException;
	
	public List<Category> viewAllCategories() throws CategoryException;

}
