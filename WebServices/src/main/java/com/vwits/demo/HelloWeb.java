package com.vwits.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HelloWeb {
	/*@RequestMapping(value="/", method=RequestMethod.GET)
	public String helloWorld() {
		return "Hello World";
		
	}
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String newWorld() {
		return "Hello to new World";
	}
	@RequestMapping(value="/emp", method=RequestMethod.GET)
	public Employee getemp() {
		Employee e=new Employee(1,"priya",50000);
		return e;
	}
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public Employee insertEmployee(@RequestBody Employee e) {
		System.out.println(e);
		return e;
	}
	
	@RequestMapping(value="/empall", method=RequestMethod.GET)
	public List<Employee> getAll() {
		List<Employee> list= new ArrayList<>();
		Employee e=new Employee(1,"priya",50000);
		Employee e1=new Employee(2,"priti",70000);
		Employee e2=new Employee(3,"riya",80000);
		list.add(e);
		list.add(e1);
		list.add(e2);
		return list;
	}*/
	@Autowired
EmloyeeDao data;
	
	@GetMapping(value="/all")
	public List<Employee> getAll(){
		return data.getAll();
		
	}
	
	@PostMapping(value="/save")
	public Employee insert(@RequestBody Employee e)
	{
		data.saveEmployee(e);
		return e;
	}
	
}
