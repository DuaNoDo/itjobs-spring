package com.teadone.itjobs.ad;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AdvertisementService implements AdvertisementMapper{
	
	@Autowired
	Environment env;

	@Autowired
	private AdvertisementMapper mapper;
	
	private static final String filePath = "\\images\\";
	@Override
	public int insertAdv(AdvertisementVO vo) throws IllegalStateException, IOException{
		if(vo.getFile() != null) {
			MultipartFile f = vo.getFile(); 
			f.transferTo(
					Paths.get(env.getProperty("itjobs.upload.path"), f.getOriginalFilename()));
			vo.setAdv_img(env.getProperty("itjobs.upload.path")+f.getOriginalFilename());
			vo.setAdv_reg_date(new Timestamp(System.currentTimeMillis()));
			return mapper.addAdvertisement(vo);
		}
		return 0;
	}
	@Override
	public AdvertisementVO getAdvcont(AdvertisementVO vo) {
		return mapper.getAdvCont(vo);
	}
	@Override
	public int advUpdate(AdvertisementVO vo) {
		return mapper.advUpdate(vo);
	}
	@Override
	public int advDelete(AdvertisementVO vo) {
		return mapper.advDelete(vo);
		
	}
	@Override
	public int getAdvCount(AdvertisementVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public AdvertisementVO readSelectAdvertisement(AdvertisementVO vo) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int addAdvertisement(AdvertisementVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public AdvertisementVO getAdvCont(AdvertisementVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addMyLikeAdv(AdvertisementVO vo) {
		return mapper.addMyLikeAdv(vo);
	}
	@Override
	public int delMyLikeAdv(AdvertisementVO vo) {
		return mapper.delMyLikeAdv(vo);
	}
	@Override
	@Cacheable("#vo.adv_display")
	public List<AdvertisementVO> getAdvertisement(AdvertisementVO vo) {
		log.info("call to !!");
		return mapper.getAdvertisement(vo);
	}
	@Override
	public AdvertisementVO getSearchAdvContent(AdvertisementVO vo) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<AdvertisementVO> getSearchAdv(AdvSearchVO vo) {
		return mapper.getSearchAdv(vo);
	}
	@Override
	public List<AdvertisementVO> getMyLikeAdv(AdvertisementVO vo){
		return mapper.getMyLikeAdv(vo);
	}
	@Override
	public List<String> getMyLikeAdvNum(AdvSearchVO svo) {
		return mapper.getMyLikeAdvNum(svo);
	}


}
