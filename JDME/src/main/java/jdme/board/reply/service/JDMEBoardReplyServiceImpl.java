package jdme.board.reply.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import jdme.board.reply.dao.JDMEBoardReplyDAO;
import jdme.board.reply.vo.JDMEBoardReplyVO;

@Service
@Transactional
public class JDMEBoardReplyServiceImpl implements JDMEBoardReplyService {

	Logger logger = LogManager.getLogger(JDMEBoardReplyServiceImpl.class);
	
	@Autowired(required=false)
	private JDMEBoardReplyDAO jdmeBoardReplyDAO;

	// 댓글 등록하기
	@Override
	public int jdmeBoardReplyInsert(JDMEBoardReplyVO jbrvo) {
		
		logger.info("KosmoRboardServiceImpl kosmoRboardInsert 함수진입");
		return jdmeBoardReplyDAO.jdmeBoardReplyInsert(jbrvo);
	}

	// 댓글 전체 조회하기
	@Override
	public List<JDMEBoardReplyVO> jdmeBoardReplySelectAll(JDMEBoardReplyVO jbrvo) {
		
		logger.info("KosmoRboardServiceImpl jdmeBoardReplySelectAll 함수진입");
		return jdmeBoardReplyDAO.jdmeBoardReplySelectAll(jbrvo);
	}
	
	// 댓글 삭제하기
	@Override
	public int jdmeBoardReplyDelete(JDMEBoardReplyVO jbrvo) {
		
		logger.info("KosmoRboardServiceImpl jdmeBoardReplyDelete 함수진입");
		return jdmeBoardReplyDAO.jdmeBoardReplyDelete(jbrvo);
	}
	
	

}
