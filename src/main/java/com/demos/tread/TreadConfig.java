package com.demos.tread;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class TreadConfig {
 
	@Bean(name="migDelvyExcute") 
	public Executor migDelvyExcute(){
	ThreadPoolTaskExecutor taskEx = new ThreadPoolTaskExecutor();
	  taskEx.setCorePoolSize(0);
	  taskEx.setMaxPoolSize(20);
	  taskEx.setQueueCapacity(10000);
	  taskEx.initialize();
	  return taskEx;
	}
	
	
	@Bean(name="migPurMtExcute") 
	public Executor migPurMtExcute(){
	ThreadPoolTaskExecutor taskEx = new ThreadPoolTaskExecutor();
	  taskEx.setCorePoolSize(0);
	  taskEx.setMaxPoolSize(10);
	  taskEx.setQueueCapacity(500);
	  taskEx.initialize();
	  return taskEx;		
	}
	
	@Bean(name="migPurDtExcute") 
	public Executor migPurDtExcute(){
	ThreadPoolTaskExecutor taskEx = new ThreadPoolTaskExecutor();
	  taskEx.setCorePoolSize(0);
	  taskEx.setMaxPoolSize(10);
	  taskEx.setQueueCapacity(1000);
	  taskEx.initialize();
	  return taskEx;
		
	}
	
	@Bean(name="migGrExcute") 
	public Executor migGrExcute(){
	ThreadPoolTaskExecutor taskEx = new ThreadPoolTaskExecutor();
	  taskEx.setCorePoolSize(0);
	  taskEx.setMaxPoolSize(10);
	  taskEx.setQueueCapacity(1000);
	  taskEx.initialize();
	  return taskEx;
		
	}
	
	
	
}
