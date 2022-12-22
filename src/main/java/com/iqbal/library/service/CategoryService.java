package com.iqbal.library.service;

import java.util.List;

import com.iqbal.library.model.MCategory;

public interface CategoryService {

	public List<MCategory> getAll() throws Exception;

	public MCategory getById(Long id) throws Exception;

	public MCategory insertCategory(MCategory mCategory) throws Exception;

	public MCategory updateCategory(Long id, MCategory mCategory) throws Exception;

	public void deleteCategory(Long id) throws Exception;

}
