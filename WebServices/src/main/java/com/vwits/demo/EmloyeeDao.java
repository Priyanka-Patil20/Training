package com.vwits.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class EmloyeeDao {
	List<Employee> list=new ArrayList<>();
	public List<Employee> getAll(){
		return list;
	}
public void saveEmployee(Employee e) {
	list.add(e);
}
public void updateEmployee(Employee e) {
	list.set(list.indexOf(e), e);
}
public void removeEmployee(Employee e)
{
	list.remove(e);
}
public Employee getEmployee(Integer id) {
	Employee e= new Employee();
	for(Employee x: list) {
		if(x.getId()==id) {
			e=x;
		}
		
	}
	return e;
}

}
