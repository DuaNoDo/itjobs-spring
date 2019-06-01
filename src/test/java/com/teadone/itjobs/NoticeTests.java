package com.teadone.itjobs;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.teadone.itjobs.mem.PMemVO;
import com.teadone.itjobs.notice.NoticeMapper;



@RunWith(SpringRunner.class)
@SpringBootTest

public class NoticeTests {
		@Autowired
		private NoticeMapper mapper;
		
		@Test
		public void getNoticeC() {
			System.out.println(mapper.getNoticeC());
		}
}

