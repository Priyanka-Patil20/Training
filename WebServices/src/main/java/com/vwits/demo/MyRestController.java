package com.vwits.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {
	
	@GetMapping("/emp")
	public List<Employee> helloEmp(){
		List<Employee>l=new ArrayList<>();
		l.add(new Employee(1,"ABC",99000));
		l.add(new Employee(2,"pqr",99000));
		return l;
	}
	@GetMapping("/getemp/{id}")
	public Employee singleEmp(@PathVariable("id") int id) {
		return new Employee(id,null,0);
	}
}
