package jdme.board.com.dao;

import java.util.List;

import org.springframework.context.annotation.Primary;

import jdme.board.com.vo.JDMEBoardComVO;

@Primary
public interface JDMEBoardComDAO {

	public int jdmeBoardComInsert(JDMEBoardComVO jbcvo);
	public List<JDMEBoardComVO> jdmeBoardComSelectAll(JDMEBoardComVO jbcvo);
	public List<JDMEBoardComVO> jdmeBoardComSelect(JDMEBoardComVO jbcvo);
	public List<JDMEBoardComVO> jdmeBoardComPwcheck(JDMEBoardComVO jbcvo);
	public int jdmeBoardComUpdate(JDMEBoardComVO jbcvo);
	
}
