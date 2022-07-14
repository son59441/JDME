package jdme.common.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jdme.board.com.vo.JDMEBoardComVO;
import jdme.board.notice.vo.JDMEBoardNoticeVO;
import jdme.board.qna.vo.JDMEBoardQnaVO;
import jdme.board.qnareply.vo.JDMEBoardQnaReplyVO;
import jdme.board.reply.vo.JDMEBoardReplyVO;
import jdme.common.dao.ChabunDAO;
import jdme.member.vo.JDMEMemberVO;


@Service
@Transactional
public class ChabunServiceImpl implements ChabunService {
	private Logger logger = Logger.getLogger(ChabunServiceImpl.class);
	
	private ChabunDAO chabunDAO;

	@Autowired(required = false)
	public ChabunServiceImpl(ChabunDAO chabunDAO) {
		this.chabunDAO = chabunDAO;
	}
	
	// 커뮤니티 게시판 채번
	@Override
	public JDMEBoardComVO getBoardComChabun() {
		
		logger.info("ChabunServiceImpl getBoardComChabun 함수 진입");
		return chabunDAO.getBoardComChabun();
	}

	// 댓글 게시판 채번
	@Override
	public JDMEBoardReplyVO getBoardReplyChabun() {
		
		logger.info("ChabunServiceImpl getBoardReplyChabun 함수 진입");
		return chabunDAO.getBoardReplyChabun();
	}

	// 공지사항 게시판 채번
	@Override
	public JDMEBoardNoticeVO getBoardNoticeChabun() {
		
		logger.info("ChabunServiceImpl getBoardNoticeChabun 함수 진입");
		return chabunDAO.getBoardNoticeChabun();
	}

	// 질문 게시판 채번
	@Override
	public JDMEBoardQnaVO getBoardQnaChabun() {
		
		logger.info("ChabunServiceImpl getBoardQnaChabun 함수 진입");
		return chabunDAO.getBoardQnaChabun();
	}

	
	// Q&A 질문 게시판 채번
	@Override
	public JDMEBoardQnaReplyVO getBoardQnaReplyChabun() {
		
		logger.info("ChabunServiceImpl JDMEBoardQnaReplyVO 함수 진입");
		return chabunDAO.getBoardQnaReplyChabun();
	}

	// 회원가입 채번
	@Override
	public JDMEMemberVO getMemberChabun() {
		
		logger.info("ChabunServiceImpl JDMEMemberVO 함수 진입");
		return chabunDAO.getMemberChabun();
	}


	
	
	
}
