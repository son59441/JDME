package jdme.board.reply.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jdme.board.reply.service.JDMEBoardReplyService;
import jdme.board.reply.vo.JDMEBoardReplyVO;
import jdme.common.ChabunUtil;
import jdme.common.service.ChabunService;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;



@Controller
public class JDMEBoardReplyController {

	Logger logger = LogManager.getLogger(JDMEBoardReplyController.class);
	
	// 필드 오토와이어드
	@Autowired(required=false)
	private ChabunService chabunService;
	
	// 필드 오토와이어드 
	@Autowired(required=false)
	private JDMEBoardReplyService jdmeBoardReplyService;
	
	
	// 댓글 글 쓰기 페이지 이동
	@GetMapping(value="JDMEBoardReplyInsertForm")
	public String jdmeBoardReplyInsertForm() {
		
		logger.info("JDMEBoardReplyController jdmeBoardReplyInsertForm 함수진입");
		return "rboard/JDMEBoardReplyInsertForm";
	}
	
	// 댓글 등록하기
	@PostMapping(value="JDMEBoardReplyInsert")
	@ResponseBody
	public String jdmeBoardReplyInsert(JDMEBoardReplyVO jbrvo) {
		
		logger.info("JDMEBoardReplyController jdmeBoardReplyInsert 함수 진입");
		
		String jrnum = ChabunUtil.BoardReplyChabun("N", chabunService.getBoardReplyChabun().getJrnum());
		
		jbrvo.setJrnum(jrnum);
		
		logger.info("jrnum --> : " + jbrvo.getJrnum());
		
		int nCnt = jdmeBoardReplyService.jdmeBoardReplyInsert(jbrvo);
		logger.info("jdmeBoardReplyService nCnt --> : " + nCnt);
		
		if(nCnt ==1) {
			return "GOOD";
		}else {
			return "BAD";
		}
			
	} // end of jdmeBoardReplyInsert
	
	// 댓글 전체 조회
	@PostMapping(value="JDMEBoardReplySelectAll" , produces = "application/text; charset=UTF-8")
	@ResponseBody
	public String jdmeBoardReplySelectAll(JDMEBoardReplyVO jbrvo) {
		logger.info("JDMEBoardReplyController JDMEBoardReplySelectAll 함수 진입");
		logger.info("jbnum --> : " + jbrvo.getJbnum());
		
		List<JDMEBoardReplyVO> list = jdmeBoardReplyService.jdmeBoardReplySelectAll(jbrvo);
		logger.info("list --> : " + list);
		
		String ss = "";
		String listStr = "";
		for(int i = 0; i < list.size(); i++) {
			
			JDMEBoardReplyVO _jbrvo = list.get(i);
			String s0 = _jbrvo.getJrnum();
			String s1 = _jbrvo.getJrid();
			String s2 = _jbrvo.getJrcontent();
			String s3 = _jbrvo.getJrdate();
			ss = s0 + "," + s1 + "," + s2 + "," +s3;
			listStr += ss + "&";
			logger.info("listStr --> : " + listStr);
			
		}
		logger.info("listStr --> : " + listStr);
		
		
		
		return listStr;
	}
	
	// 댓글 삭제하기
	@PostMapping(value="JDEMBoardReplyDelete")
	@ResponseBody
	public String jdmeBoardReplyDelete(JDMEBoardReplyVO jbrvo) {
		logger.info("JDMEBoardReplyController JDEMBoardReplyDelete 함수 진입");
		logger.info("jbnum --> : " + jbrvo.getJbnum());
		
		int nCnt = jdmeBoardReplyService.jdmeBoardReplyDelete(jbrvo);
		logger.info("nCnt --> : " + nCnt);
		
		if(nCnt == 1) {
			return "GOOD";
		}else {
			return "BAD";
		}
		
	} // end of 댓글 삭제
	
	
	
} // end of controller
