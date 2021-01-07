package com.vwits.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vwits.model.User;

@RestController
public class SystemController {
	DaoImplementation d=new DaoImplementation();
	@GetMapping(value="/getAll")
 public List<User> getUser(){
	 List<User> l=new ArrayList<>();
	 l=d.getAll();
	 return l;
 }
	@PostMapping(value = "/save")
	public User insert(@RequestBody User e) {
		d.insert(e);
		return e;
	}
	
	@PutMapping(value="/update")
	public User update(@RequestBody User e) {
		
		d.update(e);
		return e;
	}
	
	@DeleteMapping(value = "/delete")
	public User delete(@RequestBody User e) {
		d.delete(e);
		return e;
	}
}
