package jdme.board.notice.dao;

import java.util.List;

import org.springframework.context.annotation.Primary;

import jdme.board.notice.vo.JDMEBoardNoticeVO;

@Primary
public interface JDMEBoardNoticeDAO {
	
	
	public int jdmeBoardNoticeInsert(JDMEBoardNoticeVO jbnvo);
	public List<JDMEBoardNoticeVO> jdmeBoardNoticeSelectAll(JDMEBoardNoticeVO jbnvo);
	public List<JDMEBoardNoticeVO> jdmeBoardNoticeSelect(JDMEBoardNoticeVO jbnvo);
}
