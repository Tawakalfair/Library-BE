package com.iqbal.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iqbal.library.model.MBookAuthor;

@Repository
public interface BookAuthorRepository extends JpaRepository<MBookAuthor, Long> {

}
