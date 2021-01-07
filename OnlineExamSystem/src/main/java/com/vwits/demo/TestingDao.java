package com.vwits.demo;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.vwits.model.Exam;
import com.vwits.model.TestPaper;

public class TestingDao {
	Configuration cfg;
	SessionFactory sessionFactory;
	Session session;
	Transaction t;
	public List getTestsrno(String s) {
		cfg=new Configuration();
		sessionFactory= cfg.configure().buildSessionFactory();
		session= sessionFactory.openSession();
		t=session.beginTransaction();
		Criteria c=session.createCriteria(Exam.class);
		c.add(Restrictions.eq("examcode", s));
		List<Exam> list=c.list();
		t.commit();
		session.close();
		sessionFactory.close();
		return list;
		}
	
	public List getExamofId(String id) {
		cfg=new Configuration();
		sessionFactory= cfg.configure().buildSessionFactory();
		session= sessionFactory.openSession();
		t=session.beginTransaction();
		List<Exam> list;
		String hql = "FROM Exam E WHERE E.examcode = '"+id+"'"; 
		list=(List<Exam>) session.createQuery(hql).list();
		t.commit();
		session.close();
		sessionFactory.close();
		System.out.println(list);
		return list;
		}
}
