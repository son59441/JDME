package jdme.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import jdme.common.ChabunUtil;
import jdme.common.CommonUtils;
import jdme.common.FileUploadUtil;
import jdme.common.service.ChabunService;
import jdme.member.service.JDMEMemberService;
import jdme.member.vo.JDMEMemberVO;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


@Controller
public class JDMEMemberController {
	
	//로그4J
	Logger logger = LogManager.getLogger(JDMEMemberController.class);
	
	//멤버서비스 필드DI
	@Autowired(required=false)
	private JDMEMemberService jDMEMemberService;
	
	//채번 필드 DI
	@Autowired(required=false)
	private ChabunService chabunService;
	
	/*암호화
	@Autowired(required=false)
	private EncryptSHA encryptSHA;*/
	
//IF
	@RequestMapping(value="jdmeMemberInsertForm", method=RequestMethod.GET)
	public String kosmoMemberInsertForm() {
		logger.info("멤버컨 멤버컨 멤버컨 멤버컨 IF IF IF IF IF IF ");
		return "mem/jdmeMemberInsertForm";
	}
	
//I
	@RequestMapping(value="jdmeMemberInsert", method=RequestMethod.POST)
	public String jdmeMemberInsert(HttpServletRequest req, JDMEMemberVO jmvo) {
		
		logger.info("멤버컨 멤버컨 멤버컨 IIIIIIIIIII ");
		
		//회원번호를 채번적용
		String jmnum = ChabunUtil.getMemChabun("N", chabunService.getMemberChabun().getJmnum());
		logger.info("JMNUM >>> : " + jmnum);
		jmvo.setJmnum(jmnum);
		
		/*이미지업로드*/
		FileUploadUtil fu = new FileUploadUtil(CommonUtils.MEMBER_IMG_UPLOAD_PATH
											  ,CommonUtils.TEST_IMG_FILE_SIZE
											  ,CommonUtils.TEST_IMG_ENCODE);
		logger.info("fu >>>>>> : " + fu);
		logger.info("req >>> : " + req);
		
		//이미지 파일 원본 사이즈
		boolean bool = fu.imgfileUpload(req);
		logger.info("멤버컨 멤버컨 멤버컨 I bool >>> : " + bool);
		/*
		 * Obj obj = req.getParameter("jmph1");
		 * String jmph = (String)req.getParamger("jmph1");
		 * */
		
		//새로운 VO 한다
		JDMEMemberVO _jmvo = null;
		_jmvo = new JDMEMemberVO();
		
		//새로운 VO에 세팅
		_jmvo.setJmnum(jmnum);
		_jmvo.setJmname(fu.getParameter("jmname"));
		_jmvo.setJmid(fu.getParameter("jmid"));
		_jmvo.setJmpw(fu.getParameter("jmpw"));
		_jmvo.setJmbirth(fu.getParameter("jmbirth"));
		_jmvo.setJmgender(fu.getParameter("jmgender"));
		String jmhp = fu.getParameter("jmhp");
		jmhp = jmhp.concat(fu.getParameter("jmhp1")).concat(fu.getParameter("jmhp2"));
		_jmvo.setJmhp(jmhp);
		String jmemail = fu.getParameter("jmemail");
		jmemail = jmemail.concat("@").concat(fu.getParameter("jmemail1"));
		_jmvo.setJmemail(jmemail);
		_jmvo.setJmzipcode(fu.getParameter("jmzipcode"));
		_jmvo.setJmaddr(fu.getParameter("jmaddr"));
		_jmvo.setJmaddrdetail(fu.getParameter("jmaddrdetail"));
		_jmvo.setJmimage(fu.getFileName("jmimage"));
		_jmvo.setDeleteyn(fu.getParameter("deleteyn"));		
		
		
		//로그 확인
		logger.info("I LOG I LOG I LOG I LOG I LOG I LOG I LOG");
		logger.info("fu를 거치지 않은 _jmvo.getKmnum >>> : " + _jmvo.getJmnum());
		logger.info("_jmvo.getJmname >>> : " + _jmvo.getJmname());
		logger.info("_jmvo.getJmid >>> : " + _jmvo.getJmid());
		logger.info("_jmvo.getJmpw >>> : " + _jmvo.getJmpw());
		logger.info("_jmvo.getJmbirt >>> : " + _jmvo.getJmbirth());
		logger.info("_jmvo.getJmgender >>> : " + _jmvo.getJmgender());
		logger.info("_jmvo.getJmhp >>> : " + _jmvo.getJmhp());
		logger.info("_jmvo.getJmemail >>> : " + _jmvo.getJmemail());
		logger.info("_jmvo.getJmzipcode >>> : " + _jmvo.getJmzipcode());
		logger.info("_jmvo.getJmaddr >>> : " + _jmvo.getJmaddr());
		logger.info("_jmvo.getJmaddrdetail >>> : " + _jmvo.getJmaddrdetail());
		logger.info("_jmvo.getJmimage >>> : " + _jmvo.getJmimage());
		logger.info("_jmvo.getJmaccess >>> : " + _jmvo.getJmaccess());
		logger.info("I LOG I LOG I LOG I LOG I LOG I LOG I LOG");
		
		//서비스 호출
		int nCnt = jDMEMemberService.jdmeMemberInsert(_jmvo);
		logger.info("멤버컨 멤버컨 :::  jdmeMemberInsert nCnt의 값, 1이면 인서트는 성공한 것 : " + nCnt);
		
		if(nCnt>0) {
			//product/kosmoproductSelectAll
			return "mem/jdmeMemberInsert";
		}
		logger.info("========================무언가의 문제로 인서트가 일어나지 않았습니다!==========================");
		return "mem/jdmeMemberFail";
	}
	
	
	//아이디 중복체크
	@RequestMapping(value="jdmeIdCheck", method=RequestMethod.POST)
	@ResponseBody //뷰리졸빙을 하지 않고 클라이언트로 바로 쏘아라 라는 의미
	public Object jdmeIdCheck(JDMEMemberVO jmvo) {
		logger.info("멤버컨트롤러 :::  jdmeIdCheck() 함수 진입 >>> :");		
		logger.info("멤버컨트롤러 :::  jdmeIdCheck() ::: jmvo.getJmid() >>> : " + jmvo.getJmid());			
		
		List<JDMEMemberVO> list = jDMEMemberService.jdmeIdCheck(jmvo);			
		logger.info("멤버컨트롤러 ::: jdmeIdCheck list.size() >>> : " + list.size());
		
		String msg = "";
		if (list.size() == 0) {msg = "ID 사용가능";}  
		else { msg = "ID 중복";}  
		
		return msg;		
	}

}
