package jdme.board.qnareply.service;

import java.util.List;

import jdme.board.qnareply.vo.JDMEBoardQnaReplyVO;

public interface JDMEBoardQnaReplyService {

	public int jdmeBoardQnaReplyInsert(JDMEBoardQnaReplyVO jbqrvo);
	public List<JDMEBoardQnaReplyVO> jdmeBoardQnaReplySelectAll(JDMEBoardQnaReplyVO jbqrvo);
	public int jdmeBoardQnaReplyDelete(JDMEBoardQnaReplyVO jbqrvo);
	
	
}
