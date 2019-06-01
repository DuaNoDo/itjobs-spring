package com.teadone.itjobs;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.teadone.itjobs.mem.MemberMapper;
import com.teadone.itjobs.mem.PMemVO;

@RunWith(SpringRunner.class)
@SpringBootTest

public class MemberTests {
	@Autowired
	private MemberMapper mapper;
	
	@Test
	public void checkMem() {
		PMemVO vo=new PMemVO();
		vo.setIT_id("admin");
		assertEquals("admin",mapper.checkPMem(vo));
	}

}
