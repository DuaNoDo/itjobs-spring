package com.teadone.itjobs.ad;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AdvertisementService {
	@Autowired
	Environment env;
	
	@Autowired
	private AdvertisementMapper mapper;
	private static final String filePath = "\\images\\";

	public void insertAdv(AdvertisementVO vo) throws IllegalStateException, IOException{
		if(vo.getFile() != null) {
			MultipartFile f = vo.getFile(); 
			f.transferTo(
					Paths.get(env.getProperty("itjobs.upload.path"), f.getOriginalFilename()));
			vo.setAdv_img(f.getOriginalFilename());
			vo.setAdv_display("mid");
			vo.setAdv_reg_date(new Timestamp(System.currentTimeMillis()));
			mapper.addAdvertisement(vo);
		}
		
		
	}
	
	public void insertAdv(HttpServletRequest request, HttpSession session) throws Exception {

		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
		Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
		MultipartFile multipartFile = null;
		String originalFileName = null;
		String originalFileExtension = null;
		String storedFileName = null;

		File file = new File(filePath);
		if (file.exists() == false) {
			file.mkdirs();
		}

		while (iterator.hasNext()) {
			multipartFile = multipartHttpServletRequest.getFile(iterator.next());
			if (multipartFile.isEmpty() == false) {
				originalFileName = multipartFile.getOriginalFilename();
				
//				originalFileExtension =originalFileName.substring(originalFileName.lastIndexOf(".")); 
//				storedFileName= UUID.randomUUID().toString().replaceAll("-", "") + originalFileExtension;
//				System.out.println(storedFileName); 
//				file = new File(filePath + storedFileName);
//				multipartFile.transferTo(file);
				

				AdvertisementVO vo = new AdvertisementVO();
				vo.setAdv_name(request.getParameter("adv_name"));
				vo.setAdv_company(session.getAttribute("user").toString());
				vo.setAdv_email(request.getParameter("adv_email"));
				vo.setAdv_content(request.getParameter("adv_content"));
				vo.setAdv_display("mid");
				vo.setAdv_reg_date(new Timestamp(System.currentTimeMillis()));
				vo.setAdv_img("/images/" + multipartFile.getOriginalFilename());

				mapper.addAdvertisement(vo);
			}
		}
	}

}
