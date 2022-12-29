package com.iqbal.library.service;

import java.util.List;

import com.iqbal.library.model.MAuthor;

public interface AuthorService {

	public List<MAuthor> getAll() throws Exception;

	public MAuthor getById(Long id) throws Exception;

	public MAuthor insertAuthor(MAuthor mAuthor) throws Exception;

	public void updateAuthor(Long id, MAuthor mAuthor) throws Exception;

	public void deleteAuthor(Long id) throws Exception;

}
