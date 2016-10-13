package org.yangjie.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * 邮件发送配置
 */
@Configuration
public class MailSenderConfig {

	@Bean // 初始化邮件发送器
	@ConfigurationProperties(prefix="mail.from")
	public JavaMailSenderImpl javaMailSender() {
		return new JavaMailSenderImpl();
	}
	
}
