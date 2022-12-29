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

import com.iqbal.library.model.MAuthor;
import com.iqbal.library.service.AuthorService;

@RestController
@RequestMapping("/api")
public class AuthorController {

	@Autowired
	public AuthorService authorService;

	@GetMapping("/authors")
	public ResponseEntity<?> getAllAuthor() {
		try {
			List<MAuthor> mAuthor = authorService.getAll();
			return new ResponseEntity<>(mAuthor, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/author/{id}")
	public ResponseEntity<?> getCategoryById(@PathVariable Long id) {
		try {
			MAuthor mAuthor = authorService.getById(id);
			return new ResponseEntity<>(mAuthor, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/author")
	public ResponseEntity<?> addCategory(@RequestBody MAuthor mAuthor) {
		try {
			authorService.insertAuthor(mAuthor);
			return new ResponseEntity<>("success", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/author/{id}")
	public ResponseEntity<?> editAuthor(@PathVariable("id") long id, @RequestBody MAuthor mAuthor){
		try {
			authorService.updateAuthor(id, mAuthor);
			return new ResponseEntity<>("success", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/author/{id}")
	public ResponseEntity<?> deleteAuthor(@PathVariable("id") Long id){
		try {
			authorService.deleteAuthor(id);
			return new ResponseEntity<>("success", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
