package com.iqbal.library.service;

import java.util.List;

import com.iqbal.library.model.MBookAuthor;

public interface BookAuthorService {

	public List<MBookAuthor> getAll() throws Exception;

	public MBookAuthor getById(Long id) throws Exception;

	public MBookAuthor insertBookAuthor(MBookAuthor mBookAuthor) throws Exception;

	public void updateBookAuthor(Long id, MBookAuthor mBookAuthor) throws Exception;

	public void deleteBookAuthor(Long id) throws Exception;

}
