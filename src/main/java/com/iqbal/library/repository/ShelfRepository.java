package com.iqbal.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iqbal.library.model.MShelf;

@Repository
public interface ShelfRepository extends JpaRepository<MShelf, Long> {

}
