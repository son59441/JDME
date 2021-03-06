package jdme.board.qna.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jdme.board.qna.service.JDMEBoardQnaService;
import jdme.board.qna.vo.JDMEBoardQnaVO;
import jdme.common.ChabunUtil;
import jdme.common.CommonUtils;
import jdme.common.FileUploadUtil;
import jdme.common.service.ChabunService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;




@Controller
public class JDMEBoardQnaController {

	Logger logger = LogManager.getLogger(JDMEBoardQnaController.class);
	
	// 채번 서비스 의존성 주입
	@Autowired(required=false)
	private ChabunService chabunService;
	
	@Autowired(required=false)
	private JDMEBoardQnaService jdmeBoardQnaService;
	
	
	// 질문 게시판 글 쓰기 페이지
	@GetMapping(value="JDMEBoardQnaInsertForm")
	public String jdmeBoardQnaInsertForm() {
		
		logger.info("JDMEBoardQnaController jdmeBoardQnaInsertForm 함수 진입");
		
		return "qna/JDMEBoardQnaInsertForm";
		
	}
	
	// 질문 게시판 입력
	@PostMapping(value="JDMEBoardQnaInsert")
	public String jdmeBoardQnaInsert(HttpServletRequest req) {
		
		logger.info("JDMEBoardQnaController jdmeBoardQnaInsert 함수 진입");
		
		// 채번 구하기
		String jqnum = ChabunUtil.BoardQnaChabun("N", chabunService.getBoardQnaChabun().getJqnum());
		logger.info("jdmeBoardQnaInsert jqnum --> : " + jqnum);
		
		// 이미지 업로드 
		// CommonUtils에 설정 된 상수 값들을 불러와준다.
		FileUploadUtil fu = new FileUploadUtil(	 CommonUtils.BOARD_QNA_IMG_UPLOAD_PATH
								                ,CommonUtils.BOARD_QNA_IMG_FILE_SIZE
								                ,CommonUtils.BOARD_QNA_EN_CODE);

		// 이미지 파일 원본 사이즈 업로드 하기
		boolean bool = fu.imgfileUpload(req);
		logger.info("jdmeBoardQnaInsert bool --> : " + bool);
		
		// 깡통 클래스에 넣어서 입력한 거 받아준다.
		JDMEBoardQnaVO _jbqvo = null;
		_jbqvo = new JDMEBoardQnaVO();
		
		_jbqvo.setJqnum(jqnum);
		_jbqvo.setJmnum(fu.getParameter("jmnum"));
		_jbqvo.setJqsubject(fu.getParameter("jqsubject"));
		_jbqvo.setJmid(fu.getParameter("jmid"));
		_jbqvo.setJqcontent(fu.getParameter("jqcontent"));
		_jbqvo.setJqpw(fu.getParameter("jqpw"));
		_jbqvo.setJqfile(fu.getFileName("jqfile"));
		
		logger.info("jqnum --> : " + jqnum);
		logger.info("jmnum --> : " + fu.getParameter("jmnum"));
		logger.info("jqsubject --> : " + fu.getParameter("jqsubject"));
		logger.info("jmid --> : " + fu.getParameter("jmid"));
		logger.info("jqcontent --> : " + fu.getParameter("jqcontent"));
		logger.info("jqpw --> : " + fu.getParameter("jqpw"));
		logger.info("jqfile --> : " + fu.getFileName("jqfile"));
		
		
		int nCnt = jdmeBoardQnaService.jdmeBoardQnaInsert(_jbqvo);
		if(nCnt > 0) {
			logger.info("jdmeBoardComInsert nCnt --> : " + nCnt);
			return "qna/JDMEBoardQnaInsert";
		}
	
		return "qna/JDMEBoardQnaInsertForm";
		
	}

	
	// 질문 게시판 전체 조회
	@GetMapping(value="JDMEBoardQnaSelectAll")
	public String jdmeBoardQnaSelectAll(Model model, JDMEBoardQnaVO jbqvo) {
		logger.info("JDMEBoardQnaController jdmeBoardQnaSelectAll 함수 진입");
		
		// 페이징 처리 하기 위한 작업 
		int pageSize = CommonUtils.BOARD_PAGE_SIZE;
		int groupSize = CommonUtils.BOARD_GROUP_SIZE;
		int curPage = CommonUtils.BOARD_CUR_PAGE;
		int totalCount = CommonUtils.BOARD_TOTAL_COUNT;
						
		// 페이지가 넘어 가는 지 체크해주기 위함
		if (jbqvo.getCurPage() !=null){
			curPage = Integer.parseInt(jbqvo.getCurPage());
		}
		
		// 담아주기 위한 작업 형변환이 필요한 작업
		jbqvo.setPageSize(String.valueOf(pageSize));
		jbqvo.setGroupSize(String.valueOf(groupSize));
		jbqvo.setCurPage(String.valueOf(curPage));
		jbqvo.setTotalCount(String.valueOf(totalCount));
		
		
		
		List<JDMEBoardQnaVO> listAll = jdmeBoardQnaService.jdmeBoardQnaSelectAll(jbqvo);
		
		if(listAll.size() > 0) {
			
			logger.info("listAll --> : " + listAll);
			
			model.addAttribute("pagingQna", jbqvo);
			model.addAttribute("listAll", listAll);
			
			return "qna/JDMEBoardQnaSelectAll";
		}
		
		return "/JDME/index.jsp";
	}
	
	
	// 질문 게시판 조건 조회
	@GetMapping(value="JDMEBoardQnaSelect")
	public String jdmeBoardQnaSelect(HttpServletRequest req, Model model, JDMEBoardQnaVO jbqvo) {
		
		logger.info("JDMEBoardQnaController jdmeBoardQnaSelect 함수 진입");
		
		List<JDMEBoardQnaVO> listS = jdmeBoardQnaService.jdmeBoardQnaSelect(jbqvo);
		
		if(listS.size() == 1) {
			logger.info("listS --> : " + listS);
			
			model.addAttribute("listS",listS);
			return "qna/JDMEBoardQnaSelect";
			
		}
		
		return "qna/JDMEBoardQnaSelect";
	}
	
