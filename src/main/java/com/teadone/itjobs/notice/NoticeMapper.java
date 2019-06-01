package com.teadone.itjobs.notice;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NoticeMapper {
	
	public int insertNotice(NoticeVO vo);
	public int getNoticeC();
	public ArrayList<NoticeVO> getNotice();
	public NoticeVO readNotice(NoticeVO vo);
	
	
}
