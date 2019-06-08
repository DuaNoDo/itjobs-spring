package com.teadone.itjobs.mem;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
	public String checkPMem(PMemVO vo);
	public int checkPMemDup(PMemVO vo);
	public int pJoin(PMemVO vo);
	public int upPMem(PMemVO vo);
	
	public String checkCMem(CMemVO vo);
	public int checkCMemDup(CMemVO vo);
	public int cJoin(CMemVO vo);
	public int upCMem(CMemVO vo);
}
