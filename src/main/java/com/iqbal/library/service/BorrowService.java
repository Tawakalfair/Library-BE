package com.iqbal.library.service;

import java.util.List;

import com.iqbal.library.model.TBorrow;

public interface BorrowService {

	public List<TBorrow> getAll() throws Exception;

	public TBorrow getById(Long id) throws Exception;

	public TBorrow insertBorrow(TBorrow tBorrow) throws Exception;

	public void updateBorrow(Long id, TBorrow tBorrow) throws Exception;

	public void deleteBorrow(Long id) throws Exception;

}
