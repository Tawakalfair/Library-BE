package com.iqbal.library.service;

import java.util.List;

import com.iqbal.library.model.MBook;

public interface BookService {

	public List<MBook> getAll() throws Exception;

	public MBook getById(Long id) throws Exception;

	public MBook insertBook(MBook mBook) throws Exception;

	public void updateBook(Long id, MBook mBook) throws Exception;

	public void deleteBook(Long id) throws Exception;

}
