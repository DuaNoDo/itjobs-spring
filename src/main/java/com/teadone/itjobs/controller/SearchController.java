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
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class SearchController {
	@Autowired
	private AdvertisementMapper mapper; 
	
	@RequestMapping(value="/searchList", method = RequestMethod.GET)
	public String searchAdv(HttpSession session, HttpServletRequest request ,ModelMap model) {
		AdvSearchVO vo=new AdvSearchVO();
		vo.setSort(request.getParameter("sort"));
		vo.setKeyword(request.getParameter("keyword"));
		
		model.put("sAdv",mapper.getSearchAdv(vo));
	
		return "/searchList";
		
	}
}
