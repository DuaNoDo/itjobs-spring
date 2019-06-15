package com.teadone.itjobs.ad;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdvertisementMapper {
	public int insertAdv(AdvertisementVO vo) throws IllegalStateException, IOException;
	public int getAdvCount(AdvertisementVO vo);
	public AdvertisementVO getAdvcont(AdvertisementVO vo);
	public List<AdvertisementVO> getAdvertisement(AdvertisementVO vo);
	public AdvertisementVO readSelectAdvertisement(AdvertisementVO vo);
	public int addAdvertisement(AdvertisementVO vo);
	public AdvertisementVO getAdvCont(AdvertisementVO vo);
	public int advUpdate(AdvertisementVO vo);
	public int advDelete(AdvertisementVO vo);
	public int addMyLikeAdv(AdvertisementVO vo);
	public int delMyLikeAdv(AdvertisementVO vo);
	public List<AdvertisementVO> getMyLikeAdv(AdvertisementVO vo);
	
	
	//searchList
	public ArrayList<AdvertisementVO> getSearchAdv(AdvSearchVO vo);
	public AdvertisementVO getSearchAdvContent(AdvertisementVO vo);
	public List<String> getMyLikeAdvNum(AdvSearchVO svo);
}
