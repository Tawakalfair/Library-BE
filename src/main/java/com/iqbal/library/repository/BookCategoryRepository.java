package com.iqbal.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iqbal.library.model.MBookCategory;

@Repository
public interface BookCategoryRepository extends JpaRepository<MBookCategory, Long> {

}
