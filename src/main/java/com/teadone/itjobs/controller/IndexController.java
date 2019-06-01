package com.teadone.itjobs.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.teadone.itjobs.ad.AdvertisementMapper;
import com.teadone.itjobs.ad.AdvertisementVO;

import lombok.extern.slf4j.Slf4j;



@Controller
@Slf4j
public class IndexController {

	@Autowired
	private AdvertisementMapper mapper;
	
	@GetMapping(value = {"/","index"})
	public String home(HttpSession session, ModelMap model) {
		AdvertisementVO param = new AdvertisementVO();
		param.setAdv_display("top");		
		model.put("tAdv", mapper.getAdvertisement(param));
		
		AdvertisementVO mparam = new AdvertisementVO();
		mparam.setAdv_display("mid");
		model.put("mAdv", mapper.getAdvertisement(mparam));
		
		/*
		 * if(session.getAttribute("user").toString().isEmpty()){
		 * session.setAttribute("user", "로그인"); }
		 */
		return "index";
		
		
	}
	
	@GetMapping(value = {"IT_logIn"})
	public String login(HttpSession session, ModelMap model) {
		return "IT_logIn";
	}
	
}
