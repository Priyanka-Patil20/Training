package com.vwits.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.vwits.model.Admin;
import com.vwits.model.Exam;
import com.vwits.model.TestPaper;
import com.vwits.model.User;

@Configuration
public class AppConfig {
	@Bean
public User getUser() {
	return new User();
}
	@Bean
	public TestPaper getTestPaper() {
		return new TestPaper();
	}
	
	@Bean
	public Exam getExam() {
		return new Exam();
	}
	@Bean
	public Admin getAdmin() {
		return new Admin();
	}
	
	
}
