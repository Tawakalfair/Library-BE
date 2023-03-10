package com.iqbal.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iqbal.library.model.MFileDb;
import com.iqbal.library.model.MMember;
import com.iqbal.library.repository.MemberRepository;
import com.iqbal.library.util.Util;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private FileService fileService;

	@Override
	public MMember insert(MultipartFile file, MMember mMember) throws Exception {
		Util util = new Util();
		MFileDb mFileDb = fileService.store(file);
		mMember.setIdentificationFileId(mFileDb.getId());
		String randomCode = util.generateRandomAlphanumeric();
		mMember.setUniqueCode(randomCode + mMember.getPhone());
		mMember.setIsActive(true);
		return memberRepository.save(mMember);
	}

	@Override
	public MMember getById(Long id) throws Exception {
		Optional<MMember> data = memberRepository.findById(id);
		if (data.isPresent()) {
			return data.get();
		} else {
			return null;
		}
	}

	@Override
	public List<MMember> getAll() throws Exception {
		return memberRepository.findAll();
	}

	@Override
	public MMember updateMember(long id, MMember member) throws Exception {
		Optional<MMember> data = memberRepository.findById(id);
		MMember mMember = data.get();
		mMember.setName(member.getName());
		mMember.setNik(member.getNik());
		mMember.setPhone(member.getPhone());
		mMember.setAddress(member.getAddress());
		return memberRepository.save(mMember);
	}

	@Override
	public void deleteMember(Long id) throws Exception {
		Optional<MMember> data = memberRepository.findById(id);
		memberRepository.deleteById(id);
		fileService.deleteFile(data.get().getIdentificationFileId());
	}

}
