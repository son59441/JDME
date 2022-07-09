package jdme.board.qnareply.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import jdme.board.qnareply.dao.JDMEBoardQnaReplyDAO;
import jdme.board.qnareply.vo.JDMEBoardQnaReplyVO;


@Service
@Transactional
public class JDMEBoardQnaReplyServiceImpl implements JDMEBoardQnaReplyService {

	Logger logger = LogManager.getLogger(JDMEBoardQnaReplyServiceImpl.class);
	
	// 서비스에서 DAO 연결하기
	// 필드 오토와이어드
	@Autowired(required=false)
	private JDMEBoardQnaReplyDAO jdmeBoardQnaReplyDAO;
	
	
	// Q&A 댓글 입력하기
	@Override
	public int jdmeBoardQnaReplyInsert(JDMEBoardQnaReplyVO jbqrvo) {
		
		logger.info("JDMEBoardQnaReplyServiceImpl jdmeBoardQnaReplyInsert 함수진입");
		return jdmeBoardQnaReplyDAO.jdmeBoardQnaReplyInsert(jbqrvo);
	}

	// Q&A 댓글 전체 조회하기
	@Override
	public List<JDMEBoardQnaReplyVO> jdmeBoardQnaReplySelectAll(JDMEBoardQnaReplyVO jbqrvo) {
		
		logger.info("JDMEBoardQnaReplyServiceImpl jdmeBoardQnaReplySelectAll 함수진입");
		return jdmeBoardQnaReplyDAO.jdmeBoardQnaReplySelectAll(jbqrvo);
	}

	// Q&A 댓글 삭제하기
	@Override
	public int jdmeBoardQnaReplyDelete(JDMEBoardQnaReplyVO jbqrvo) {
		
		logger.info("JDMEBoardQnaReplyServiceImpl jdmeBoardQnaReplySelectAll 함수진입");
		return jdmeBoardQnaReplyDAO.jdmeBoardQnaReplyDelete(jbqrvo);

	}

}
