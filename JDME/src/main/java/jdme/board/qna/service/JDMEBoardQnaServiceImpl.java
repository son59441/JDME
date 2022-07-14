package jdme.board.qna.service;

import java.util.List;

import jdme.board.qna.dao.JDMEBoardQnaDAO;
import jdme.board.qna.vo.JDMEBoardQnaVO;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class JDMEBoardQnaServiceImpl implements JDMEBoardQnaService {

	Logger logger = LogManager.getLogger(JDMEBoardQnaServiceImpl.class);
	
	// 서비스에서 DAO로 연결해주기 의존성 주입
	@Autowired(required=false)
	private JDMEBoardQnaDAO jdmeBoardQnaDAO;
	
	// 질문 게시판 입력
	@Override
	public int jdmeBoardQnaInsert(JDMEBoardQnaVO jbqvo) {
		
		logger.info("JDMEBoardQnaServiceImpl jdmeBoardQnaInsert 함수 진입");
		return jdmeBoardQnaDAO.jdmeBoardQnaInsert(jbqvo);
	}

	// 질문 게시판 전체 조회
	@Override
	public List<JDMEBoardQnaVO> jdmeBoardQnaSelectAll(JDMEBoardQnaVO jbqvo) {
		
		logger.info("JDMEBoardQnaServiceImpl jdmeBoardNoticeSelectAll 함수 진입");
		return jdmeBoardQnaDAO.jdmeBoardQnaSelectAll(jbqvo);
	}

	// 질문 게시판 조건 조회
	@Override
	public List<JDMEBoardQnaVO> jdmeBoardQnaSelect(JDMEBoardQnaVO jbqvo) {
		
		logger.info("JDMEBoardQnaServiceImpl jdmeBoardNoticeSelect 함수 진입");
		return jdmeBoardQnaDAO.jdmeBoardQnaSelect(jbqvo);
	}

	// 질문 게시판 수정하기
	@Override
	public int jdmeBoardQnaUpdate(JDMEBoardQnaVO jbqvo) {
		
		logger.info("JDMEBoardQnaServiceImpl jdmeBoardQnaUpdate 함수 진입");
		return jdmeBoardQnaDAO.jdmeBoardQnaUpdate(jbqvo);
	}

	// 질문 게시판 수정 할 때 비밀번호 체크하기
	@Override
	public List<JDMEBoardQnaVO> jdmeBoardQnaPwcheck(JDMEBoardQnaVO jbqvo) {
		
		logger.info("JDMEBoardQnaServiceImpl jdmeBoardQnaPwcheck 함수 진입");
		return jdmeBoardQnaDAO.jdmeBoardQnaPwcheck(jbqvo);
	}

}
