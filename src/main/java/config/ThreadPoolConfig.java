package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * 线程池配置
 */
@Configuration	// 注解为spring配置java类
@EnableAsync  // 启用异步任务执行
public class ThreadPoolConfig {
	
	@Bean // 初始化线程池
	public ThreadPoolTaskExecutor initThreadPoolTaskExecutor(){
		ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
		threadPoolTaskExecutor.setQueueCapacity(200); 			// 队列容量
		threadPoolTaskExecutor.setCorePoolSize(5);					// 核心线程数量
		threadPoolTaskExecutor.setMaxPoolSize(100);				// 最大线程数量
		threadPoolTaskExecutor.setKeepAliveSeconds(300);		// 允许线程空闲时间  
		threadPoolTaskExecutor.initialize();		// 重新初始化
		return threadPoolTaskExecutor;  
	}

}
