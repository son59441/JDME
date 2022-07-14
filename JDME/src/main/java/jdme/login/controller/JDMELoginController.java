package jdme.login.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jdme.common.EncryptSHA;
import jdme.common.GoogleMailSend;
import jdme.common.K_Session;
import jdme.common.PasswordUtil;
import jdme.login.service.JDMELoginService;
import jdme.login.vo.ChangePwVO;
import jdme.login.vo.TempAuthNumVO;
import jdme.login.vo.TempPwVO;
import jdme.member.controller.JDMEMemberController;
import jdme.member.vo.JDMEMemberVO;

@Controller
public class JDMELoginController {
	
	Logger logger = LogManager.getLogger(JDMELoginController.class);
	
	//필드 오토와이어드
	@Autowired(required=false)
	private JDMELoginService jDMELoginService;

	
//로그인 폼
	@RequestMapping(value="jdmeLoginForm", method=RequestMethod.GET)
	public String kosmoLoginForm() {
		logger.info("로그인 컨트롤러 ::: 로그인폼 입장");
		return "login/jdmeLoginForm";
	}
	
	
//로그인체크
	@RequestMapping(value="jdmeLoginCheck", method=RequestMethod.GET)
	public String jdmeLoginCheck(HttpServletRequest req, JDMEMemberVO jmvo, Model model) {
		logger.info("=====컨트롤러 ::: jdmeLoginCheck() 함수 입장");
		
		//서비스 로직 호출
		List<JDMEMemberVO> listLogin=jDMELoginService.jdmeLoginCheck(jmvo);
		logger.info("listLoginSize >>> : ");
		
		
		//아이디가 존재합니다.
		if(listLogin.size()==1) {
			logger.info("컨트롤러 ::: 아이디체크함수 ::: listLogin >>> : " + listLogin);
			
			//ks를 인스턴스(K_Session)
			K_Session ks = K_Session.getInstance();
			logger.info("로그인 할 때 세션 주소 ::: >>> "+ ks);
			//K_SESSION_ID(const KID)에 대한 값을 가지면 String KID는 그 값을 바인딩하고, 아니면 null
			String KID =ks.getSession(req);
			
			//null이 아니고, String KID가 listLogin.get(0).getKmid()랑 같으면
			//==이미 세션을 가지고 있다면
			if(KID !=null && KID.equals(listLogin.get(0).getJmid())) {
				logger.info("컨트롤러 로그인 >>> 로그인중 ::: 다른페이지로 이동하기 >>> : " + KID);
				model.addAttribute("listLogin", listLogin);
				return "main/jdmeMainPage";
			}else {//--세션이 아예 없다면(null이라면)--
				//해당 아이디에 세션을 부여한다
				boolean b1 = ks.setSession(req, jmvo.getJmid());
				logger.info("로그인 컨트롤러 ::: 로그인 >>> 세션 부여하기 >>> : " + jmvo.getJmid());
				logger.info("kos.setSession(), false뜨면 세션 부여 완료 >>> : " +b1);
				
				model.addAttribute("listLogin", listLogin);
				return "login/jdmeLoginOK";
						
				}
			}else {
			logger.info("로그인 도중 문제가 발생하였습니다.(jdmeLoginCheck()");
			
			return "login/jdmeLoginFail";
			}
			//로그인 실패 시 Fail.jsp에 alert창 띄우고 <a href=>로 보내기 
		}
		
