package jdme.board.qna.service;

import java.util.List;

import jdme.board.qna.vo.JDMEBoardQnaVO;

public interface JDMEBoardQnaService {

	public int jdmeBoardQnaInsert(JDMEBoardQnaVO jbqvo);
	public List<JDMEBoardQnaVO> jdmeBoardQnaSelectAll(JDMEBoardQnaVO jbqvo);
	public List<JDMEBoardQnaVO> jdmeBoardQnaSelect(JDMEBoardQnaVO jbqvo);
	public int jdmeBoardQnaUpdate(JDMEBoardQnaVO jbqvo);
	public List<JDMEBoardQnaVO> jdmeBoardQnaPwcheck(JDMEBoardQnaVO jbqvo);
	
	
	
}
