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

import com.iqbal.library.model.MBook;
import com.iqbal.library.service.BookService;

@RestController
@RequestMapping("/api")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping("/books")
	public ResponseEntity<?> getAllShelf() {
		try {
			List<MBook> mBook = bookService.getAll();
			return new ResponseEntity<>(mBook, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/book/{id}")
	public ResponseEntity<?> getBookById(@PathVariable Long id) {
		try {
			MBook mBook = bookService.getById(id);
			return new ResponseEntity<>(mBook, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/book")
	public ResponseEntity<?> addShelf(@RequestBody MBook mBook) {
		try {
			bookService.insertBook(mBook);
			return new ResponseEntity<>("success", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/book/{id}")
	public ResponseEntity<?> editShelf(@PathVariable("id") long id, @RequestBody MBook mBook){
		try {
			bookService.updateBook(id, mBook);
			return new ResponseEntity<>("success", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/book/{id}")
	public ResponseEntity<?> deletePublisher(@PathVariable("id") Long id){
		try {
			bookService.deleteBook(id);
			return new ResponseEntity<>("success", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
