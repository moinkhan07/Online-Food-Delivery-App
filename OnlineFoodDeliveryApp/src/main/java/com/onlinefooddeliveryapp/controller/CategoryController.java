package com.onlinefooddeliveryapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onlinefooddeliveryapp.exception.CategoryException;
import com.onlinefooddeliveryapp.model.Category;
import com.onlinefooddeliveryapp.service.CategoryService;

@RestController
public class CategoryController{
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/categories")
	public ResponseEntity<Category> addCategory(@RequestBody Category category) throws CategoryException{
		Category savedCategory = categoryService.addCategory(category);
		return new ResponseEntity<Category>(savedCategory,HttpStatus.CREATED);
	}
	
	@PutMapping("/categories")
	public ResponseEntity<Category> updateCategory(@RequestBody Category category) throws CategoryException{
		Category updatedCategory = categoryService.updateCategory(category);
		return new ResponseEntity<Category>(updatedCategory,HttpStatus.OK);
	}
	
	@DeleteMapping("/categories/{catId}")
	public ResponseEntity<Category> removeCategory(@PathVariable("catId") Integer catId) throws CategoryException{
		Category deletedCategory = categoryService.removeCategoryByCategoryId(catId);
		return new ResponseEntity<Category>(deletedCategory,HttpStatus.OK);
	}
	
	@GetMapping("/categories/{catId}")
	public ResponseEntity<Category> viewCategory(@PathVariable("catId") Integer catId) throws CategoryException{
		Category viewCategory = categoryService.viewCategoryByCategoryId(catId);
		return new ResponseEntity<Category>(viewCategory,HttpStatus.OK);
	}
	

	@GetMapping("/categories")
	public ResponseEntity<List<Category>> viewAllCategories() throws CategoryException{
		List<Category> allCategories = categoryService.viewAllCategories();
		return new ResponseEntity<List<Category>>(allCategories,HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
