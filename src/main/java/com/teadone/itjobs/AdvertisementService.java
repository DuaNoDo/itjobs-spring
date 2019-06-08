package com.teadone.itjobs;

import java.util.List;

import com.teadone.itjobs.ad.AdvertisementVO;

public interface AdvertisementService {
	List<AdvertisementVO> getAdvertisement(AdvertisementVO vo);
}
