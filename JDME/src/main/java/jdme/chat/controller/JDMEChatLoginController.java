package jdme.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
	 * Handles requests for the application home page.
	 */
@Controller
public class JDMEChatLoginController {
	
	private static final Logger logger = LogManager.getLogger(JDMEChatLoginController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "chatLogin", method = RequestMethod.GET)
	public String login() {
		return "chat/jdmeChatChat";
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "chatLoginProcess", method = RequestMethod.POST)
	public String loginProcess(@RequestParam String id, HttpServletRequest request) {
		
		logger.info("Welcome "+id);
		logger.info("Your ID is : " + id);
		
    	HttpSession session = request.getSession();
    	session.setAttribute("id", id);
    	
    	logger.info("Your Session is : " + session.getAttribute("id"));
		return "chat/jdmeChatLogin";
	}
	
}
