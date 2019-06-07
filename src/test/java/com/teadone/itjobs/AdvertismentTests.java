package com.teadone.itjobs;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.teadone.itjobs.ad.AdvertisementMapper;
import com.teadone.itjobs.ad.AdvertisementVO;

import static org.mockito.Mockito.clearInvocations;

import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdvertismentTests {

	@Autowired
	private AdvertisementMapper mapper;
	
	@Test
	public void contextLoads() {
		AdvertisementVO param = new AdvertisementVO();
		param.setTable("advertisement");
		param.setAdv_display("top");
		//System.out.println(mapper.getAdvCount(param));
		
		//assertEquals(0,);
		
	}
	@Test
	public void getAdv() {
		AdvertisementVO param = new AdvertisementVO();
		param.setTable("advertisement");
		param.setAdv_display("mid");
		System.out.println(mapper.getAdvertisement(param));
		
	}
	@Test
	public void imgTest() {
		
	}
	
	
	

}
