package com.iqbal.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iqbal.library.model.MFileDb;

@Repository
public interface FileRepository extends JpaRepository<MFileDb, String> {

}
