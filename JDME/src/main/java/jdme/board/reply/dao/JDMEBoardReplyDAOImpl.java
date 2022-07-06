package jdme.board.reply.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jdme.board.reply.vo.JDMEBoardReplyVO;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

@Repository
public class JDMEBoardReplyDAOImpl implements JDMEBoardReplyDAO {

	Logger logger = LogManager.getLogger(JDMEBoardReplyDAOImpl.class);	
	
	@Autowired(required=false)
	private SqlSession sqlSession;
	
	// 댓글 등록하기
	@Override
	public int jdmeBoardReplyInsert(JDMEBoardReplyVO jbrvo) {
		
		logger.info("JDMEBoardReplyDAOImpl jdmeBoardReplyInsert 함수진입");
		return (Integer)sqlSession.insert("jdmeBoardReplyInsert",jbrvo);
	}

	// 댓글 전체 조회하기
	@Override
	public List<JDMEBoardReplyVO> jdmeBoardReplySelectAll(JDMEBoardReplyVO jbrvo) {
		
		logger.info("JDMEBoardReplyDAOImpl jdmeBoardReplySelectAll 함수진입");
		return sqlSession.selectList("jdmeBoardReplySelectAll",jbrvo);
	}

	// 댓글 삭제하기
	@Override
	public int jdmeBoardReplyDelete(JDMEBoardReplyVO jbrvo) {
		
		logger.info("JDMEBoardReplyDAOImpl jdmeBoardReplyDelete 함수진입");
		return (Integer)sqlSession.insert("jdmeBoardReplyDelete", jbrvo);
	}

	
}
