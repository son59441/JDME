package jdme.board.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import jdme.board.notice.dao.JDMEBoardNoticeDAO;
import jdme.board.notice.vo.JDMEBoardNoticeVO;

@Service
@Transactional
public class JDMEBoardNoticeServiceImpl implements JDMEBoardNoticeService {

	Logger logger = LogManager.getLogger(JDMEBoardNoticeServiceImpl.class);
	
	// 서비스에서 DAO로 연결해주기 의존성 주입
	@Autowired(required=false)
	private JDMEBoardNoticeDAO jdmeBoardNoticeDAO;
	

	// 공지사항 게시판 입력
	@Override
	public int jdmeBoardNoticeInsert(JDMEBoardNoticeVO jbnvo) {
		
		logger.info("JDMEBoardNoticeServiceImpl jdmeBoardNoticeInsert 함수 진입");
		return jdmeBoardNoticeDAO.jdmeBoardNoticeInsert(jbnvo);
	}
	
	// 공지사항 게시판 전체 조회
	@Override
	public List<JDMEBoardNoticeVO> jdmeBoardNoticeSelectAll(JDMEBoardNoticeVO jbnvo) {
		
		logger.info("JDMEBoardNoticeServiceImpl jdmeBoardNoticeSelectAll 함수 진입");
		return jdmeBoardNoticeDAO.jdmeBoardNoticeSelectAll(jbnvo);
	}

	// 공지사항 게시판 조건 조회
	@Override
	public List<JDMEBoardNoticeVO> jdmeBoardNoticeSelect(JDMEBoardNoticeVO jbnvo) {
		
		logger.info("JDMEBoardNoticeServiceImpl jdmeBoardNoticeSelect 함수 진입");
		return jdmeBoardNoticeDAO.jdmeBoardNoticeSelect(jbnvo);
	}

}
