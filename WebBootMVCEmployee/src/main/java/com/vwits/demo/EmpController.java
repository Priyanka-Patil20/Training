package com.vwits.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class EmpController {
	ApplicationContext context;
	Employee e=context.getBean(Employee.class);
	@RequestMapping(value = "/emp", method = RequestMethod.GET)
	public ModelAndView getEmployee(@RequestParam("id") int a,@RequestParam("username") String b,@RequestParam("sal") int c) {
		ModelAndView model=new ModelAndView();
		model.setViewName("welcome.jsp");
		e.getName();
		model.addObject("id",a);
		model.addObject("name",b);
		model.addObject("sal",c);
		
		return model;
	}
}
