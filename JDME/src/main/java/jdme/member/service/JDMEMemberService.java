package jdme.member.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jdme.member.vo.JDMEMemberVO;


public interface JDMEMemberService {
	//인서트
	public int jdmeMemberInsert(JDMEMemberVO jmvo);
	
	//아이디중복확인
	public List<JDMEMemberVO> jdmeIdCheck(JDMEMemberVO jmvo);
	
}
