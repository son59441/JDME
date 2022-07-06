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
			
	}
	
	
	
	
	
	
}
