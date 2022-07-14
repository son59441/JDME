package jdme.board.com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jdme.board.com.service.JDMEBoardComService;
import jdme.board.com.vo.JDMEBoardComVO;
import jdme.common.ChabunUtil;
import jdme.common.CommonUtils;
import jdme.common.FileUploadUtil;
import jdme.common.service.ChabunService;

@Controller
public class JDMEBoardComController {

	Logger logger = LogManager.getLogger(JDMEBoardComController.class);
	
	// @Autowired를 설정한 메서드가 자동으로 호출되고, 인스턴스가 자동으로 주입
	@Autowired(required=false)
	private ChabunService chabunService;
	@Autowired(required=false)
	private JDMEBoardComService jdmeBoardComService;
	
	
	// 커뮤니티 게시판 등록하는 페이지
	@GetMapping(value="JDMEBoardComInsertForm")
	public String jdmeBoardComInsertForm() {
		
		logger.info("JDMEBoardComController jdmeBoardComInsertForm 함수진입");
		
		return "board/JDMEBoardComInsertForm";
	}	
	
	// 커뮤니티 게시판 입력하는 곳
	@PostMapping(value="JDMEBoardComInsert")
	public String jdmeBoardComInsert(HttpServletRequest req,JDMEBoardComVO jbcvo) {
		
		logger.info("JDMEBoardComController jdmeBoardComInsert 함수 진입");
		
		// 커뮤니티 게시판 채번 
		String jbnum = ChabunUtil.BoardComChabun("N", chabunService.getBoardComChabun().getJbnum());
		
		FileUploadUtil fu = new FileUploadUtil(	 CommonUtils.BOARD_COM_IMG_UPLOAD_PATH
								                ,CommonUtils.BOARD_COM_IMG_FILE_SIZE
								                ,CommonUtils.BOARD_COM_EN_CODE);
		
		// 이미지 파일 원본 사이즈 
		boolean bool = fu.imgfileUpload(req);
		logger.info("jdmeBoardComInsert bool --> : " + bool);
		
		// 입력 한 값을 받아서 넘겨주기 위한 작업
		JDMEBoardComVO _jbcvo = null;
		_jbcvo = new JDMEBoardComVO();
		
		_jbcvo.setJbnum(jbnum);
		_jbcvo.setJmnum(fu.getParameter("jmnum"));
		_jbcvo.setJbsubject(fu.getParameter("jbsubject"));
		_jbcvo.setJmid(fu.getParameter("jmid"));
		_jbcvo.setJbcontent(fu.getParameter("jbcontent"));
		_jbcvo.setJbpw(fu.getParameter("jbpw"));
		_jbcvo.setJbfile(fu.getFileName("jbfile"));
		
		logger.info("jbnum --> : " + jbnum);
		logger.info("jmnum --> : " + fu.getParameter("jmnum"));
		logger.info("jbsubject --> : " + fu.getParameter("jbsubject"));
		logger.info("jmid --> : " + fu.getParameter("jmid"));
		logger.info("jbcontent --> : " + fu.getParameter("jbcontent"));
		logger.info("jbpw --> : " + fu.getParameter("jbpw"));
		logger.info("jbfile --> : " + fu.getFileName("jbfile"));
		
		int nCnt = jdmeBoardComService.jdmeBoardComInsert(_jbcvo);
		if(nCnt > 0) {
			logger.info("jdmeBoardComInsert nCnt --> : " + nCnt);
			return "board/JDMEBoardComInsert";
		}
		return "board/JDMEBoardComInsertForm";
	}
	
	
	// 커뮤니티 게시판 전체 조회
	@GetMapping(value="JDMEBoardComSelectAll")
	public String jdmeBoardComSelectAll(JDMEBoardComVO jbcvo, Model model) {
		logger.info("JDMEBoardComController jdmeBoardComSelectAll 함수진입");
		
		// 페이징 처리 하기 위한 작업 
		int pageSize = CommonUtils.BOARD_PAGE_SIZE;
		int groupSize = CommonUtils.BOARD_GROUP_SIZE;
		int curPage = CommonUtils.BOARD_CUR_PAGE;
		int totalCount = CommonUtils.BOARD_TOTAL_COUNT;
				
		// 페이지가 넘어 가는 지 체크해주기 위함
		if (jbcvo.getCurPage() !=null){
			curPage = Integer.parseInt(jbcvo.getCurPage());
		}
		
		// 담아주기 위한 작업 형변환이 필요한 작업
		jbcvo.setPageSize(String.valueOf(pageSize));
		jbcvo.setGroupSize(String.valueOf(groupSize));
		jbcvo.setCurPage(String.valueOf(curPage));
		jbcvo.setTotalCount(String.valueOf(totalCount));
		
		logger.info("getPageSize --> : " + jbcvo.getPageSize());
		logger.info("getGroupSize --> : " + jbcvo.getGroupSize());
		logger.info("getCurPage --> : " + jbcvo.getCurPage());
		logger.info("getTotalCount --> : " + jbcvo.getTotalCount());
		
		
		// 서비스 호출하기
		List<JDMEBoardComVO> listAll = jdmeBoardComService.jdmeBoardComSelectAll(jbcvo);
		
		if(listAll.size() > 0) {
			
			logger.info("listAll --> : " + listAll);
			
			model.addAttribute("pagingCom", jbcvo);
			model.addAttribute("listAll",listAll);
			return "board/JDMEBoardComSelectAll";
			
		}
	
		return "board/JDMEBoardComInsertForm";	
	}

