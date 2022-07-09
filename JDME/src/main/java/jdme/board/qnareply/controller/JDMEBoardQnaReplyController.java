package jdme.board.qnareply.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jdme.board.qnareply.service.JDMEBoardQnaReplyService;
import jdme.board.qnareply.vo.JDMEBoardQnaReplyVO;
import jdme.board.reply.controller.JDMEBoardReplyController;
import jdme.board.reply.service.JDMEBoardReplyService;
import jdme.board.reply.vo.JDMEBoardReplyVO;
import jdme.common.ChabunUtil;
import jdme.common.service.ChabunService;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;



@Controller
public class JDMEBoardQnaReplyController {

	Logger logger = LogManager.getLogger(JDMEBoardQnaReplyController.class);
	
	// 필드 오토와이어드
	@Autowired(required=false)
	private ChabunService chabunService;
	
	// 필드 오토와이어드 
	@Autowired(required=false)
	private JDMEBoardQnaReplyService jdmeBoardQnaReplyService;
	
	
	// 댓글 글 쓰기 페이지 이동
	@GetMapping(value="JDMEBoardQnaReplyInsertForm")
	public String jdmeBoardQnaReplyInsertForm() {
		
		logger.info("JDMEBoardQnaReplyController jdmeBoardQnaReplyInsertForm 함수진입");
		return "qrboard/JDMEBoardQnaReplyInsertForm";
	}
		
	// Q&A 댓글 등록하기
	@PostMapping(value="JDMEBoardQnaReplyInsert")
	@ResponseBody
	public String jdmeBoardQnaReplyInsert(JDMEBoardQnaReplyVO jbqrvo) {
		
		logger.info("JDMEBoardQnaReplyController jdmeBoardQnaReplyInsert 함수 진입");
		
		String jqrnum = ChabunUtil.BoardQnaReplyChabun("N", chabunService.getBoardQnaReplyChabun().getJqrnum());
		
		jbqrvo.setJqrnum(jqrnum);
		
		logger.info("jqrnum --> : " + jbqrvo.getJqrnum());
		
		int nCnt = jdmeBoardQnaReplyService.jdmeBoardQnaReplyInsert(jbqrvo);
		logger.info("jdmeBoardReplyService nCnt --> : " + nCnt);
		
		if(nCnt ==1) {
			return "GOOD";
		}else {
			return "BAD";
		}
			
	} // end of jdmeBoardQnaReplyInsert

	// 댓글 전체 조회
	@PostMapping(value="JDMEBoardQnaReplySelectAll" , produces = "application/text; charset=UTF-8")
	@ResponseBody
	public String jdmeBoardQnaReplySelectAll(JDMEBoardQnaReplyVO jbqrvo) {
		logger.info("JDMEBoardQnaReplyController JDMEBoardQnaReplySelectAll 함수 진입");
		logger.info("jqnum --> : " + jbqrvo.getJqnum());
		
		List<JDMEBoardQnaReplyVO> list = jdmeBoardQnaReplyService.jdmeBoardQnaReplySelectAll(jbqrvo);
		logger.info("list --> : " + list);
		
		String ss = "";
		String listStr = "";
		for(int i = 0; i < list.size(); i++) {
			
			JDMEBoardQnaReplyVO _jbqrvo = list.get(i);
			String s0 = _jbqrvo.getJqrnum();
			String s1 = _jbqrvo.getJqrid();
			String s2 = _jbqrvo.getJqrcontent();
			String s3 = _jbqrvo.getJqrdate();
			ss = s0 + "," + s1 + "," + s2 + "," +s3;
			listStr += ss + "&";
			logger.info("listStr --> : " + listStr);
			
		}
		logger.info("listStr --> : " + listStr);
		
		
		
		return listStr;
	}
	
	// 댓글 삭제하기
	@PostMapping(value="JDEMBoardQnaReplyDelete")
	@ResponseBody
	public String jdmeBoardQnaReplyDelete(JDMEBoardQnaReplyVO jbqrvo) {
		logger.info("JDMEBoardQnaReplyController JDEMBoardQnaReplyDelete 함수 진입");
		logger.info("jqnum --> : " + jbqrvo.getJqnum());
		
		int nCnt = jdmeBoardQnaReplyService.jdmeBoardQnaReplyDelete(jbqrvo);
		logger.info("nCnt --> : " + nCnt);
		
		if(nCnt == 1) {
			return "GOOD";
		}else {
			return "BAD";
		}
		
	} // end of 댓글 삭제
	


	
	
}
