package com.iqbal.library.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.iqbal.library.model.MMember;

public interface MemberService {

	public MMember insert(MultipartFile file, MMember mMember) throws Exception;

	public MMember getById(Long id) throws Exception;

	public List<MMember> getAll() throws Exception;

	public MMember updateMember(long id, MMember mMember) throws Exception;

	public void deleteMember(Long id) throws Exception;

}
