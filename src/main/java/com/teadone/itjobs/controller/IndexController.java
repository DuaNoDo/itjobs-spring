package com.teadone.itjobs.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.gson.Gson;
import com.teadone.itjobs.ad.AdvertisementService;
import com.teadone.itjobs.ad.AdvertisementVO;
import com.teadone.itjobs.notice.NoticeMapper;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class IndexController {	
	
	@Autowired
	private AdvertisementService service;
	
	
	@Autowired
	private NoticeMapper nmapper;
	
	
	

	@GetMapping(value = { "/", "index" })
	public String home(HttpSession session, ModelMap model) {
		AdvertisementVO param = new AdvertisementVO();
		param.setAdv_display("top");
		model.put("tAdv", service.getAdvertisement(param));
		
		AdvertisementVO mparam = new AdvertisementVO();
		mparam.setAdv_display("mid");
		//model.put("mAdv", service.getAdvertisement(mparam).subList(0, 12));
		model.put("mAdv", service.getAdvertisement(param));
		model.put("notice", nmapper.getNotice());
		return "index";

	}

	@ResponseBody
	@GetMapping(value = "/ajax/{count}")
	public String ajaxmore(@PathVariable int count) {

		int start = count * 8;
		int end = (count + 1) * 8;
		AdvertisementVO mparam = new AdvertisementVO();
		mparam.setAdv_display("mid");
		List<AdvertisementVO> list = service.getAdvertisement(mparam);
		List<AdvertisementVO> subList = list.subList(start, end);
		Gson gson = new Gson();

		return gson.toJson(subList);
	}

	@GetMapping(value = { "IT_logIn" })
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

	
	@RequestMapping(value = "/content/{num}")
	public String getContent(@PathVariable int num, ModelMap model) {
		AdvertisementVO vo= new AdvertisementVO();
		vo.setAdv_num(num);
		model.put("adv",service.getAdvCont(vo));

		return "/content";
	}
}
