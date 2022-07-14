package jdme.board.com.service;

import java.util.List;

import jdme.board.com.vo.JDMEBoardComVO;

public interface JDMEBoardComService {

	public int jdmeBoardComInsert(JDMEBoardComVO jbcvo);
	public List<JDMEBoardComVO> jdmeBoardComSelectAll(JDMEBoardComVO jbcvo);
	public List<JDMEBoardComVO> jdmeBoardComSelect(JDMEBoardComVO jbcvo);
	public List<JDMEBoardComVO> jdmeBoardComPwcheck(JDMEBoardComVO jbcvo);
	public int jdmeBoardComUpdate(JDMEBoardComVO jbcvo);
	
	
	
}
