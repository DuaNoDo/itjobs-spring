package com.teadone.itjobs.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import com.teadone.itjobs.ad.AdvertisementMapper;
import com.teadone.itjobs.ad.AdvertisementVO;
import com.teadone.itjobs.notice.NoticeMapper;

import lombok.extern.slf4j.Slf4j;



@Controller
@Slf4j
public class IndexController {

	@Autowired
	private AdvertisementMapper mapper;
	@Autowired
	private NoticeMapper nmapper;
	
	@GetMapping(value = {"/","index"})
	public String home(HttpSession session, ModelMap model) {
		AdvertisementVO param = new AdvertisementVO();
		param.setAdv_display("top");		
		model.put("tAdv", mapper.getAdvertisement(param));
		
		AdvertisementVO mparam = new AdvertisementVO();
		mparam.setAdv_display("mid");
		model.put("mAdv", mapper.getAdvertisement(mparam));
		
		model.put("notice", nmapper.getNotice());
		return "index";
		
		
	}
	
	@GetMapping(value = {"IT_logIn"})
	public String login(HttpSession session, ModelMap model) {
		return "IT_logIn";
	}
	
	@GetMapping(value = "/advWrite")
	public String addAdv(HttpSession session) {
		
		return "/advWrite";
	}
	
	@GetMapping(value = "/join")
	public String join() {
		
		return "/join";
	}
	
	
	
}
