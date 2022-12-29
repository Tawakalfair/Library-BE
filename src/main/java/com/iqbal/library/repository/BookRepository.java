package com.iqbal.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iqbal.library.model.MBook;

@Repository
public interface BookRepository extends JpaRepository<MBook, Long> {

}
