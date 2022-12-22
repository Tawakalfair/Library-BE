package com.iqbal.library.service;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.web.multipart.MultipartFile;

import com.iqbal.library.model.MFileDb;

public interface FileService {

	public MFileDb store(MultipartFile file) throws IOException;

	public MFileDb getFile(String id);

	public Stream<MFileDb> getAllFiles();

	public void deleteFile(String id) throws Exception;

}
