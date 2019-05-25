package com.teadone.itjobs.ad;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdvertisementMapper {
	public int getAdvCount(AdvertisementVO vo);
}
