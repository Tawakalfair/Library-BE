package com.iqbal.library.service;

import java.util.List;

import com.iqbal.library.model.MShelf;

public interface ShelfService {

	public List<MShelf> getAll() throws Exception;

	public MShelf getById(Long id) throws Exception;

	public MShelf insertShelf(MShelf mShelf) throws Exception;

	public void updateShelf(Long id, MShelf mShelf) throws Exception;

	public void deleteShelf(Long id) throws Exception;

}
