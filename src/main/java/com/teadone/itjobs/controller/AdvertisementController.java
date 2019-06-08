package com.teadone.itjobs.controller;

import java.util.Collections;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartRequest;

import com.teadone.itjobs.ad.AdvertisementService;
import com.teadone.itjobs.ad.AdvertisementVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class AdvertisementController {

	@Autowired
	private AdvertisementService service;

	
	@RequestMapping(value = "/AddAdvWrite", method = RequestMethod.POST)
	public String addAdv(AdvertisementVO vo, HttpSession session) throws Exception {
		

			
		vo.setAdv_company(session.getAttribute("user").toString());
		service.insertAdv(vo);

		return "redirect:index";

	}
}
