package com.iqbal.library.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iqbal.library.model.MBookCategory;
import com.iqbal.library.service.BookCategoryService;

@RestController
@RequestMapping("/api")
public class BookCategoryController {

	@Autowired
	public BookCategoryService bookCategoryService;

	@GetMapping("/book-categories")
	public ResponseEntity<?> getAllCategory() {
		try {
			List<MBookCategory> mBookCategories = bookCategoryService.getAll();
			return new ResponseEntity<>(mBookCategories, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/book-category/{id}")
	public ResponseEntity<?> getBookCategoryById(@PathVariable Long id) {
		try {
			MBookCategory mBookCategory = bookCategoryService.getById(id);
			return new ResponseEntity<>(mBookCategory, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/book-category")
	public ResponseEntity<?> addBookCategory(@RequestBody MBookCategory mBookCategory) {
		try {
			bookCategoryService.insertBookCategory(mBookCategory);
			return new ResponseEntity<>("success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/book-category/{id}")
	public ResponseEntity<?> editAuthor(@PathVariable("id") long id, @RequestBody MBookCategory mBookCategory){
		try {
			bookCategoryService.updateBookCategory(id, mBookCategory);
			return new ResponseEntity<>("success", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/book-category/{id}")
	public ResponseEntity<?> deleteAuthor(@PathVariable("id") Long id){
		try {
			bookCategoryService.deleteBookCategory(id);
			return new ResponseEntity<>("success", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
