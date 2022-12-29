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

import com.iqbal.library.model.MShelf;
import com.iqbal.library.service.ShelfService;

@RestController
@RequestMapping("/api")
public class ShelfController {

	@Autowired
	private ShelfService shelfService;

	@GetMapping("/shelves")
	public ResponseEntity<?> getAllShelf() {
		try {
			List<MShelf> mShelf = shelfService.getAll();
			return new ResponseEntity<>(mShelf, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/shelf/{id}")
	public ResponseEntity<?> getShelfById(@PathVariable Long id) {
		try {
			MShelf mShelf = shelfService.getById(id);
			return new ResponseEntity<>(mShelf, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/shelf")
	public ResponseEntity<?> addShelf(@RequestBody MShelf mShelf) {
		try {
			shelfService.insertShelf(mShelf);
			return new ResponseEntity<>("success", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/shelf/{id}")
	public ResponseEntity<?> editShelf(@PathVariable("id") long id, @RequestBody MShelf mShelf){
		try {
			shelfService.updateShelf(id, mShelf);
			return new ResponseEntity<>("success", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/shelf/{id}")
	public ResponseEntity<?> deletePublisher(@PathVariable("id") Long id){
		try {
			shelfService.deleteShelf(id);
			return new ResponseEntity<>("success", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
