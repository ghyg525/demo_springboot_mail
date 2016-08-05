package service;

import org.junit.Test;

import util.SpringUtil;

public class MailSeanderServiceTest {

	
	private MailSeanderService mailSeanderService = SpringUtil.getBean("mailSeanderService", MailSeanderService.class);
	
	@Test
	public void testSendMail() throws InterruptedException {
		mailSeanderService.sendMail("标题"+System.currentTimeMillis(), "内容"+System.currentTimeMillis());
		System.out.println("主线程结束...");
		Thread.sleep(2000);
	}

	
}
