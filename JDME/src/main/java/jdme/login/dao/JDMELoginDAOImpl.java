package jdme.login.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jdme.login.vo.ChangePwVO;
import jdme.login.vo.TempAuthNumVO;
import jdme.login.vo.TempPwVO;
import jdme.member.vo.JDMEMemberVO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

@Repository
public class JDMELoginDAOImpl implements JDMELoginDAO {
	
	
	Logger logger = LogManager.getLogger(JDMELoginDAOImpl.class);
	
	//DI
	@Autowired(required=false)
	private SqlSession sqlSession;
	
//로그인체크
	@Override
	public List<JDMEMemberVO> jdmeLoginCheck(JDMEMemberVO jmvo) {
		
		return sqlSession.selectList("jdmeLoginCheck", jmvo);
	}

//이메일로 ID 찾기 : 이메일체크
	@Override
	public List<JDMEMemberVO> emailCheck(JDMEMemberVO jmvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("emailCheck", jmvo);
	}
//이메일로 ID 찾기 : 인증번호입력
	@Override
	public int tempAuthNumInsert(TempAuthNumVO tvo) {
		// TODO Auto-generated method stub
		return (Integer)sqlSession.insert("tempAuthNumInsert", tvo);
	}

//이메일로 ID 찾기 : 이메일 및 인증번호로 아이디 찾기 
	@Override
	public List<JDMEMemberVO> emailIdFind(JDMEMemberVO jmvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("emailIdFind", jmvo);
	}

//아이디로 비밀번호 찾기 : 아이디 체크 	
	@Override
	public List<JDMEMemberVO> pwIdCheck(JDMEMemberVO jmvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("pwIdCheck", jmvo);
	}

// 아이디로 비밀번호 찾기 : 이메일 체크
	@Override
	public List<JDMEMemberVO> pwEmailCheck(JDMEMemberVO jmvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("pwEmailCheck", jmvo);
	}

//아이디로 비밀번호 찾기 :  임시 비밀번호 입력 : TEMP_PW 테이블
	@Override
	public int tempPwInsert(TempPwVO tvo) {
		// TODO Auto-generated method stub
		return (Integer)sqlSession.insert("tempPwInsert", tvo);
	}
//아이디로 비밀번호 찾기 : 비밀번호 변경
	@Override
	public int pwUpdate(ChangePwVO cpwvo) {
		// TODO Auto-generated method stub
		logger.info("체크!");
		return sqlSession.update("pwUpdate", cpwvo);
	}


	
}
