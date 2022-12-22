package com.iqbal.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iqbal.library.model.MCategory;
import com.iqbal.library.repository.CategoryRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<MCategory> getAll() throws Exception {
		return categoryRepository.findAll();
	}

	@Override
	public MCategory getById(Long id) throws Exception {
		Optional<MCategory> mCategory = categoryRepository.findById(id);
		if (mCategory.isPresent()) {
			return mCategory.get();
		} else {
			return null;
		}

	}

	@Override
	public MCategory updateCategory(Long id, MCategory mCategory) throws Exception {
		Optional<MCategory> data = categoryRepository.findById(id);
		if (data.isPresent()) {
			MCategory category = data.get();
			category.setName(mCategory.getName());
			category.setDetails(mCategory.getDetails());
			return categoryRepository.save(category);
		} else {
			return null;
		}
	}

	@Override
	public void deleteCategory(Long id) throws Exception {
		categoryRepository.deleteById(id);
	}

	@Override
	public MCategory insertCategory(MCategory mCategory) throws Exception {
		return categoryRepository.save(mCategory);
	}

}
