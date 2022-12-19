package com.iqbal.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.iqbal.library.model.MMember;
import com.iqbal.library.service.MemberService;

@RestController
@RequestMapping("/api")
public class MemberController {

	@Autowired
	private MemberService memberService;

	@GetMapping("/members")
	public ResponseEntity<?> getAllMember() {
		try {
			List<MMember> members = memberService.getAll();
			if (members.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(members, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/member/{id}")
	public ResponseEntity<?> getMember(@PathVariable("id") long id) {
		try {
			MMember mMember = memberService.getById(id);
			return new ResponseEntity<>(mMember, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/member")
	public ResponseEntity<?> addMember(@RequestParam("file") MultipartFile file, MMember mMember){
		try {
			memberService.insert(file, mMember);
			return new ResponseEntity<>("success", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
