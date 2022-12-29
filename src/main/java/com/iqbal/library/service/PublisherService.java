package com.iqbal.library.service;

import java.util.List;

import com.iqbal.library.model.MPublisher;

public interface PublisherService {

	public List<MPublisher> getAll() throws Exception;

	public MPublisher getById(Long id) throws Exception;

	public MPublisher insertPublisher(MPublisher mPublisher) throws Exception;

	public void updatePublisher(Long id, MPublisher mPublisher) throws Exception;

	public void deletePublisher(Long id) throws Exception;

}
