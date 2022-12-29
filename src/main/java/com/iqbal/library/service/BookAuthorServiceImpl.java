package com.iqbal.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iqbal.library.model.MBookAuthor;
import com.iqbal.library.repository.BookAuthorRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BookAuthorServiceImpl implements BookAuthorService {

	@Autowired
	private BookAuthorRepository bookAuthorRepository;

	@Override
	public List<MBookAuthor> getAll() throws Exception {
		return bookAuthorRepository.findAll();
	}

	@Override
	public MBookAuthor getById(Long id) throws Exception {
		Optional<MBookAuthor> data = bookAuthorRepository.findById(id);
		if (data.isPresent()) {
			return data.get();
		} else {
			return null;
		}
	}

	@Override
	public MBookAuthor insertBookAuthor(MBookAuthor mBookAuthor) throws Exception {
		return bookAuthorRepository.save(mBookAuthor);
	}

	@Override
	public void updateBookAuthor(Long id, MBookAuthor mBookAuthor) throws Exception {
		Optional<MBookAuthor> data = bookAuthorRepository.findById(id);
		if (data.isPresent()) {
			MBookAuthor bookAuthor = data.get();
			bookAuthor.setmAuthor(mBookAuthor.getmAuthor());
			bookAuthor.setmBook(mBookAuthor.getmBook());
			bookAuthorRepository.save(bookAuthor);
		}
	}

	@Override
	public void deleteBookAuthor(Long id) throws Exception {
		bookAuthorRepository.deleteById(id);
	}

}
