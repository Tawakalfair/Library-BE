package com.iqbal.library.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iqbal.library.model.TBorrow;
import com.iqbal.library.repository.BorrowRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BorrowServiceImpl implements BorrowService {

	@Autowired
	private BorrowRepository borrowRepository;

	@Override
	public List<TBorrow> getAll() throws Exception {
		return borrowRepository.findAll();
	}

	@Override
	public TBorrow getById(Long id) throws Exception {
		Optional<TBorrow> data = borrowRepository.findById(id);
		if (data.isPresent()) {
			return data.get();
		} else {
			return null;
		}
	}

	@Override
	public TBorrow insertBorrow(TBorrow tBorrow) throws Exception {
		tBorrow.setDateBorrowed(new Timestamp(System.currentTimeMillis()));
		return borrowRepository.save(tBorrow);
	}

	@Override
	public void updateBorrow(Long id, TBorrow tBorrow) throws Exception {
		Optional<TBorrow> data = borrowRepository.findById(id);
		if (data.isPresent()) {
			TBorrow borrow = data.get();
			borrow.setDueDate(tBorrow.getDueDate());
			borrow.setMBook(tBorrow.getMBook());
			borrow.setMMember(tBorrow.getMMember());
			borrowRepository.save(borrow);
		}

	}

	@Override
	public void deleteBorrow(Long id) throws Exception {
		borrowRepository.deleteById(id);
	}

}
