package jdme.board.notice.service;

import java.util.List;

import jdme.board.notice.vo.JDMEBoardNoticeVO;

public interface JDMEBoardNoticeService {

	public int jdmeBoardNoticeInsert(JDMEBoardNoticeVO jbnvo);
	public List<JDMEBoardNoticeVO> jdmeBoardNoticeSelectAll(JDMEBoardNoticeVO jbnvo);
	public List<JDMEBoardNoticeVO> jdmeBoardNoticeSelect(JDMEBoardNoticeVO jbnvo);
	
	
}
