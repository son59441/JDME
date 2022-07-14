package jdme.main.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import javax.servlet.http.Cookie;
import org.apache.log4j.LogManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import jdme.member.vo.JDMEMemberVO;



@Controller
public class JDMEMainController {
	
	Logger logger = LogManager.getLogger(JDMEMainController.class);
	
	@RequestMapping(value="jdmeMainPage", method=RequestMethod.GET)
	public String jdmeMainPage(HttpServletRequest req, JDMEMemberVO jmvo, Model model) {
		logger.info("메인페이지컨 메이페이지컨 메이페이지컨  함수 진입 >>> : ");	
		
		return "main/jdmeMainPage";
	}
	
	@RequestMapping(value="jdmeEnMainPage", method=RequestMethod.GET)
	public String jdmeEnMainPage(HttpServletRequest req, JDMEMemberVO jmvo, Model model) {
		logger.info("메인페이지컨 메이페이지컨 영어 영어 영어 영어 : ");	
		
		return "main/jdmeEnMainPage";
	}
	
	@RequestMapping(value="jdmeJaMainPage", method=RequestMethod.GET)
	public String jdmeJaMainPage(HttpServletRequest req, JDMEMemberVO jmvo, Model model) {
		logger.info("메인페이지컨 메이페이지컨 메이페이지컨  일본어 일본어 일본어 일본어 >>> : ");	
		
		return "main/jdmeJaMainPage";
	}
	
}