	// 수정하기
	@GetMapping(value="JDMEBoardQnaUpdate")
	public String jdmeBoardQnaUpdate(HttpServletRequest req, JDMEBoardQnaVO jbqvo, Model model) {
		
		logger.info("JDMEBoardQnaController jdmeBoardQnaUpdate 함수 진입");
		String jqcontent = req.getParameter("jqcontent");
		String jqnum = req.getParameter("jqnum");
		
		JDMEBoardQnaVO _jbqvo = null;
		
		_jbqvo = new JDMEBoardQnaVO();
		
		_jbqvo.setJqcontent(jqcontent);
		_jbqvo.setJqnum(jqnum);
		logger.info("jqcontent --> : " + _jbqvo.getJqcontent());
		logger.info("jqnum --> : " + _jbqvo.getJqnum());
		
		int uCnt = jdmeBoardQnaService.jdmeBoardQnaUpdate(_jbqvo);
		
		if(uCnt > 0) {
			logger.info("uCnt --> : " + uCnt);
			model.addAttribute("uCnt",uCnt);
			return "qna/JDMEBoardQnaUpdate";
		}
		return "qna/JDMEBoardQnaSelectAll";
	}
	
	// 질문 게시판 수정 할 때 비밀번호 체크
	@PostMapping(value="JDMEBoardQnaPwcheck")
	@ResponseBody
	public Object jdmeBoardQnaPwcheck(JDMEBoardQnaVO jbqvo) {
		
		logger.info("JDMEBoardQnaController jdmeBoardQnaPwcheck 함수 진입");
		
		logger.info("jbqvo.getjqpw --> : "  + jbqvo.getJqpw());
		
		List<JDMEBoardQnaVO> list = jdmeBoardQnaService.jdmeBoardQnaPwcheck(jbqvo);
		
		String msg = "";
		if(list.size() == 1) {
			msg = "PW_YES";
		}else {
			msg = "PW_NO";
		}
		
		logger.info("msg --> : " + msg);
		return msg;
	}
	
	
	
}// end of Controller


