package com.my.app.main.batch;

import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) throws Exception {
		GenericXmlApplicationContext applicationContext = new GenericXmlApplicationContext("classpath:launch-context.xml");
		applicationContext.registerShutdownHook();
		JobLauncher jobLauncher = applicationContext.getBean(JobLauncher.class);
		
		JobParametersBuilder builder = new JobParametersBuilder();
//		builder.addString("string", "문자열");
		builder.addDate("date", new Date());
//		builder.addLong("time", System.currentTimeMillis());
		jobLauncher.run(applicationContext.getBean(Job.class), builder.toJobParameters());
		
		applicationContext.close();
	}
	
}
