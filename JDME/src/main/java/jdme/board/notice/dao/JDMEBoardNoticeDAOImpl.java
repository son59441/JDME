package jdme.board.notice.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import jdme.board.notice.vo.JDMEBoardNoticeVO;

@Repository
public class JDMEBoardNoticeDAOImpl implements JDMEBoardNoticeDAO {

	Logger logger = LogManager.getLogger(JDMEBoardNoticeDAOImpl.class);
	
	// 필드 오토와이어드 의존성 주입
	private SqlSession sqlSession;
	
	
	// 공지사항 게시판 입력
	@Override
	public int jdmeBoardNoticeInsert(JDMEBoardNoticeVO jbnvo) {
		
		logger.info("JDMEBoardNoticeDAOImpl jdmeBoardNoticeInsert 함수 진입");
		return (Integer)sqlSession.insert("jdmeBoardNoticeInsert",jbnvo);
	}

	
	// 공지사항 게시판 전체 조회
	@Override
	public List<JDMEBoardNoticeVO> jdmeBoardNoticeSelectAll(JDMEBoardNoticeVO jbnvo) {
		
		logger.info("JDMEBoardNoticeDAOImpl jdmeBoardNoticeSelectAll 함수 진입");
		return sqlSession.selectList("jdmeBoardNoticeSelectAll",jbnvo);
	}

	
	// 공지사항 게시판 조건 조회 
	@Override
	public List<JDMEBoardNoticeVO> jdmeBoardNoticeSelect(JDMEBoardNoticeVO jbnvo) {
		
		logger.info("JDMEBoardNoticeDAOImpl jdmeBoardNoticeSelect 함수 진입");
		return sqlSession.selectList("jdmeBoardNoticeSelect",jbnvo);
	}

}
