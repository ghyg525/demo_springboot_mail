package org.yangjie.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * 邮件发送服务
 * @author YangJie [2016年2月26日 上午11:52:56]
 */
@Service
public class MailSeanderService {
	
	private Logger logger = LoggerFactory.getLogger(MailSeanderService.class);
	
	
	@Value("${mail.to}")
	private String[] tos;
	
	@Autowired
	private JavaMailSenderImpl javaMailSender;
	
	
	/**
	 * 发送邮件
	 * @author YangJie [2016年8月5日 下午3:52:34]
	 * @param subject 主题 
	 * @param text 邮件内容
	 * [注意主线程结束后线程池中任务不会继续执行]
	 * @Async // 此注解异步执行, 在本类中调用异步无效, 
	 * 因为spring会生成动态代理类完成异步调用, 实际执行逻辑已经不在本方法
	 */
	@Async // 异步执行
	public void sendMail(String subject, String text){
		SimpleMailMessage mailMessage = new SimpleMailMessage(); 
		mailMessage.setFrom(javaMailSender.getUsername());
		mailMessage.setTo(tos);
		mailMessage.setSubject(subject);
		mailMessage.setText(text);
		javaMailSender.send(mailMessage);
		logger.info("发送了邮件: {}", subject);
	}
	
	
	/**
	 * 定时执行任务
	 * @author YangJie [2016年10月11日 下午3:18:17]
	 */
	@Scheduled(cron="0 * * * * ?") // 每分
	public void taskPerHour(){
		logger.info("开始执行每分钟任务...");
		this.sendMail("test", "11234");
		logger.info("每分钟任务执行结束!");
	}
	
}
