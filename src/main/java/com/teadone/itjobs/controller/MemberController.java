package com.teadone.itjobs.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.teadone.itjobs.mem.CMemVO;
import com.teadone.itjobs.mem.MemberService;
import com.teadone.itjobs.mem.PMemVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MemberController {

	@Autowired
	private MemberService service;

	@RequestMapping(value = "/pLogin", method = RequestMethod.POST)
	public String pLogin(HttpServletRequest request,HttpSession session) {

		String IT_id=request.getParameter("IT_id");
		if(IT_id.isEmpty()) {
			return "IT_logIn";
		}
		String IT_pass=request.getParameter("IT_pass");
		PMemVO vo=new PMemVO();
		vo.setIT_id(IT_id);

		if(service.checkPMem(vo).equals(IT_pass)) {
			session.setAttribute("user", IT_id);
			session.setAttribute("logout", "로그아웃");
			session.setAttribute("logOL", "/logout");
			return "redirect:/index";
		}
		else {
			return "IT_logIn";
		}	 

	}
	@RequestMapping(value = "/cLogin", method = RequestMethod.POST)
	public String cLogin(HttpServletRequest request,HttpSession session) {

		String IT_id=request.getParameter("IT_id");
		if(IT_id.isEmpty()) {
			return "IT_logIn";
		}
		String IT_pass=request.getParameter("IT_pass");
		CMemVO vo=new CMemVO();
		vo.setIT_C_id(IT_id);

		if(service.checkCMem(vo).equals(IT_pass)) {
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

	@RequestMapping(value="/pJoin", method=RequestMethod.POST)
	public String pJoin(@ModelAttribute PMemVO vo,HttpServletRequest request,HttpSession session) {	
		service.pJoin(vo);

		return "redirect:/index";

	}
	@RequestMapping(value="/cJoin", method=RequestMethod.POST)
	public String cJoin(@ModelAttribute CMemVO vo,HttpServletRequest request,HttpSession session) {	
		service.cJoin(vo);

		return "redirect:/index";

	}
	@RequestMapping(value="/pDupCheck", method=RequestMethod.GET)
	public void pDupCheck(HttpServletRequest request ,HttpServletResponse response) throws IOException {

		PMemVO vo=new PMemVO();
		vo.setIT_id(request.getParameter("IT_id"));
		int rst=0;
		rst=service.checkPMemDup(vo);

		if(rst==0)
			response.getWriter().println("You can use this id");	
		else
			response.getWriter().println("cannot use this id");

	}
	@RequestMapping(value="/cDupCheck", method=RequestMethod.GET)
	public void cDupCheck(HttpServletRequest request,HttpServletResponse response) throws IOException {

		CMemVO vo=new CMemVO();
		vo.setIT_C_id(request.getParameter("IT_C_id"));
		int rst=0;
		rst=service.checkCMemDup(vo);

		if(rst==0)
			response.getWriter().println("You can use this id");	
		else
			response.getWriter().println("cannot use this id");	

	}
	@PostMapping(value="/updateCMem")
	public String upCMem(CMemVO vo){
		service.upCMem(vo);
		return "redirect/index";
	}
	@PostMapping(value="/updatePMem")
	public String upPMem(PMemVO vo){
		service.upPMem(vo);
		return "redirect/index";
	}
	@RequestMapping(value="/memFind")
	public String memFind() {
		return "/memFind";
	}
	
	
	@RequestMapping(value="/cFindId" ,method=RequestMethod.POST)
	public String cFindId(CMemVO vo,ModelMap model) {
		String getId=service.cFindId(vo);
		
		if(getId==null) {
			model.put("script", "아이디 없쪙");
			return "memFind";
		}
		else {
			model.put("script", "당신의 아이디는 :"+getId+" 입네다");
			return "IT_login";
		}
	}
	
	@RequestMapping(value="/cFindPw" ,method=RequestMethod.POST)
	public String cFindPw(CMemVO vo,ModelMap model) {
		String getPw=service.cFindPw(vo);
		if(getPw==null) {
			model.put("script", "아이디 없쪙");
			return "memFind";
		}
		else {
			model.put("script", "당신의 아이디는 :"+getPw+" 입네다");
			return "IT_login";
		}
	}
	
	@RequestMapping(value="/pFindId" ,method=RequestMethod.POST)
	public String pFindId(PMemVO vo,ModelMap model) {
		String getId=service.pFindId(vo);
		if(getId==null) {
			model.put("script", "아이디 없쪙");
			return "memFind";
		}
		else {
			model.put("script", "당신의 아이디는 :"+getId+" 입네다");
			return "IT_login";
		}
	}
	
	@RequestMapping(value="/pFindPw" ,method=RequestMethod.POST)
	public String pFindPw(PMemVO vo,ModelMap model) {
		String getPw=service.pFindPw(vo);
		if(getPw==null) {
			model.put("script", "아이디 없쪙");
			return "memFind";
		}
		else {
			model.put("script", "당신의 아이디는 :"+getPw+" 입네다");
			return "IT_login";
		}
	}
	
}


