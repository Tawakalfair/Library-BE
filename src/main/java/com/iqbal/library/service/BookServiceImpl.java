package com.iqbal.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iqbal.library.model.MBook;
import com.iqbal.library.repository.BookRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<MBook> getAll() throws Exception {
		return bookRepository.findAll();
	}

	@Override
	public MBook getById(Long id) throws Exception {
		Optional<MBook> data = bookRepository.findById(id);
		if (data.isPresent()) {
			return data.get();
		} else {
			return null;
		}
	}

	@Override
	public MBook insertBook(MBook mBook) throws Exception {
		return bookRepository.save(mBook);
	}

	@Override
	public void updateBook(Long id, MBook mBook) throws Exception {
		Optional<MBook> data = bookRepository.findById(id);
		if (data.isPresent()) {
			MBook book = data.get();
			book.setTitle(mBook.getTitle());
			book.setTotalCopy(mBook.getTotalCopy());
			book.setShelfId(mBook.getShelfId());
			book.setPublisherId(mBook.getPublisherId());
		}
	}

	@Override
	public void deleteBook(Long id) throws Exception {
		bookRepository.deleteById(id);
	}

}
