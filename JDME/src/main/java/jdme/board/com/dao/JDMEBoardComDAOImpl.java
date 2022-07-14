package jdme.board.com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jdme.board.com.vo.JDMEBoardComVO;

@Repository
public class JDMEBoardComDAOImpl implements JDMEBoardComDAO {
	Logger logger = LogManager.getLogger(JDMEBoardComDAOImpl.class);
	
	
	private SqlSessionTemplate sqlSession;
	
	// 커뮤니티 게시판 입력
	@Override
	public int jdmeBoardComInsert(JDMEBoardComVO jbcvo) {
		
		logger.info("JDMEBoardComDAOImpl jdmeBoardComInsert 함수 진입");
		return (Integer)sqlSession.insert("jdmeBoardComInsert",jbcvo);
	}

	// 커뮤니티 게시판 전체조회
	@Override
	public List<JDMEBoardComVO> jdmeBoardComSelectAll(JDMEBoardComVO jbcvo) {
		
		logger.info("JDMEBoardComDAOImpl jdmeBoardComSelectAll 함수 진입");
		return sqlSession.selectList("jdmeBoardComSelectAll",jbcvo);
	}

	// 커뮤니티 조건 조회 게시판 
	@Override
	public List<JDMEBoardComVO> jdmeBoardComSelect(JDMEBoardComVO jbcvo) {
		
		logger.info("JDMEBoardComDAOImpl jdmeBoardComSelect 함수 진입");
		return sqlSession.selectList("jdmeBoardComSelect",jbcvo);
	}

	// 커뮤니티 게시판 수정하기
	@Override
	public int jdmeBoardComUpdate(JDMEBoardComVO jbcvo) {
		
		logger.info("JDMEBoardComDAOImpl jdmeBoardComUpdate 함수 진입");
		return (Integer)sqlSession.insert("jdmeBoardComUpdate",jbcvo);
	}
	
	
	// 커뮤니티 게시판 비밀번호 체크하기
	@Override
	public List<JDMEBoardComVO> jdmeBoardComPwcheck(JDMEBoardComVO jbcvo) {
		
		logger.info("JDMEBoardComDAOImpl jdmeBoardComPwcheck 함수 진입");
		return sqlSession.selectList("jdmeBoardComPwcheck",jbcvo);
	}

	

}
