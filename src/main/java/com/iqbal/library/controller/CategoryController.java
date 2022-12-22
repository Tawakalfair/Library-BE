package com.iqbal.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iqbal.library.model.MCategory;
import com.iqbal.library.service.CategoryService;

@Controller
@RequestMapping("/api")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/categories")
	public ResponseEntity<?> getAllCategory() {
		try {
			List<MCategory> mCategory = categoryService.getAll();
			return new ResponseEntity<>(mCategory, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/category/{id}")
	public ResponseEntity<?> getCategoryById(@PathVariable Long id) {
		try {
			MCategory mCategory = categoryService.getById(id);
			return new ResponseEntity<>(mCategory, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/category")
	public ResponseEntity<?> addCategory(@RequestBody MCategory mCategory) {
		try {
			categoryService.insertCategory(mCategory);
			return new ResponseEntity<>("success", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/category/{id}")
	public ResponseEntity<?> editCategory(@PathVariable("id") long id, @RequestBody MCategory mCategory){
		try {
			categoryService.updateCategory(id, mCategory);
			return new ResponseEntity<>("success", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/category/{id}")
	public ResponseEntity<?> deleteMember(@PathVariable("id") Long id){
		try {
			categoryService.deleteCategory(id);
			return new ResponseEntity<>("success", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
