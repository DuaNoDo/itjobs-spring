package com.teadone.itjobs.ad;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Timestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
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
			vo.setAdv_img(env.getProperty("itjobs.upload.path")+f.getOriginalFilename());
			vo.setAdv_reg_date(new Timestamp(System.currentTimeMillis()));
			mapper.addAdvertisement(vo);
		}
	}
	public AdvertisementVO getAdvcont(AdvertisementVO vo) {
		return mapper.getAdvCont(vo);
	}
	public void advUpdate(AdvertisementVO vo) {
		mapper.advUpdate(vo);
	}


}
