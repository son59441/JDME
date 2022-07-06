package jdme.common.dao;

import org.springframework.context.annotation.Primary;

import jdme.board.com.vo.JDMEBoardComVO;
import jdme.board.reply.vo.JDMEBoardReplyVO;


@Primary
public interface ChabunDAO {

	public JDMEBoardComVO getBoardComChabun();
	public JDMEBoardReplyVO getBoardReplyChabun();
}
