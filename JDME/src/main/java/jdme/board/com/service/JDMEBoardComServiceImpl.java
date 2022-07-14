package jdme.board.com.service;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jdme.board.com.dao.JDMEBoardComDAO;
import jdme.board.com.vo.JDMEBoardComVO;


@Service
@Transactional
public class JDMEBoardComServiceImpl implements JDMEBoardComService {

	Logger logger = LogManager.getLogger(JDMEBoardComServiceImpl.class);
	
	// 서비스에서 DAO로 연결해주기 의존성 주입
	private JDMEBoardComDAO jdmeBoardComDAO;
	
	@Autowired(required=false)
	public JDMEBoardComServiceImpl(JDMEBoardComDAO jdmeBoardComDAO) {
		this.jdmeBoardComDAO = jdmeBoardComDAO;
	}
	

	// 커뮤니티 게시판 입력
	@Override
	public int jdmeBoardComInsert(JDMEBoardComVO jbcvo) {
		
		logger.info("JDMEBoardComServiceImpl jdmeBoardComInsert 함수 진입");			
		return jdmeBoardComDAO.jdmeBoardComInsert(jbcvo);
	}

	// 커뮤니티 게시판 전체조회
	@Override
	public List<JDMEBoardComVO> jdmeBoardComSelectAll(JDMEBoardComVO jbcvo) {
		
		logger.info("JDMEBoardComServiceImpl jdmeBoardComSelectAll 함수 진입");
		return jdmeBoardComDAO.jdmeBoardComSelectAll(jbcvo);
	}

	// 커뮤니티 조건 조회 커뮤니티 게시판
	@Override
	public List<JDMEBoardComVO> jdmeBoardComSelect(JDMEBoardComVO jbcvo) {
		
		logger.info("JDMEBoardComServiceImpl jdmeBoardComSelect 함수 진입");
		return jdmeBoardComDAO.jdmeBoardComSelect(jbcvo);
	}

	// 커뮤니티 게시판 수정하기
	@Override
	public int jdmeBoardComUpdate(JDMEBoardComVO jbcvo) {
		
		logger.info("JDMEBoardComServiceImpl jdmeBoardComUpdate 함수 진입");
		return jdmeBoardComDAO.jdmeBoardComUpdate(jbcvo);
	}
	
	
	// 커뮤니티 게시판 수정 할 때 비밀번호 체크하기
	@Override
	public List<JDMEBoardComVO> jdmeBoardComPwcheck(JDMEBoardComVO jbcvo) {
		
		logger.info("JDMEBoardComServiceImpl jdmeBoardComPwcheck 함수 진입");
		return jdmeBoardComDAO.jdmeBoardComPwcheck(jbcvo);
	}


	
		
	
}