	@RequestMapping(value="jdmeLoginOK", method=RequestMethod.GET)
	public String jdmeLoginOK(HttpServletRequest req) {
		
		return "login/jdmeLoginOK";
	}
		
//로그아웃
	@RequestMapping(value="jdmeLogout", method=RequestMethod.GET)
	public String kosmoLogout(HttpServletRequest req, JDMEMemberVO jmvo, Model model) {
		logger.info("로그인 컨트롤러 ::: 코스모로그아웃()함수 진입 >>> : ");
		
		
		K_Session ks = K_Session.getInstance();
		logger.info("로그아웃 할 때 세션주소 ::: >>> "+ ks);
		ks.killSession(req);
		
		return "login/jdmeLogout";
	}

// 이메일로 아이디 찾기 시작 ===============================================================
	
// 아이디찾기 입력  폼
	@RequestMapping(value="idFindForm", method=RequestMethod.GET)
	public String idFind() {	
		logger.info("로그인컨 로그인컨 로그인컨 idFind() 함수 진입 >>> : ");
		return "login/jdmeIdFindFome";
	}
// 이메일 확인해서 아이디 찾기  
	@RequestMapping(value="email_authentication",method=RequestMethod.POST)
	public String email_authentication(JDMEMemberVO jmvo, TempAuthNumVO tvo, Model model) {	
		logger.info("로그인컨트롤러 로그인컨트롤러 로그인컨트롤러 email_authentication() 함수 진입 >>> : ");
		
		List<JDMEMemberVO> listEmail = jDMELoginService.emailCheck(jmvo);
		logger.info("로그인컨트롤러 로그인컨트롤러 email_authentication listEmail.size() >>> : " + listEmail.size());
		
		// 이메일이 확인되면 인증번호를 이메일로 인증번호 리턴하기 
		if (listEmail.size() == 1) {
			
			// 인증번호 만들기 
			String email_authentication_num = PasswordUtil.randomPW(6);
			logger.info("로그인컨트롤러 로그인컨트롤러 로그인컨트롤러 email_authentication email_authentication_num >>> : " + email_authentication_num);
			
			// 인증번호를 테이블에 입력하기 TEMP_AUTH_NUM
			tvo.setAuthnum(email_authentication_num);
			int authNumCnt = jDMELoginService.tempAuthNumInsert(tvo);
			
			// 인증번호가 TEMP_AUTH_NUM 입력되면 이메일 전송하기 
			// 이메일 전송 성공 여부는 ??? AJAX에서 체크하면 되지
			if (authNumCnt == 1) {
				// TEMP_AUTH_NUM 테이블에 입력 성공된 인증번호 로 메일 보내기 
				email_authentication_num = tvo.getAuthnum();
				String result = email_authentication_num;
				
				String mailSubject = "KOSMO108기 인증번호 메일입니다.";//임시비밀번호보내기
				String sendMail = "test117394@gmail.com";//보내는사람메일주소
				String sendPw = "zvpacrorcpmirhlm";//보내는사람메일주소비밀번호//앱비밀번호
				String reviceMail = jmvo.getJmemail();//받는사람메일주소
				String sendMsg = email_authentication_num;//임시비밀번호 및 메세지
				
				GoogleMailSend gms = new GoogleMailSend();
				gms.googleMailSend(mailSubject, sendMail, sendPw, reviceMail, sendMsg);
					
				model.addAttribute("authentication_num", email_authentication_num);
				return "login/jdmeIdEmailCheck";
			}
		}		
		return "login/jdmeLoginFome";
	}
	// 인증번호 받아서 아이디 확인하기
	@RequestMapping(value="idFind",method=RequestMethod.GET)
	public String idFind(JDMEMemberVO jmvo, TempAuthNumVO tvo, Model model) {
		logger.info("SpingLoginController idFind() 함수 진입 >>> : ");		
		
		jmvo.setTempauthmemail(tvo.getJmemail());
		jmvo.setTempauthnum(tvo.getAuthnum());
		List<JDMEMemberVO> listIdFind = jDMELoginService.emailIdFind(jmvo);
		logger.info("로그인 컨트롤러 로그인컨트롤러 idFind listIdFind.size() >>> : " + listIdFind.size());
		
		if (listIdFind.size() == 1) { 
			model.addAttribute("listIdFind", listIdFind);
			return "login/jdmeIdFindOK";		
		}				
		return "login/jdmeIdFindFome";
	}
// 이메일로 아이디 찾기 끝 ===============================================================	
	
	
	
	
//아이디로 비밀번호 찾기 시작 ===============================================================
	// 비밃번호 찾기 입력폼
	@RequestMapping(value = "pwFindForm")
	public String pwFindForm() {	
		logger.info("로그인컨트롤러 로그인컨트롤러 pwFind() 함수 진입 >>> : ");
		return "login/jdmePwFindForm";
	}
	
