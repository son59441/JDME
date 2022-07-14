package jdme.login.dao;

import java.util.List;

import org.springframework.context.annotation.Primary;

import jdme.login.vo.ChangePwVO;
import jdme.login.vo.TempAuthNumVO;
import jdme.login.vo.TempPwVO;
import jdme.member.vo.JDMEMemberVO;
@Primary
public interface JDMELoginDAO {
	//로그인 체크
	public List<JDMEMemberVO> jdmeLoginCheck(JDMEMemberVO jmvo);
	
	// 이메일로 ID 찾기 -------------------------------
	// 1. 이메일 체크 
	public List<JDMEMemberVO> emailCheck(JDMEMemberVO jmvo);
	// 2. 인증번호 입력 : TEMP_AUTH_NUM 테이블
	public int tempAuthNumInsert(TempAuthNumVO tvo);
	// 3. 이메일 및 인증번호로 아이디 찾기 
	public List<JDMEMemberVO> emailIdFind(JDMEMemberVO jmvo);
	
	// 아이디로 비밀번호 찾기 -------------------------------
	// 1. 아이디 체크 
	public List<JDMEMemberVO> pwIdCheck(JDMEMemberVO jmvo);
	// 2. 이메일 체크 
	public List<JDMEMemberVO> pwEmailCheck(JDMEMemberVO jmvo);
	// 3. 임시 비밀번호 입력 : TEMP_PW 테이블
	public int tempPwInsert(TempPwVO tvo);
	// 4. 비밀번호 변경 
	public int pwUpdate(ChangePwVO cpwvo);
}
