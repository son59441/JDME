package jdme.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import jdme.member.vo.JDMEMemberVO;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

@Primary
public interface JDMEMemberDAO {
	//I
	public int jdmeMemberInsert(JDMEMemberVO jmvo);
	
	//아이디중복확인
	public List<JDMEMemberVO> jdmeIdCheck(JDMEMemberVO jmvo);
	
}
