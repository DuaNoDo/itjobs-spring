package com.teadone.itjobs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.teadone.itjobs.mem.MemberMapper;
import com.teadone.itjobs.mem.PMemVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class LoginController {
	
	@Autowired
	private MemberMapper mapper;
	
	@RequestMapping(value = "/pLogin", method = RequestMethod.POST)
	public String pLogin(HttpServletRequest request,HttpSession session) {
		
		String IT_id=request.getParameter("IT_id");
		if(IT_id.isEmpty()) {
			return "IT_logIn";
		}
		String IT_pass=request.getParameter("IT_pass");
		PMemVO vo=new PMemVO();
		vo.setIT_id(IT_id);
		
		if(mapper.checkPMem(vo).equals(IT_pass)) {
			session.setAttribute("user", IT_id);
			session.setAttribute("logout", "로그아웃");
			session.setAttribute("logOL", "/logout");
			return "redirect:/index";
		}
		else {
			return "IT_logIn";
		}	 
		
	 }
	
	@RequestMapping(value="/logout")
	public String Logout(HttpSession session) {
		session.removeAttribute("user");
		session.removeAttribute("logout");
		session.removeAttribute("logOL");
		
		return "redirect:/index";
	}
}
