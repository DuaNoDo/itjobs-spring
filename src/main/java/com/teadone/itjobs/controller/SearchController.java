package com.teadone.itjobs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.teadone.itjobs.ad.AdvSearchVO;
import com.teadone.itjobs.ad.AdvertisementMapper;
import com.teadone.itjobs.ad.AdvertisementService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class SearchController {
	@Autowired
	private AdvertisementService service; 
	
	@RequestMapping(value="/searchList", method = RequestMethod.GET)
	public String searchAdv(HttpSession session, HttpServletRequest request ,ModelMap model) {
		AdvSearchVO vo=new AdvSearchVO();
		vo.setSort(request.getParameter("sort"));
		vo.setKeyword(request.getParameter("keyword"));
		
		model.put("sAdv",service.getSearchAdv(vo));
	
		return "/searchList";
		
	}
	@RequestMapping(value="/earchList", method = RequestMethod.GET)
	public String earchAdv(HttpSession session, HttpServletRequest request ,ModelMap model) {
		AdvSearchVO vo=new AdvSearchVO();
		vo.setSort(request.getParameter("sort"));
		vo.setKeyword(request.getParameter("keyword"));
		
		model.put("sAdv",service.getSearchAdv(vo));
	
		return "/searchList";
		
	}
}
