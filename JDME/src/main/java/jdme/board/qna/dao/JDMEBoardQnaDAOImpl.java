package jdme.board.qna.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import jdme.board.qna.vo.JDMEBoardQnaVO;


@Repository
public class JDMEBoardQnaDAOImpl implements JDMEBoardQnaDAO {

	Logger logger = LogManager.getLogger(JDMEBoardQnaDAOImpl.class);
	
	// 필드 오토와이어드 의존성 주입 세션 정해주기
	private SqlSession sqlSession;
	
	
	// 질문 게시판 입력
	@Override
	public int jdmeBoardQnaInsert(JDMEBoardQnaVO jbqvo) {
		
		logger.info("JDMEBoardQnaDAOImpl jdmeBoardQnaInsert 함수 진입");
		return (Integer)sqlSession.insert("jdmeBoardQnaInsert", jbqvo);
	}

	// 질문 게시판 전체
	@Override
	public List<JDMEBoardQnaVO> jdmeBoardQnaSelectAll(JDMEBoardQnaVO jbqvo) {
		
		logger.info("JDMEBoardQnaDAOImpl jdmeBoardQnaSelectAll 함수 진입");
		return sqlSession.selectList("jdmeBoardQnaSelectAll",jbqvo);
	}

	// 질문 게시판 조건 조회
	@Override
	public List<JDMEBoardQnaVO> jdmeBoardQnaSelect(JDMEBoardQnaVO jbqvo) {
		
		logger.info("JDMEBoardQnaDAOImpl jdmeBoardQnaSelect 함수 진입");
		return sqlSession.selectList("jdmeBoardQnaSelect",jbqvo);
	}

}
