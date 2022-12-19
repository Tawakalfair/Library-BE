package com.iqbal.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iqbal.library.model.MMember;

@Repository
public interface MemberRepository extends JpaRepository<MMember, Long>{


}
