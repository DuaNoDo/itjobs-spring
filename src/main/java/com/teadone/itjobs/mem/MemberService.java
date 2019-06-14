package com.teadone.itjobs.mem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService implements MemberMapper {

	@Autowired
	MemberMapper mapper;
	@Override
	public String checkPMem(PMemVO vo) {
		
		return mapper.checkPMem(vo);
	}

	@Override
	public int checkPMemDup(PMemVO vo) {

		return mapper.checkPMemDup(vo);
	}

	@Override
	public int pJoin(PMemVO vo) {

		return mapper.pJoin(vo);
	}

	@Override
	public int upPMem(PMemVO vo) {

		return mapper.upPMem(vo);
	}

	@Override
	public String pFindId(PMemVO vo) {

		return mapper.pFindId(vo);
	}

	@Override
	public String pFindPw(PMemVO vo) {

		return mapper.pFindPw(vo);
	}

	@Override
	public String checkCMem(CMemVO vo) {

		return mapper.checkCMem(vo);
	}

	@Override
	public int checkCMemDup(CMemVO vo) {

		return mapper.checkCMemDup(vo);
	}

	@Override
	public int cJoin(CMemVO vo) {

		return mapper.cJoin(vo);
	}

	@Override
	public int upCMem(CMemVO vo) {

		return mapper.upCMem(vo);
	}

	@Override
	public String cFindId(CMemVO vo) {

		return mapper.cFindId(vo);
	}

	@Override
	public String cFindPw(CMemVO vo) {

		return mapper.cFindPw(vo);
	}

}
