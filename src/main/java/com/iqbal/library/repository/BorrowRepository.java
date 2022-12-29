package com.iqbal.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iqbal.library.model.TBorrow;

@Repository
public interface BorrowRepository extends JpaRepository<TBorrow, Long> {

}
