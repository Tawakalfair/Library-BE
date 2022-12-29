package com.iqbal.library.service;

import java.util.List;

import com.iqbal.library.model.MBookCategory;

public interface BookCategoryService {

	public List<MBookCategory> getAll() throws Exception;

	public MBookCategory getById(Long id) throws Exception;

	public MBookCategory insertBookCategory(MBookCategory mBookCategory) throws Exception;

	public void updateBookCategory(Long id, MBookCategory mBookCategory) throws Exception;

	public void deleteBookCategory(Long id) throws Exception;

}
