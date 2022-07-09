package jdme.common.service;

import jdme.board.com.vo.JDMEBoardComVO;
import jdme.board.notice.vo.JDMEBoardNoticeVO;
import jdme.board.qna.vo.JDMEBoardQnaVO;
import jdme.board.qnareply.vo.JDMEBoardQnaReplyVO;
import jdme.board.reply.vo.JDMEBoardReplyVO;

public interface ChabunService {
	
	public JDMEBoardComVO getBoardComChabun();
	public JDMEBoardReplyVO getBoardReplyChabun();
	public JDMEBoardNoticeVO getBoardNoticeChabun();
	public JDMEBoardQnaVO getBoardQnaChabun();
	public JDMEBoardQnaReplyVO getBoardQnaReplyChabun();
	
	
}
