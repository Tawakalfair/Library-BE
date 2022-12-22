package com.iqbal.library.service;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.iqbal.library.model.MFileDb;
import com.iqbal.library.repository.FileRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class FileServiceImpl implements FileService {

	@Autowired
	private FileRepository fileRepository;

	@Override
	public MFileDb store(MultipartFile file) throws IOException {
		String filename = StringUtils.cleanPath(file.getOriginalFilename());
		MFileDb mFileDb = new MFileDb();
		mFileDb.setName(filename);
		mFileDb.setType(file.getContentType());
		mFileDb.setData(file.getBytes());

		return fileRepository.save(mFileDb);
	}

	@Override
	public MFileDb getFile(String id) {
		return fileRepository.findById(id).get();
	}

	@Override
	public Stream<MFileDb> getAllFiles() {
		return fileRepository.findAll().stream();
	}

	@Override
	public void deleteFile(String id) throws Exception {
		fileRepository.deleteById(id);
	}

}
