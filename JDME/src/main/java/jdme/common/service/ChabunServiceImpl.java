package jdme.common.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jdme.board.com.vo.JDMEBoardComVO;
import jdme.board.notice.vo.JDMEBoardNoticeVO;
import jdme.board.qna.vo.JDMEBoardQnaVO;
import jdme.board.reply.vo.JDMEBoardReplyVO;
import jdme.common.dao.ChabunDAO;


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
		
		logger.info("ChabunServiceImpl 커뮤니티 게시판 채번 서비스");
		return chabunDAO.getBoardComChabun();
	}

	// 댓글 게시판 채번
	@Override
	public JDMEBoardReplyVO getBoardReplyChabun() {
		
		logger.info("ChabunServiceImpl 댓글 게시판 채번 서비스");
		return chabunDAO.getBoardReplyChabun();
	}


	
	
}
