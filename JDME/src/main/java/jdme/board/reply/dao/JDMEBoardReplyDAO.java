package jdme.board.reply.dao;

import java.util.List;

import org.springframework.context.annotation.Primary;

import jdme.board.reply.vo.JDMEBoardReplyVO;

@Primary
public interface JDMEBoardReplyDAO {

	public int jdmeBoardReplyInsert(JDMEBoardReplyVO jbrvo);
	public List<JDMEBoardReplyVO> jdmeBoardReplySelectAll(JDMEBoardReplyVO jbrvo);
	public int jdmeBoardReplyDelete(JDMEBoardReplyVO jbrvo);
}
