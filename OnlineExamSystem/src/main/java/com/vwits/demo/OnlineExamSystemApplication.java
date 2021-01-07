package com.vwits.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.vwits.model.Exam;
import com.vwits.model.TestPaper;
import com.vwits.model.User;

@SpringBootApplication
public class OnlineExamSystemApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(OnlineExamSystemApplication.class, args);
		/*DaoImplementation d1=new DaoImplementation();
		List<TestPaper>test1=new ArrayList();
		TestPaper t=new TestPaper(3,"java is?","Programming Lang","English Lang","German Lang","Hindi Lang","a",10);
		TestPaper t1=new TestPaper(5,"Which is not Keyword of Java?","This","Super","final","is","d",10);
		TestPaper t2=new TestPaper(6,"Fullform of JVM?","Java Virtual Machine","Java Visual Machine","JRE Virtual Machine","JRE Visual Machine","a",10);
		test1.add(t);
		test1.add(t1);
		test1.add(t2);
		Exam e=new Exam("Java","Java",60,test1);
		d1.insertExam(e);*/
	}

}
