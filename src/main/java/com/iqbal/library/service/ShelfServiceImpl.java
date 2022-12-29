package com.iqbal.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iqbal.library.model.MShelf;
import com.iqbal.library.repository.ShelfRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ShelfServiceImpl implements ShelfService {

	@Autowired
	private ShelfRepository shelfRepository;

	@Override
	public List<MShelf> getAll() throws Exception {
		return shelfRepository.findAll();
	}

	@Override
	public MShelf getById(Long id) throws Exception {
		Optional<MShelf> data = shelfRepository.findById(id);
		if (data.isPresent()) {
			return data.get();
		} else {
			return null;
		}
	}

	@Override
	public MShelf insertShelf(MShelf mShelf) throws Exception {
		return shelfRepository.save(mShelf);
	}

	@Override
	public void updateShelf(Long id, MShelf mShelf) throws Exception {
		Optional<MShelf> data = shelfRepository.findById(id);
		if (data.isPresent()) {
			MShelf shelf = data.get();
			shelf.setShelfCode(mShelf.getShelfCode());
			shelf.setFloor(mShelf.getFloor());
		}
	}

	@Override
	public void deleteShelf(Long id) throws Exception {
		shelfRepository.deleteById(id);
	}

}
