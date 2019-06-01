package com.teadone.itjobs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.teadone.itjobs.ad.AdvertisementService;


import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class AdvertisementController {
	
	@Autowired
	private AdvertisementService service;
	
	@RequestMapping(value = "/AddAdvWrite", method = RequestMethod.POST)
	public String addAdv(HttpServletRequest request,HttpSession session) throws Exception {
		
		service.insertAdv(request,session);
		
	return "redirect:index";
		
	 }
}