	// 아이디 찾기
	@RequestMapping(value ="pwIdFind")
	public String pwIdFind(JDMEMemberVO jmvo, Model model) {	
		logger.info("로그인컨트롤러 로그인컨트롤러 pwIdFind() 함수 진입 >>> : ");
		
		List<JDMEMemberVO> listPwId = jDMELoginService.pwIdCheck(jmvo);
		logger.info("로그인컨트롤러 pwIdFind함수 listPwId.size() >>> : " + listPwId.size());
		
		return "login/jdmePwTemp";
	}
	
	// 아이디, 이메일을 확인해서 임시비밀번호 받기  
	@RequestMapping(value ="id_email_authentication")
	public String id_authentication(JDMEMemberVO jmvo, TempPwVO tvo, Model model) {	
		logger.info("로그인컨트롤러 id_authentication() 함수 진입 >>> : ");
		
		// 아이디, 이메일 체크 하기 
		List<JDMEMemberVO> listIdEmail = jDMELoginService.pwEmailCheck(jmvo);
		logger.info("로그인컨트롤러 id_authentication listIdEmail.size() >>> : " + listIdEmail.size());
		
		if (listIdEmail.size() == 1) {
			
			// 임시 비빌번호(8자) 만들기 
			String temp_pw_num = PasswordUtil.randomPW(8);
			logger.info("로그인컨트롤러 id_authentication temp_pw_num >>> : " + temp_pw_num);
			
			// 임시 비밀번호 TEMP_PW 테이블에 입력하기 
			tvo.setJmtemppw(temp_pw_num); 
			int tempPwCnt = jDMELoginService.tempPwInsert(tvo);
			logger.info("로그인컨트롤러 id_authentication tempPwCnt) >>> : " + tempPwCnt);
			
			// 입력 성공하면  임시 비밀번호  이메일 보내기 
			// 메일 성공여부는 ???? Ajax로 체크
			if (tempPwCnt == 1) {
				// TEMP_AUTH_NUM 테이블에 입력 성공된 인증번호 로 메일 보내기 
				temp_pw_num = tvo.getJmtemppw();
				
				String mailSubject = "KOSMO108기 발급 된 임시비밀번호 입니다.";//임시비밀번호보내기
				String sendMail = "test117394@gmail.com";//보내는사람메일주소
				String sendPw = "zvpacrorcpmirhlm";//보내는사람메일주소비밀번호//앱비밀번호
				String reviceMail = jmvo.getJmemail();//받는사람메일주소
				String sendMsg = temp_pw_num;//임시비밀번호 및 메세지
				System.out.println("<result>"+temp_pw_num+"</result>");
				GoogleMailSend gms = new GoogleMailSend();
				gms.googleMailSend(mailSubject, sendMail, sendPw, reviceMail, sendMsg);
				
				// idFind 에 메시지 띄우기 
				model.addAttribute("temp_pw_num", temp_pw_num);
				return "login/jdmePwEmailCheck";
			}
		}
		
		return "";
	}
	
	// 임시 비밀번호로 새 비밀번호 만들기 폼  -- 로직 만들기
	@RequestMapping(value ="pwCreateForm")
	public String pwCreateForm(JDMEMemberVO jmvo, TempPwVO tvo, Model model) {
		logger.info("스프링컨트롤러 pwCreateForm() 함수 진입 >>> : ");
		
		return "login/jdmepwCreateForm";
	}
	
	// 임시 비밀번호로 새 비밀번호 만들기 액션
	@RequestMapping(value="pwCreate", method=RequestMethod.GET)
	public String pwCreate(ChangePwVO cpwvo, Model model) {
		logger.info("스프링컨트롤러 pwCreate() 함수 진입 >>> : ");
		
		logger.info("1");
		int nCnt = 0;
		logger.info("2");
		nCnt = jDMELoginService.pwUpdate(cpwvo);
		logger.info("3");
		logger.info("nCnt 1 뜨면 업데이트 성공 >>>>>>> : " + nCnt);
		
		if(nCnt==1) {
			return "login/jdmeLoginForm";
		}else{
			return "login/jdmeLoginFail";
		}
	}
	// 아이디로 비밀번호 찾기 끝 ===============================================================*/	
	
	//헤더찾기 테스트
	@RequestMapping(value="headertest", method=RequestMethod.GET)
	public String headertest(Model model) {
		logger.info("스프링컨트롤러 pwCreate() 함수 진입 >>> : ");
		return "login/headertest";
	}
	
}
