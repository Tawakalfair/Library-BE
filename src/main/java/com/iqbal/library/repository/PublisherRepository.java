package com.iqbal.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iqbal.library.model.MPublisher;

@Repository
public interface PublisherRepository extends JpaRepository<MPublisher, Long> {

}
