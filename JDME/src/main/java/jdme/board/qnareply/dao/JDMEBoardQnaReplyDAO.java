package jdme.board.qnareply.dao;

import java.util.List;

import org.springframework.context.annotation.Primary;

import jdme.board.qnareply.vo.JDMEBoardQnaReplyVO;

@Primary
public interface JDMEBoardQnaReplyDAO {

	public int jdmeBoardQnaReplyInsert(JDMEBoardQnaReplyVO jbqrvo);
	public List<JDMEBoardQnaReplyVO> jdmeBoardQnaReplySelectAll(JDMEBoardQnaReplyVO jbqrvo);
	public int jdmeBoardQnaReplyDelete(JDMEBoardQnaReplyVO jbqrvo);
	
	
}
