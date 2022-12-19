package com.iqbal.library.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.iqbal.library.message.ResponseFile;
import com.iqbal.library.model.MFileDb;
import com.iqbal.library.service.FileService;

@RestController
@RequestMapping("/api")
public class FileController {

	@Autowired
	private FileService fileService;

	 @GetMapping("/files/{id}")
	  public ResponseEntity<byte[]> getFile(@PathVariable String id) {
	    MFileDb fileDb = fileService.getFile(id);

	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDb.getName() + "\"")
	        .body(fileDb.getData());
	  }

	  @GetMapping("/files")
	  public ResponseEntity<List<ResponseFile>> getListFiles() {
	    List<ResponseFile> files = fileService.getAllFiles().map(dbFile -> {
	      String fileDownloadUri = ServletUriComponentsBuilder
	          .fromCurrentContextPath()
	          .path("/files/")
	          .path(dbFile.getId())
	          .toUriString();

	      return new ResponseFile(
	          dbFile.getName(),
	          fileDownloadUri,
	          dbFile.getType(),
	          dbFile.getData().length);
	    }).collect(Collectors.toList());

	    return ResponseEntity.status(HttpStatus.OK).body(files);
	  }

}
