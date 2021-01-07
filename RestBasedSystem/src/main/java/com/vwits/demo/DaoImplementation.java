package com.vwits.demo;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.vwits.model.Admin;
import com.vwits.model.Exam;
import com.vwits.model.Result;
import com.vwits.model.TestPaper;
import com.vwits.model.User;

public class DaoImplementation{
	
	Configuration cfg;
	SessionFactory sessionFactory;
	Session session;
	Transaction t;
	
	public void insertAdmin(Admin e) {
		cfg=new Configuration();
		sessionFactory= cfg.configure().buildSessionFactory();
		session= sessionFactory.openSession();
		t=session.beginTransaction();
		session.save(e);
		t.commit();
		session.close();
		sessionFactory.close();
		}
	public void deleteAdmin(Admin e) {
		cfg=new Configuration();
		sessionFactory= cfg.configure().buildSessionFactory();
		session= sessionFactory.openSession();
		t=session.beginTransaction();
		session.delete(e);
		t.commit();
		session.close();
		sessionFactory.close();
		}
	public void updateAdmin(Admin e) {
		cfg=new Configuration();
		sessionFactory= cfg.configure().buildSessionFactory();
		session= sessionFactory.openSession();
		t=session.beginTransaction();
		session.update(e);
		t.commit();
		session.close();
		sessionFactory.close();
		}
	public List getAllAdmin() {
		cfg=new Configuration();
		sessionFactory= cfg.configure().buildSessionFactory();
		session= sessionFactory.openSession();
		t=session.beginTransaction();
		List l=session.createQuery("FROM Admin").list();
	    System.out.println(l);
		t.commit();
		session.close();
		sessionFactory.close();
		return l;
		}

	public List getAdminofId(String id) {
		cfg=new Configuration();
		sessionFactory= cfg.configure().buildSessionFactory();
		session= sessionFactory.openSession();
		t=session.beginTransaction();
		List<Admin> list;
		String hql = "FROM Admin E WHERE E.adminid = '"+id+"'"; 
		list=(List<Admin>) session.createQuery(hql).list();
		t.commit();
		session.close();
		sessionFactory.close();
		return list;
		}

	public List getAdminLogin(String name,String pass) {
		List<Admin>list;
		cfg=new Configuration();
		sessionFactory= cfg.configure().buildSessionFactory();
		session= sessionFactory.openSession();
		t=session.beginTransaction();
		String hql = "FROM Admin E WHERE E.adminid = '"+name+"' and E.password = '"+pass+"'"; 
		list=(List<Admin>)session.createQuery(hql).list();
		
		t.commit();
		session.close();
		sessionFactory.close();
		return list;
		}
	//User
	public void insert(User e) {
		cfg=new Configuration();
		sessionFactory= cfg.configure().buildSessionFactory();
		session= sessionFactory.openSession();
		t=session.beginTransaction();
		session.save(e);
		t.commit();
		session.close();
		sessionFactory.close();
		}
	public void delete(User e) {
		cfg=new Configuration();
		sessionFactory= cfg.configure().buildSessionFactory();
		session= sessionFactory.openSession();
		t=session.beginTransaction();
		session.delete(e);
		t.commit();
		session.close();
		sessionFactory.close();
		}
	public void update(User e) {
		cfg=new Configuration();
		sessionFactory= cfg.configure().buildSessionFactory();
		session= sessionFactory.openSession();
		t=session.beginTransaction();
		session.update(e);
		t.commit();
		session.close();
		sessionFactory.close();
		}
	public List getAll() {
		cfg=new Configuration();
		sessionFactory= cfg.configure().buildSessionFactory();
		session= sessionFactory.openSession();
		t=session.beginTransaction();
		List l=session.createQuery("FROM User").list();
	    System.out.println(l);
		t.commit();
		session.close();
		sessionFactory.close();
		return l;
		}

	public List getUserofId(String id) {
		cfg=new Configuration();
		sessionFactory= cfg.configure().buildSessionFactory();
		session= sessionFactory.openSession();
		t=session.beginTransaction();
		List<User> list;
		String hql = "FROM User E WHERE E.userid = '"+id+"'"; 
		list=(List<User>) session.createQuery(hql).list();
		t.commit();
		session.close();
		sessionFactory.close();
		return list;
		}

