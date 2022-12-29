package com.iqbal.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iqbal.library.model.MBookCategory;
import com.iqbal.library.repository.BookCategoryRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BookCategoryServiceImpl implements BookCategoryService {

	@Autowired
	private BookCategoryRepository bookCategoryRepository;

	@Override
	public List<MBookCategory> getAll() throws Exception {
		return bookCategoryRepository.findAll();
	}

	@Override
	public MBookCategory getById(Long id) throws Exception {
		Optional<MBookCategory> data = bookCategoryRepository.findById(id);
		if (data.isPresent()) {
			return data.get();
		} else {
			return null;
		}
	}

	@Override
	public MBookCategory insertBookCategory(MBookCategory mBookCategory) throws Exception {
		return bookCategoryRepository.save(mBookCategory);
	}

	@Override
	public void updateBookCategory(Long id, MBookCategory mBookCategory) throws Exception {
		Optional<MBookCategory> data = bookCategoryRepository.findById(id);
		if (data.isPresent()) {
			MBookCategory bookCategory = data.get();
			bookCategory.setmBook(mBookCategory.getmBook());
			bookCategory.setmCategory(mBookCategory.getmCategory());
			bookCategoryRepository.save(bookCategory);
		}
	}

	@Override
	public void deleteBookCategory(Long id) throws Exception {
		bookCategoryRepository.deleteById(id);
	}

}
