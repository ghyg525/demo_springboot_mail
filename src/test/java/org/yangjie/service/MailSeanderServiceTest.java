package org.yangjie.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.yangjie.mail.util.MailUtil;

@RunWith(SpringRunner.class)
@SpringBootTest // 默认webEnvironment为mock
public class MailSeanderServiceTest {
	
	@Autowired
	private MailUtil mailSeanderService;
	
	@Test
	public void testSendMail() throws InterruptedException {
		mailSeanderService.sendMail("标题"+System.currentTimeMillis(), "内容"+System.currentTimeMillis());
		System.out.println("等待spring 异步执行...");
		Thread.sleep(5*1000);
	}
	
}
