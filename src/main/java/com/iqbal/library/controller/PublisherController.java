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

import com.iqbal.library.model.MPublisher;
import com.iqbal.library.service.PublisherService;

@RestController
@RequestMapping("/api")
public class PublisherController {

	@Autowired
	private PublisherService publisherService;

	@GetMapping("/publishers")
	public ResponseEntity<?> getAllPublisher() {
		try {
			List<MPublisher> mPublisher = publisherService.getAll();
			return new ResponseEntity<>(mPublisher, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/publisher/{id}")
	public ResponseEntity<?> getPublisherById(@PathVariable Long id) {
		try {
			MPublisher mPublisher = publisherService.getById(id);
			return new ResponseEntity<>(mPublisher, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/publisher")
	public ResponseEntity<?> addPublisher(@RequestBody MPublisher mPublisher) {
		try {
			publisherService.insertPublisher(mPublisher);
			return new ResponseEntity<>("success", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/publisher/{id}")
	public ResponseEntity<?> editPublisher(@PathVariable("id") long id, @RequestBody MPublisher mPublisher){
		try {
			publisherService.updatePublisher(id, mPublisher);
			return new ResponseEntity<>("success", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/publisher/{id}")
	public ResponseEntity<?> deletePublisher(@PathVariable("id") Long id){
		try {
			publisherService.deletePublisher(id);
			return new ResponseEntity<>("success", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
