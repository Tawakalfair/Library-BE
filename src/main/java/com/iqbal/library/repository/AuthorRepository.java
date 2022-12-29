package com.iqbal.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iqbal.library.model.MAuthor;

@Repository
public interface AuthorRepository extends JpaRepository<MAuthor, Long> {

}
