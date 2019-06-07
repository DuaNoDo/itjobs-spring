package com.teadone.itjobs.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
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
		model.put("mAdv", mapper.getAdvertisement(mparam).subList(0, 12));
		
		model.put("notice", nmapper.getNotice());
		return "index";
		
		
	}
	@ResponseBody
	@GetMapping(value="/ajax/{count}")
	public String ajaxmore(@PathVariable int count) {
		
		int start=count*8;
		int end=(count+1)*8;
		AdvertisementVO mparam = new AdvertisementVO();
		mparam.setAdv_display("mid");
		ArrayList<AdvertisementVO> list=mapper.getAdvertisement(mparam);
		List<AdvertisementVO> subList=list.subList(start, end);
		Gson gson=new Gson();
		
		return gson.toJson(subList);
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
