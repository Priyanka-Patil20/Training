package com.vwits.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.vwits.model.Admin;
import com.vwits.model.Exam;
import com.vwits.model.Result;
import com.vwits.model.TestPaper;
import com.vwits.model.User;

@Controller
public class SystemController {
	@Autowired
ApplicationContext context;
//Main Page to Login
@RequestMapping(value = "/login", method = RequestMethod.GET)
public ModelAndView doMainToLogin() {
	ModelAndView model = new ModelAndView();
	model.setViewName("Login.jsp");
	return model;
}
@RequestMapping(value = "/adminlogin", method = RequestMethod.GET)
public ModelAndView doMainToAdminLogin() {
	ModelAndView model = new ModelAndView();
	model.setViewName("AdminLogin.jsp");
	return model;
}
@RequestMapping(value = "/adminlogin", method = RequestMethod.POST)
public ModelAndView doAdminLogin(HttpSession session,@RequestParam("username") String a,@RequestParam("pass") String b) {
	DaoImplementation d1=new DaoImplementation();
	ModelAndView model = new ModelAndView();
	
	List<User> list=d1.getAdminLogin(a, b);
	if(list.size()>0) {
		
			session.setAttribute("CurrentUser", list);
			model.setViewName("AdminMain.jsp");
		
	}
	else
	{
		model.setViewName("AdminLogin.jsp");
		model.addObject("data", "Invalid Credentials!!!!!");
	}

	return model;
}
@RequestMapping(value = "/userlogin", method = RequestMethod.POST)
public ModelAndView doUserLogin(HttpSession session,@RequestParam("userid") String a,@RequestParam("pass") String b) {
	DaoImplementation d1=new DaoImplementation();
	ModelAndView model = new ModelAndView();
	String profile="";
	String status="";
	List<User> list=d1.getLogin(a, b);
	if(list.size()>0) {
	for(User l:list) {
		profile=l.getProfile();
		status=l.getStatus();
	}
	if(profile.equalsIgnoreCase("student") && status.equalsIgnoreCase("active") ) {
		session.setAttribute("CurrentUser", list);
		List<Exam>list1=d1.getAllExam();
		
		model.setViewName("StudExams.jsp");
		model.addObject("data",list1);
	}
	else if(profile.equalsIgnoreCase("faculty") && status.equalsIgnoreCase("active"))
	{
		session.setAttribute("CurrentUser", list);
		model.setViewName("FacultyInfo.jsp");
	}
	
	else {
		model.setViewName("Login.jsp");
		model.addObject("data", "Account Not Activated!!!!!");
	}
	
	}else {
		model.setViewName("Login.jsp");
		model.addObject("data", "Invalid Credentials!!!!!");
	}
	
	
	return model;
}
//Redirecting from Jsp pages
	@RequestMapping(value = "/redirect", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView doMainStudentLogin(String url,HttpSession session) {
		ModelAndView model = new ModelAndView();
		if(url.equalsIgnoreCase("Login.jsp") || url.equalsIgnoreCase("AdminLogin.jsp")) {
			session.invalidate();
			model.setViewName(url);
			model.addObject("data","Sucessful Logout!!");
		}
		else {
			model.setViewName(url);
		}
		System.out.println(url);
		
		return model;
	}

//Controller for User Registration
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView doRegister(@RequestParam("id") String a,@RequestParam("username") String b,@RequestParam("pass") String c,@RequestParam("email") String d,@RequestParam("contact") int e,@RequestParam("profile") String f) {
		ModelAndView model=new ModelAndView();
		User u=context.getBean(User.class);
		DaoImplementation d1=new DaoImplementation();
		u.setUserid(a);
		u.setName(b);
		u.setPassword(c);
		u.setEmail(d);
		u.setContact(e);
		u.setProfile(f);
		u.setStatus("unactive");
		d1.insert(u);
		model.setViewName("Login.jsp");
		model.addObject("data", "Registered Successfully!!!!");
		d1.getAll();
		return model;
	}
	//Controller for Admin Registration
		@RequestMapping(value = "/doadminregistration", method = RequestMethod.POST)
		public ModelAndView doRegisterAdmin(@RequestParam("id") String a,@RequestParam("username") String b,@RequestParam("pass") String c,@RequestParam("email") String d,@RequestParam("contact") int e) {
			ModelAndView model=new ModelAndView();
			Admin a1=context.getBean(Admin.class);
			DaoImplementation d1=new DaoImplementation();
			a1.setAdminid(a);
			a1.setName(b);
			a1.setPassword(c);
			a1.setEmail(d);
			a1.setContact(e);
			
			d1.insertAdmin(a1);
			model.setViewName("AdminLogin.jsp");
			model.addObject("data", "Registered Successfully!!!!");
			d1.getAll();
			return model;
		}
	//to get the current faculty
	@RequestMapping(value = "/getupdateFaculty", method = RequestMethod.GET)
	public ModelAndView doFacultyUpdate(HttpSession session) {
		ModelAndView model=new ModelAndView();
		String name="";
		String email="";
		String pass="";
		int con=0;
		String id="";
		DaoImplementation d1=new DaoImplementation();
		List<User> list= (List<User>) session.getAttribute("CurrentUser");
		
		if(list!=null) {
			for(User f:list) {
				id=f.getUserid();
				name=f.getName();
				email=f.getEmail();
				pass=f.getPassword();
				con=f.getContact();
			}
		}
		System.out.println(id+" "+name+" "+pass+" "+email+" "+con+" ");
		model.setViewName("UpdateFaculty.jsp");
		model.addObject("id", id);
		model.addObject("name", name);
		model.addObject("pass", pass);
		model.addObject("email", email);
		model.addObject("con", con);
		
		
		return model;
	}
	@RequestMapping(value = "/updatefaculty", method = RequestMethod.POST)
	public ModelAndView doFacultyUpdated(HttpSession session,@RequestParam("id") String a,@RequestParam("username") String b,@RequestParam("pass") String c,@RequestParam("email") String d,@RequestParam("contact") int e) {
		ModelAndView model=new ModelAndView();
			User u=context.getBean(User.class);
			DaoImplementation d1=new DaoImplementation();
			List<User> list= (List<User>) session.getAttribute("CurrentUser");
			u.setUserid(a);
			u.setName(b);
			u.setPassword(c);
			u.setEmail(d);
			u.setContact(e);
			d1.update(u);
			model.setViewName("UpdateFaculty.jsp");
			return model;
		}
	//Controller for User Registration by admin
		@RequestMapping(value = "/adminregistration", method = RequestMethod.POST)
		public ModelAndView doRegisterBYyAdmin(@RequestParam("id") String a,@RequestParam("username") String b,@RequestParam("pass") String c,@RequestParam("email") String d,@RequestParam("contact") int e,@RequestParam("profile") String f,@RequestParam("status") String g) {
			ModelAndView model=new ModelAndView();
			User u=context.getBean(User.class);
			DaoImplementation d1=new DaoImplementation();
			u.setUserid(a);
			u.setName(b);
			u.setPassword(c);
			u.setEmail(d);
			u.setContact(e);
			u.setProfile(f);
			u.setStatus(g);
			d1.insert(u);
			model.setViewName("UserRegister.jsp");
			model.addObject("data", "Registered Successfully!!!!");
			d1.getAll();
			return model;
		}
		@RequestMapping(value = "/getDeleteList", method = RequestMethod.GET)
		public ModelAndView doListToDelete() {
			ModelAndView model = new ModelAndView();
			DaoImplementation d1=new DaoImplementation();
			List<User>list=d1.getAll();
					
			model.setViewName("Delete.jsp");
			model.addObject("data",list);
			return model;
		}
		//Deleting the user
		@RequestMapping(value = "/deleteuser", method = RequestMethod.GET)
		public ModelAndView doDelete(String uid) {
			ModelAndView model = new ModelAndView();
			DaoImplementation d1=new DaoImplementation();
			System.out.println(uid);
			List<User> list=d1.getUserofId(uid);
			User u=list.get(0);
			d1.delete(u);
			List<User>list1=d1.getAll();
					
			model.setViewName("Delete.jsp");
			model.addObject("data",list1);
			return model;
		}
		//Get list to Update status
		@RequestMapping(value = "/getUpdateList", method = RequestMethod.GET)
		public ModelAndView doListToUpdate() {
			ModelAndView model = new ModelAndView();
			DaoImplementation d1=new DaoImplementation();
			List<User>list=d1.getAll();
					
			model.setViewName("ActivateUser.jsp");
			model.addObject("data",list);
			return model;
		}
		//Updating the user Status as active
				@RequestMapping(value = "/updateactive", method = RequestMethod.GET)
				public ModelAndView doUpdateActive(String uid) {
					ModelAndView model = new ModelAndView();
					DaoImplementation d1=new DaoImplementation();
					System.out.println(uid);
					List<User> list=d1.getUserofId(uid);
					User u=list.get(0);
					u.setStatus("Active");
					d1.update(u);
					List<User>list1=d1.getAll();
							
					model.setViewName("ActivateUser.jsp");
					model.addObject("data",list1);
					return model;
				}
				
				//Updating the user Status as unactive
				@RequestMapping(value = "/updateunactive", method = RequestMethod.GET)
				public ModelAndView doUpdateUnActive(String uid) {
					ModelAndView model = new ModelAndView();
					DaoImplementation d1=new DaoImplementation();
					System.out.println(uid);
					List<User> list=d1.getUserofId(uid);
					User u=list.get(0);
					u.setStatus("UnActive");
					d1.update(u);
					List<User>list1=d1.getAll();
							
					model.setViewName("ActivateUser.jsp");
					model.addObject("data",list1);
					return model;
				}
				
				//Get list to Test
				/*@RequestMapping(value = "/getListExam", method = RequestMethod.GET)
				public ModelAndView doListTest() {
					ModelAndView model = new ModelAndView();
					DaoImplementation d1=new DaoImplementation();
					List<Exam>list=d1.getAllExam();
							
					model.setViewName("StudExams.jsp");
					model.addObject("data",list);
					return model;
				}*/
				
				@RequestMapping(value = "/startexam", method = RequestMethod.GET)
				public ModelAndView doStartTest(String eid) {
					ModelAndView model = new ModelAndView();
					DaoImplementation d1=new DaoImplementation();
					
							
					model.setViewName("starttest.jsp");
					model.addObject("data",eid);
					return model;
				}
				
				@RequestMapping(value = "/Test", method = RequestMethod.GET)
				public ModelAndView doTest(String eid,HttpSession session) {
					ModelAndView model=new ModelAndView();
					List<TestPaper>test=new ArrayList();
					DaoImplementation d1=new DaoImplementation();
					List<Exam> list=d1.getExamofId(eid);
					//test=d1.getTestofId(eid);
					String name="";
					System.out.println(test);
					for(Exam e:list) {
						System.out.println(e);
						test=e.getTestlist();
						name=e.getExamname();
						}
					session.setAttribute("examname", name);
					session.setAttribute("quesList", test);
					System.out.println("test");
					
					model.setViewName("TestForm.jsp");
					model.addObject("data", test);
					model.addObject("name",name);
					
					return model;
				}
				
				@RequestMapping(value = "/result", method = RequestMethod.GET)
				public ModelAndView doCalculateResult(@RequestParam Map<String,String> answers,HttpSession session) {
					ModelAndView model=new ModelAndView();
					//request.getSession(false);
					DaoImplementation d1=new DaoImplementation();
					System.out.println("Map is"+answers);
					String name="";
					String id="";
					List<User> list= (List<User>) session.getAttribute("CurrentUser");
					List<TestPaper> test=(List<TestPaper>) session.getAttribute("quesList");
					if(list!=null)
					{
						
						
					String[] answer = new String[100];
					int[] tmarks=new int[100];
			        
			       
			        int i = 0;
			        int marks = 0;
			        int total=0;
			        int size = test.size();
			        for(TestPaper q : test)
			               {   
			                     answer[i] = q.getAns();
			                     tmarks[i]=q.getMarks();
			                       i++;
			               }
			        String[] studentAnswer = new String[100];
			        for(int j = 0 ; j < size ; j++)
			               {
			        	String opt=j+"";
			                    studentAnswer[j] = answers.get(opt);
			                     System.out.println(studentAnswer[j]);
			               }
			        
			        int correctanswer=0;
			        int unattempted = 0;
			        int wronganswer=0;
			        for(int k = 0 ; k< size;k++)
			        {
			               if(studentAnswer[k].equalsIgnoreCase(answer[k]))
			               {
			                     correctanswer++;
			                     marks=marks+tmarks[k];
			               }
			               else if(studentAnswer[k].equals("e"))
			               {
			                     unattempted++;
			               }
			               else
			               {
			                     wronganswer++;
			               }
			               total=total+tmarks[k];
			        }
			        int attemped = size - unattempted;

						System.out.println(marks+"/"+total);
					
					model.setViewName("score.jsp");
					model.addObject("marks", marks);
					model.addObject("Total",total);
					model.addObject("attempted",attemped);
					
					for(User l:list)
					{
						
						name=l.getName();
						id=l.getUserid();
						
					}
					String examname="";
					examname=(String) session.getAttribute("examname");
					Result r=new Result(id,name,examname,marks,total);
					d1.insertResult(r);
					d1.getAllResult();
					}
					return model;
					}
				
				@RequestMapping(value = "/viewresult", method = RequestMethod.GET)
				public ModelAndView doDisplayResult() {
					ModelAndView model=new ModelAndView();
					
					DaoImplementation d1=new DaoImplementation();
					
					
					List<Result> list=d1.getAllResult();
					model.setViewName("ViewResult.jsp");
					model.addObject("data", list);
					
					
					return model;
				}
				
				//Get Exams
				@RequestMapping(value = "/displayexam", method = RequestMethod.GET)
				public ModelAndView doDisplayExam() {
					ModelAndView model=new ModelAndView();
					
					DaoImplementation d1=new DaoImplementation();
					
					
					List<Exam> list=d1.getAllExam();
					model.setViewName("ExamAddDisplay.jsp");
					model.addObject("data", list);
					
					
					return model;
				}
				//Get examcode to add
				@RequestMapping(value = "/getexamcode", method = RequestMethod.GET)
				public ModelAndView doGetExamid(String eid,HttpSession session) {
					ModelAndView model=new ModelAndView();
					session.setAttribute("examcode", eid);
					model.setViewName("AddQuestion.jsp");
					
					model.addObject("data", eid);
					return model;
				}
				//Insert Question
				@RequestMapping(value = "/insertquestion", method = RequestMethod.POST)
				public ModelAndView doInsertQue(HttpSession session,@RequestParam("txtid") int a,@RequestParam("txtque") String b,@RequestParam("txtopt1") String c,@RequestParam("txtopt2") String d,@RequestParam("txtopt3") String e,@RequestParam("txtopt4") String f,@RequestParam("txtcorrect") String g,@RequestParam("txtmarks") int h) {
					ModelAndView model=new ModelAndView();
					DaoImplementation d1=new DaoImplementation();
					String code=(String) session.getAttribute("examcode");
					List<Exam> list=d1.getExamofId(code);
					
					Exam e1=list.get(0);
					List<TestPaper>test=e1.getTestlist();
					TestPaper t=new TestPaper(a,b,c,d,e,f,g,h);
					test.add(t);
					e1.setTestlist(test);
					d1.updateExam(e1);
					List<Exam> exam=d1.getAllExam();
					model.setViewName("ExamAddDisplay.jsp");
					model.addObject("data", exam);
					return model;
				}
				
				//Display Question
				@RequestMapping(value = "/displayquestion", method = RequestMethod.GET)
				public ModelAndView doDisplayQuestion(String eid) {
					ModelAndView model=new ModelAndView();
					
					DaoImplementation d1=new DaoImplementation();
					
					
					List<Exam> list=d1.getExamofId(eid);
					
					Exam e1=list.get(0);
					List<TestPaper>test=e1.getTestlist();
					model.setViewName("DisplayQuestion.jsp");
					model.addObject("data", test);
					
					
					return model;
				}

}
