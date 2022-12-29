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

import com.iqbal.library.model.MBookAuthor;
import com.iqbal.library.service.BookAuthorService;

@RestController
@RequestMapping("/api")
public class BookAuthorController {

	@Autowired
	public BookAuthorService bookAuthorService;

	@GetMapping("/book-authors")
	public ResponseEntity<?> getAllAuthor() {
		try {
			List<MBookAuthor> mBookAuthor = bookAuthorService.getAll();
			return new ResponseEntity<>(mBookAuthor, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/book-author/{id}")
	public ResponseEntity<?> getBookAuthorById(@PathVariable Long id) {
		try {
			MBookAuthor mBookAuthor = bookAuthorService.getById(id);
			return new ResponseEntity<>(mBookAuthor, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/book-author")
	public ResponseEntity<?> addBookAuthor(@RequestBody MBookAuthor mBookAuthor) {
		try {
			bookAuthorService.insertBookAuthor(mBookAuthor);
			return new ResponseEntity<>("success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/book-author/{id}")
	public ResponseEntity<?> editAuthor(@PathVariable("id") long id, @RequestBody MBookAuthor mBookAuthor){
		try {
			bookAuthorService.updateBookAuthor(id, mBookAuthor);
			return new ResponseEntity<>("success", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/book-author/{id}")
	public ResponseEntity<?> deleteAuthor(@PathVariable("id") Long id){
		try {
			bookAuthorService.deleteBookAuthor(id);
			return new ResponseEntity<>("success", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
