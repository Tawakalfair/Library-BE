package com.iqbal.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iqbal.library.model.MPublisher;
import com.iqbal.library.repository.PublisherRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PublisherServiceImpl implements PublisherService {

	@Autowired
	private PublisherRepository publisherRepository;

	@Override
	public List<MPublisher> getAll() throws Exception {
		return publisherRepository.findAll();
	}

	@Override
	public MPublisher getById(Long id) throws Exception {
		Optional<MPublisher> data = publisherRepository.findById(id);
		if (data.isPresent()) {
			return data.get();
		} else {
			return null;
		}
	}

	@Override
	public MPublisher insertPublisher(MPublisher mPublisher) throws Exception {
		return publisherRepository.save(mPublisher);
	}

	@Override
	public void updatePublisher(Long id, MPublisher mPublisher) throws Exception {
		Optional<MPublisher> data = publisherRepository.findById(id);
		if (data.isPresent()) {
			MPublisher publisher = data.get();
			publisher.setName(mPublisher.getName());
			publisher.setPhone(mPublisher.getPhone());
			publisher.setAddress(mPublisher.getAddress());
		}
	}

	@Override
	public void deletePublisher(Long id) throws Exception {
		publisherRepository.deleteById(id);
	}

}
