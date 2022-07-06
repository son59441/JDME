package jdme.board.reply.service;

import java.util.List;

import jdme.board.reply.vo.JDMEBoardReplyVO;

public interface JDMEBoardReplyService {

	public int jdmeBoardReplyInsert(JDMEBoardReplyVO jbrvo);
	public List<JDMEBoardReplyVO> jdmeBoardReplySelectAll(JDMEBoardReplyVO jbrvo);
	public int jdmeBoardReplyDelete(JDMEBoardReplyVO jbrvo);
	
}