	public List getLogin(String name,String pass) {
		List<User>list;
		cfg=new Configuration();
		sessionFactory= cfg.configure().buildSessionFactory();
		session= sessionFactory.openSession();
		t=session.beginTransaction();
		String hql = "FROM User E WHERE E.userid = '"+name+"' and E.password = '"+pass+"'"; 
		list=(List<User>)session.createQuery(hql).list();
		
		t.commit();
		session.close();
		sessionFactory.close();
		return list;
		}
	//Question Dao
	public void insertTest(TestPaper e) {
		cfg=new Configuration();
		sessionFactory= cfg.configure().buildSessionFactory();
		session= sessionFactory.openSession();
		t=session.beginTransaction();
		session.save(e);
		t.commit();
		session.close();
		sessionFactory.close();
		}
	public void deleteTest(TestPaper e) {
		cfg=new Configuration();
		sessionFactory= cfg.configure().buildSessionFactory();
		session= sessionFactory.openSession();
		t=session.beginTransaction();
		session.delete(e);
		t.commit();
		session.close();
		sessionFactory.close();
		}
	public void updateTest(TestPaper e) {
		cfg=new Configuration();
		sessionFactory= cfg.configure().buildSessionFactory();
		session= sessionFactory.openSession();
		t=session.beginTransaction();
		session.update(e);
		t.commit();
		session.close();
		sessionFactory.close();
		}
	public List getAllTest() {
		cfg=new Configuration();
		sessionFactory= cfg.configure().buildSessionFactory();
		session= sessionFactory.openSession();
		t=session.beginTransaction();
		List l=session.createQuery("FROM TestPaper").list();
	    System.out.println(l);
		t.commit();
		session.close();
		sessionFactory.close();
		return l;
		}
	
	public List getTestofId(String id) {
		cfg=new Configuration();
		sessionFactory= cfg.configure().buildSessionFactory();
		session= sessionFactory.openSession();
		t=session.beginTransaction();
		Criteria c =session.createCriteria(TestPaper.class) ;
		List<TestPaper> list;
		//String hql = "FROM TestPaper E WHERE E.examcode = '"+id+"'"; 
		//SQLQuery query = session.createSQLQuery("select * from TestPaper where examcode='"+id+"'");
		//List<Object[]> rows = query.list(); 
		//list=(List<TestPaper>) session.createQuery(hql).list();
		c.add(Restrictions.eq("examcode", id));
		list=c.list();
		t.commit();
		session.close();
		sessionFactory.close();
		System.out.println();
		return list;
		}
	
	public List getTestsrno(String id) {
		cfg=new Configuration();
		sessionFactory= cfg.configure().buildSessionFactory();
		session= sessionFactory.openSession();
		t=session.beginTransaction();
		List<TestPaper> list;
		String hql = "FROM TestPaper E WHERE E.srno = '"+id+"'"; 
		list=(List<TestPaper>) session.createQuery(hql).list();
		t.commit();
		session.close();
		sessionFactory.close();
		return list;
		}
	//Exam
	
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
	
	
	public void insertExam(Exam e) {
		cfg=new Configuration();
		sessionFactory= cfg.configure().buildSessionFactory();
		session= sessionFactory.openSession();
		t=session.beginTransaction();
		session.save(e);
		t.commit();
		session.close();
		sessionFactory.close();
		}
	public void deleteExam(Exam e) {
		cfg=new Configuration();
		sessionFactory= cfg.configure().buildSessionFactory();
		session= sessionFactory.openSession();
		t=session.beginTransaction();
		session.delete(e);
		t.commit();
		session.close();
		sessionFactory.close();
		}
	public void updateExam(Exam e) {
		cfg=new Configuration();
		sessionFactory= cfg.configure().buildSessionFactory();
		session= sessionFactory.openSession();
		t=session.beginTransaction();
		session.update(e);
		t.commit();
		session.close();
		sessionFactory.close();
		}
	public List getAllExam() {
		cfg=new Configuration();
		sessionFactory= cfg.configure().buildSessionFactory();
		session= sessionFactory.openSession();
		t=session.beginTransaction();
		List l=session.createQuery("FROM Exam").list();
	    System.out.println(l);
		t.commit();
		session.close();
		sessionFactory.close();
		return l;
		}
//Result
	public void insertResult(Result e) {
		cfg=new Configuration();
		sessionFactory= cfg.configure().buildSessionFactory();
		session= sessionFactory.openSession();
		t=session.beginTransaction();
		session.save(e);
		t.commit();
		session.close();
		sessionFactory.close();
		}
	public void deleteResult(Result e) {
		cfg=new Configuration();
		sessionFactory= cfg.configure().buildSessionFactory();
		session= sessionFactory.openSession();
		t=session.beginTransaction();
		session.delete(e);
		t.commit();
		session.close();
		sessionFactory.close();
		}
	public void updateResult(Result e) {
		cfg=new Configuration();
		sessionFactory= cfg.configure().buildSessionFactory();
		session= sessionFactory.openSession();
		t=session.beginTransaction();
		session.update(e);
		t.commit();
		session.close();
		sessionFactory.close();
		}
	public List getAllResult() {
		cfg=new Configuration();
		sessionFactory= cfg.configure().buildSessionFactory();
		session= sessionFactory.openSession();
		t=session.beginTransaction();
		List l=session.createQuery("FROM Result").list();
	    System.out.println(l);
		t.commit();
		session.close();
		sessionFactory.close();
		return l;
		}



}
