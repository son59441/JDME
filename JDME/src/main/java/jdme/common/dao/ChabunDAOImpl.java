package jdme.common.dao;


import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jdme.board.com.vo.JDMEBoardComVO;
import jdme.board.notice.vo.JDMEBoardNoticeVO;
import jdme.board.qna.vo.JDMEBoardQnaVO;
import jdme.board.reply.vo.JDMEBoardReplyVO;


@Repository
public class ChabunDAOImpl implements ChabunDAO {
	private Logger logger = Logger.getLogger(ChabunDAOImpl.class);
	
	@Autowired(required = false)
	private SqlSessionTemplate sqlSession;	

	// 커뮤니티 게시판 채번
	@Override
	public JDMEBoardComVO getBoardComChabun() {
		
		logger.info("ChabunDAOImpl 커뮤니티 게시판 채번 다오");
		return sqlSession.selectOne("getBoardComChabun");
	}

	// 댓글 게시판 채번
	@Override
	public JDMEBoardReplyVO getBoardReplyChabun() {
		
		logger.info("ChabunDAOImpl 댓글 게시판 채번 다오");
		return sqlSession.selectOne("getBoardReplyChabun");
	}

	
	
}
