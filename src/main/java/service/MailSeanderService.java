package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 邮件发送服务
 * @author YangJie [2016年2月26日 上午11:52:56]
 */
@Service
public class MailSeanderService {
	
	@Autowired
	private JavaMailSenderImpl javaMailSender;
	
	
	// 测试目标地址, 可从数据库等获取
	String[] tos = {"ghyg525@qq.com", "ghyg527@qq.com"};
	
	
	/**
	 * 发送邮件
	 * @author YangJie [2016年8月5日 下午3:52:34]
	 * @param subject 主题 
	 * @param text 邮件内容
	 * 注意主线程结束后线程池中任务不会继续执行
	 */
	@Async // 此注解异步执行在本方法中调用无效, spring会生成动态代理类完成异步调用
	public void sendMail(String subject, String text){
		SimpleMailMessage mailMessage = new SimpleMailMessage(); 
		mailMessage.setFrom(javaMailSender.getUsername());
		mailMessage.setTo(tos);
		mailMessage.setSubject(subject);
		mailMessage.setText(text);
		javaMailSender.send(mailMessage);
		System.out.println("发送了邮件: "+ subject);
	}
	
}
