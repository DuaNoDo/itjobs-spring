package com.teadone.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.teadone.itjobs.ad.AdvertisementMapper;
import com.teadone.itjobs.ad.AdvertisementVO;



@Controller
@RequestMapping({"","/index"})
public class IndexController {

	@Autowired
	private AdvertisementMapper mapper;
	
	@GetMapping
	public String home(HttpSession session, ModelMap model) {
		AdvertisementVO param = new AdvertisementVO();
		param.setAdv_display("top");
		ArrayList<AdvertisementVO> advList=mapper.getAdvertisement(param);
		
		model.addAttribute("Adv", advList);
		System.out.println("리스트다아아아 :"+advList);
		return "index";
	}
}
