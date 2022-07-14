package jdme.member.service;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jdme.member.dao.JDMEMemberDAO;
import jdme.member.vo.JDMEMemberVO;

@Service
@Transactional
public class JDMEMemberServiceImpl implements JDMEMemberService {
//로그선언
	Logger logger = LogManager.getLogger(JDMEMemberServiceImpl.class);

	//다오 오토와이어드
	@Autowired(required=false)
	private JDMEMemberDAO jDMEMemberDAO;
	
	//인서트
	@Override
	public int jdmeMemberInsert(JDMEMemberVO jmvo) {
	
		return jDMEMemberDAO.jdmeMemberInsert(jmvo);
	}
	
	//회원아이디중복확인
	@Override
	public List<JDMEMemberVO> jdmeIdCheck(JDMEMemberVO jmvo) {
		
		return jDMEMemberDAO.jdmeIdCheck(jmvo);
	}
	
	
	
	
	
	
	
	
}

