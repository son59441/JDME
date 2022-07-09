package jdme.board.qnareply.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jdme.board.qnareply.vo.JDMEBoardQnaReplyVO;
import jdme.board.reply.dao.JDMEBoardReplyDAOImpl;


@Repository
public class JDMEBoardQnaReplyDAOImpl implements JDMEBoardQnaReplyDAO {

	Logger logger = LogManager.getLogger(JDMEBoardQnaReplyDAOImpl.class);	
	
	// 필드 Autowired
	@Autowired(required=false)
	private SqlSession sqlSession;
	
	
	// Q&A 댓글 등록
	@Override
	public int jdmeBoardQnaReplyInsert(JDMEBoardQnaReplyVO jbqrvo) {
		
		logger.info("JDMEBoardReplyDAOImpl jdmeBoardQnaReplyInsert 함수진입");
		return (Integer)sqlSession.insert("jdmeBoardQnaReplyInsert",jbqrvo);
	}

	// Q&A 댓글 전체 조회
	@Override
	public List<JDMEBoardQnaReplyVO> jdmeBoardQnaReplySelectAll(JDMEBoardQnaReplyVO jbqrvo) {
		
		logger.info("JDMEBoardReplyDAOImpl jdmeBoardQnaReplySelectAll 함수진입");
		return sqlSession.selectList("jdmeBoardQnaReplySelectAll",jbqrvo);
	}

	// Q&A 댓글 삭제
	@Override
	public int jdmeBoardQnaReplyDelete(JDMEBoardQnaReplyVO jbqrvo) {

		logger.info("JDMEBoardReplyDAOImpl jdmeBoardQnaReplyDelete 함수진입");
		return (Integer)sqlSession.insert("jdmeBoardQnaReplyDelete", jbqrvo);
	}

}
