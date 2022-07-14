package jdme.board.qna.dao;

import java.util.List;

import org.springframework.context.annotation.Primary;

import jdme.board.qna.vo.JDMEBoardQnaVO;

@Primary
public interface JDMEBoardQnaDAO {

	public int jdmeBoardQnaInsert(JDMEBoardQnaVO jbqvo);
	public List<JDMEBoardQnaVO> jdmeBoardQnaSelectAll(JDMEBoardQnaVO jbqvo);
	public List<JDMEBoardQnaVO> jdmeBoardQnaSelect(JDMEBoardQnaVO jbqvo);
	public int jdmeBoardQnaUpdate(JDMEBoardQnaVO jbqvo);
	public List<JDMEBoardQnaVO> jdmeBoardQnaPwcheck(JDMEBoardQnaVO jbqvo);
	
	
}
