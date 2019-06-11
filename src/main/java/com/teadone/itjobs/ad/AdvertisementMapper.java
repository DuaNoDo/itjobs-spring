package com.teadone.itjobs.ad;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdvertisementMapper {
	public int getAdvCount(AdvertisementVO vo);
	public ArrayList<AdvertisementVO> getAdvertisement(AdvertisementVO vo);
	public AdvertisementVO readSelectAdvertisement(AdvertisementVO vo);
	public int addAdvertisement(AdvertisementVO vo);
	public AdvertisementVO getAdvCont(AdvertisementVO vo);
	public int advUpdate(AdvertisementVO vo);

	
	//searchList
	public ArrayList<AdvertisementVO> getSearchAdv(AdvSearchVO vo);
	public AdvertisementVO getSearchAdvContent(AdvertisementVO vo);
}
