package jdme.login.service;

import java.util.List;

import jdme.login.dao.JDMELoginDAO;
import jdme.login.vo.ChangePwVO;
import jdme.login.vo.TempAuthNumVO;
import jdme.login.vo.TempPwVO;
import jdme.member.vo.JDMEMemberVO;



import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class JDMELoginServiceImpl implements JDMELoginService {
	
	Logger logger = LogManager.getLogger(JDMELoginServiceImpl.class);
	
	@Autowired(required=false)
	private JDMELoginDAO jDMELoginDAO;
//로그인체크
	@Override
	public List<JDMEMemberVO> jdmeLoginCheck(JDMEMemberVO jmvo) {
		
		return jDMELoginDAO.jdmeLoginCheck(jmvo);
	}
//이메일체크 : 이메일
	@Override
	public List<JDMEMemberVO> emailCheck(JDMEMemberVO jmvo) {
		// TODO Auto-generated method stub
		logger.info("JDMELoginServiceImpl emailCheck() 함수 진입 >>> : ");
		return jDMELoginDAO.emailCheck(jmvo);
	}
//이메일체크 : 인증번호 발부
	@Override
	public int tempAuthNumInsert(TempAuthNumVO tvo) {
		// TODO Auto-generated method stub
		logger.info("JDMELoginServiceImpl TempAuthNumVO() 함수 진입 >>> : ");
		return jDMELoginDAO.tempAuthNumInsert(tvo);
	}
//이메일체크 : 인증번호로 아이디찾기
	@Override
	public List<JDMEMemberVO> emailIdFind(JDMEMemberVO jmvo) {
		// TODO Auto-generated method stub
		logger.info("JDMELoginServiceImpl emailIdFind() 함수 진입 >>> : ");
		return jDMELoginDAO.emailIdFind(jmvo);
	}
//비번찾기 : 아이디체크
	@Override
	public List<JDMEMemberVO> pwIdCheck(JDMEMemberVO jmvo) {
		// TODO Auto-generated method stub
		logger.info("JDMELoginServiceImpl pwIdCheck() 함수 진입 >>> : ");
		return jDMELoginDAO.pwIdCheck(jmvo);
	}
//비번찾기 : 이메일 체크
	@Override
	public List<JDMEMemberVO> pwEmailCheck(JDMEMemberVO jmvo) {
		// TODO Auto-generated method stub
		logger.info("JDMELoginServiceImpl pwEmailCheck() 함수 진입 >>> : ");
		return jDMELoginDAO.pwEmailCheck(jmvo);
	}
//비번찾기 : 임시비밀번호 입력 : TEMP_PW 테이블
	@Override
	public int tempPwInsert(TempPwVO tvo) {
		// TODO Auto-generated method stub
		logger.info("JDMELoginServiceImpl tempPwInsert() 함수 진입 >>> : ");
		return jDMELoginDAO.tempPwInsert(tvo);
	}
//비번찾기 : 비밀번호 변경
	@Override
	public int pwUpdate(ChangePwVO cpwvo) {
		// TODO Auto-generated method stub
		return jDMELoginDAO.pwUpdate(cpwvo);
	}
	
}
