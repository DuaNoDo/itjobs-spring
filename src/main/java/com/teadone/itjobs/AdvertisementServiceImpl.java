package com.teadone.itjobs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.teadone.itjobs.ad.AdvertisementMapper;
import com.teadone.itjobs.ad.AdvertisementVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AdvertisementServiceImpl implements AdvertisementService{
	@Autowired
	private AdvertisementMapper mapper;
	
	@Override
	@Cacheable("#vo.adv_display")
	public List<AdvertisementVO> getAdvertisement(AdvertisementVO vo) {
		log.info("call to !!");
		return mapper.getAdvertisement(vo);
	}

}