	// 조건조회로 커뮤니티 게시판 보기
	@GetMapping(value="JDMEBoardComSelect")
	public String jdmeBoardComSelect(HttpServletRequest req, Model model, JDMEBoardComVO jbcvo) {
		
		logger.info("JDMEBoardComController jdmeBoardComSelect 함수 진입 ");		
		logger.info("jbnum --> : " + jbcvo.getJbnum());
		logger.info("jmnum --> : " + jbcvo.getJmnum());
		
		List<JDMEBoardComVO> listS = jdmeBoardComService.jdmeBoardComSelect(jbcvo);
		
		if(listS.size() == 1) {
			logger.info("listS --> : " + listS);
			
			model.addAttribute("listS",listS);
			return "board/JDMEBoardComSelect";
			
		}
		
		return "board/JDMEBoardComSelectAll";
				
	}

	// 수정하기
	@GetMapping(value="JDMEBoardComUpdate")
	public String jdmeBoardComUpdate(HttpServletRequest req, JDMEBoardComVO jbcvo, Model model) {
		
		logger.info("JDMEBoardComController jdmeBoardComUpdate 함수 진입");
		String jbcontent = req.getParameter("jbcontent");
		String jbnum = req.getParameter("jbnum");
		
		JDMEBoardComVO _jbcvo = null;
		
		_jbcvo = new JDMEBoardComVO();
		
		_jbcvo.setJbcontent(jbcontent);
		_jbcvo.setJbnum(jbnum);
		logger.info("jqcontent --> : " + _jbcvo.getJbcontent());
		logger.info("jqnum --> : " + _jbcvo.getJbnum());
		
		int uCnt = jdmeBoardComService.jdmeBoardComUpdate(_jbcvo);
		
		if(uCnt > 0) {
			logger.info("uCnt --> : " + uCnt);
			model.addAttribute("uCnt",uCnt);
			return "board/JDMEBoardComUpdate";
		}
		return "board/JDMEBoardComSelectAll";
	}
	
	// 커뮤니티 게시판 수정 할 때 비밀번호 체크
	@PostMapping(value="JDMEBoardComPwcheck")
	@ResponseBody
	public Object jdmeBoardComPwcheck(JDMEBoardComVO jbcvo) {
		
		logger.info("JDMEBoardComController jdmeBoardComPwcheck 함수 진입");
		
		logger.info("jbcvo.getjbpw --> : "  + jbcvo.getJbpw());
		
		List<JDMEBoardComVO> list = jdmeBoardComService.jdmeBoardComPwcheck(jbcvo);
		
		String msg = "";
		if(list.size() == 1) {
			msg = "PW_YES";
		}else {
			msg = "PW_NO";
		}
		
		logger.info("msg --> : " + msg);
		return msg;
	}
		
	
}
