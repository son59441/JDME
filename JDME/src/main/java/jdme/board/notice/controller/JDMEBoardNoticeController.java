package jdme.board.notice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jdme.board.notice.service.JDMEBoardNoticeService;
import jdme.board.notice.vo.JDMEBoardNoticeVO;
import jdme.common.ChabunUtil;
import jdme.common.CommonUtils;
import jdme.common.FileUploadUtil;
import jdme.common.service.ChabunService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;





@Controller
public class JDMEBoardNoticeController {
	
	Logger logger = LogManager.getLogger(JDMEBoardNoticeController.class);
	
	// 필드 오토와이어드로 서비스 선언 : 인스턴스가 자동으로 주입 
	// 해당 변수 및 메서드에 스프링이 관리하는 Bean을 자동으로 매핑해주는 개념
	// 채번을 생성하기 위함
	@Autowired(required=false)
	private ChabunService chabunService;
	
	@Autowired(required=false)
	private JDMEBoardNoticeService jdmeBoardNoticeService;
	
	// 공지사항 글 쓰기 페이지 이동
	@GetMapping(value="JDMEBoardNoticeInsertForm")
	public String jdmeBoardNoticeInsertForm() {
		
		logger.info("JDMEBoarcdNoticeController jdmeBoardNoticeInsertForm 함수 진입");
		
		return "notice/JDMEBoardNoticeInsertForm";
	}
	
	
	// 공지사항 게시판 글 쓰기
	@PostMapping(value="JDMEBoardNoticeInsert")
	public String jdmeBoardNoticeInsert(HttpServletRequest req) {
		
		logger.info("JDMEBoarcdNoticeController jdmeBoardNoticeInsert 함수 진입");
		
		// 공지사항 채번 구해주기
		String jnnum = ChabunUtil.BoardNoticeChabun("N", chabunService.getBoardNoticeChabun().getJnnum());
		logger.info("jdmeBoardNoticeInsert jnnum --> : " + jnnum);
		
		// 이미지 업로드
		FileUploadUtil fu = new FileUploadUtil(CommonUtils.BOARD_NOTICE_IMG_UPLOAD_PATH,
											   CommonUtils.BOARD_NOTICE_IMG_FILE_SIZE,
											   CommonUtils.BOARD_NOTICE_EN_CODE);
		
		// 이미지 파일 업로드 해서 값이 있는 지 체크
		boolean bool = fu.imgfileUpload(req);
		logger.info("jdmeBoardNoticeInsert bool --> : " + bool);
		
		
		// 깡통 클래스에 값을 바인딩
		JDMEBoardNoticeVO _jbnvo = null;
		_jbnvo = new JDMEBoardNoticeVO();
		
		_jbnvo.setJnnum(jnnum);
		_jbnvo.setAdmin(fu.getParameter("admin"));
		_jbnvo.setJnsubject(fu.getParameter("jnsubject"));
		_jbnvo.setJncontent(fu.getParameter("jncontent"));
		_jbnvo.setJnfile(fu.getFileName("jnfile"));
		
		logger.info("jnnum --> : " + jnnum);
		logger.info("admin --> : " + fu.getParameter("admin"));
		logger.info("jnsubject --> : " + fu.getParameter("jnsubject"));
		logger.info("jncontent --> : " + fu.getParameter("jncontent"));
		logger.info("jnfile --> : " + fu.getParameter("jnfile"));
		
		// 서비스를 가지고 _jbnvo에 값을 마이바티스까지 들렸다가 온다.
		int nCnt = jdmeBoardNoticeService.jdmeBoardNoticeInsert(_jbnvo);
		if(nCnt > 0) {
			logger.info("jdmeBoardNoticeInsert nCnt --> : " + nCnt);
			return "notice/JDMEBoardNoticeInsert";
		}
		
		return "notice/JDMEBoardNoticeInsertForm";
	}
	
	// 공지사항 게시판 전체 조회
	@GetMapping(value="JDMEBoardNoticeSelectAll")
	public String jdmeBoardNoticeSelectAll(JDMEBoardNoticeVO jbnvo, Model model) {
		
		logger.info("JDMEBoarcdNoticeController jdmeBoardNoticeSelectAll 함수 진입");
		
		// 페이징 처리 하기 위한 작업 
		int pageSize = CommonUtils.BOARD_PAGE_SIZE;
		int groupSize = CommonUtils.BOARD_GROUP_SIZE;
		int curPage = CommonUtils.BOARD_CUR_PAGE;
		int totalCount = CommonUtils.BOARD_TOTAL_COUNT;
						
		
		// 페이지가 넘어 가는 지 체크해주기 위함
		if (jbnvo.getCurPage() !=null){
			curPage = Integer.parseInt(jbnvo.getCurPage());
		}
		
		// 담아주기 위한 작업 형변환이 필요한 작업
		jbnvo.setPageSize(String.valueOf(pageSize));
		jbnvo.setGroupSize(String.valueOf(groupSize));
		jbnvo.setCurPage(String.valueOf(curPage));
		jbnvo.setTotalCount(String.valueOf(totalCount));
		
		
		// 서비스 호출하기
		List<JDMEBoardNoticeVO> listAll = jdmeBoardNoticeService.jdmeBoardNoticeSelectAll(jbnvo);
		if(listAll.size() > 0) {
			
			logger.info("listAll --> : " + listAll);
			
			model.addAttribute("pagingNotice", jbnvo);
			model.addAttribute("listAll",listAll);
			return "notice/JDMEBoardNoticeSelectAll";
			
		}
		
		return "/JDME/index.jsp";
	}
	
	
	// 공지사항 게시판 조건 조회
	@GetMapping(value="JDMEBoardNoticeSelect")
	public String JDMEBoardNoticeSelect(JDMEBoardNoticeVO jbnvo, Model model) {
		
		logger.info("JDMEBoarcdNoticeController jdmeBoardNoticeSelectAll 함수 진입");
		
		// 서비스 호출하기
		List<JDMEBoardNoticeVO> listS = jdmeBoardNoticeService.jdmeBoardNoticeSelect(jbnvo);
		if(listS.size() > 0) {
			
			logger.info("listAll --> : " + listS);
			
			model.addAttribute("listS",listS);
			return "notice/JDMEBoardNoticeSelect";
			
		}
		
		return "notice/JDMEBoardNoticeSelectAll";
	}
	
	
	
} // end of Controller
