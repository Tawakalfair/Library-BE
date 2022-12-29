package com.iqbal.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iqbal.library.model.MAuthor;
import com.iqbal.library.repository.AuthorRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorRepository authorRepository;

	@Override
	public List<MAuthor> getAll() throws Exception {
		return authorRepository.findAll();
	}

	@Override
	public MAuthor getById(Long id) throws Exception {
		Optional<MAuthor> data = authorRepository.findById(id);
		if (data.isPresent()) {
			return data.get();
		} else {
			return null;
		}
	}

	@Override
	public MAuthor insertAuthor(MAuthor mAuthor) throws Exception {
		return authorRepository.save(mAuthor);
	}

	@Override
	public void updateAuthor(Long id, MAuthor mAuthor) throws Exception {
		Optional<MAuthor> data = authorRepository.findById(id);
		if (data.isPresent()) {
			MAuthor author = data.get();
			author.setFirstName(mAuthor.getFirstName());
			author.setLastName(mAuthor.getLastName());
			authorRepository.save(author);
		}

	}

	@Override
	public void deleteAuthor(Long id) throws Exception {
		authorRepository.deleteById(id);
	}

}
