package com.onlinefooddeliveryapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinefooddeliveryapp.exception.CategoryException;
import com.onlinefooddeliveryapp.model.Category;
import com.onlinefooddeliveryapp.repository.CategoryRepository;
@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category addCategory(Category category) throws CategoryException {
		
		Category existingCategory = categoryRepository.findByCategoryName(category.getCategoryName());
		if (existingCategory != null) {
			throw new CategoryException("Category already exist");
		}
		return categoryRepository.save(category);
	}

	@Override
	public Category updateCategory(Category category) throws CategoryException {
		Optional<Category> optCat = categoryRepository.findById(category.getCategoryId());
		Category existingCategory = optCat.get();
		if (existingCategory.getCategoryId().equals(category.getCategoryId())) {
			return categoryRepository.save(category);
		}else {
			   throw new CategoryException("No such category exist");
		}
	}

	@Override
	public Category removeCategoryByCategoryId(Integer catId) throws CategoryException {
		Optional<Category> optCategory = categoryRepository.findById(catId);
		Category existingCategory = optCategory.get();
		if (existingCategory.getCategoryId() == catId) {
			categoryRepository.delete(existingCategory);
			return existingCategory;
		}
		throw new CategoryException("No such category exist");
		
	}

	@Override
	public Category viewCategoryByCategoryId(Integer catId) throws CategoryException {
		Optional<Category> optCategory = categoryRepository.findById(catId);
		Category existingCategory = optCategory.get();
		if (existingCategory.getCategoryId() == catId) {
			return existingCategory;
		}
		throw new CategoryException("No such category exist");
		
	}

	@Override
	public List<Category> viewAllCategories() throws CategoryException {
		List<Category> listOfCategories = categoryRepository.findAll();
		if (listOfCategories.isEmpty()) {
			throw new CategoryException("No such category exist");
		}
		else {
			return listOfCategories;
		}

	}

}
