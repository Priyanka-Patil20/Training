package com.vwits.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class Exam {
	String examcode;
	String examname;
	int time;            //in minutes
	
	List<TestPaper> testlist;
public Exam() {
	// TODO Auto-generated constructor stub
}
public Exam(String examcode, String examname, int time, List<TestPaper> testlist) {
	super();
	this.examcode = examcode;
	this.examname = examname;
	this.time = time;
	this.testlist = testlist;
}
public String getExamcode() {
	return examcode;
}
public void setExamcode(String examcode) {
	this.examcode = examcode;
}
public String getExamname() {
	return examname;
}
public void setExamname(String examname) {
	this.examname = examname;
}
public int getTime() {
	return time;
}
public void setTime(int time) {
	this.time = time;
}
public List<TestPaper> getTestlist() {
	return testlist;
}
public void setTestlist(List<TestPaper> testlist) {
	this.testlist = testlist;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((examcode == null) ? 0 : examcode.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Exam other = (Exam) obj;
	if (examcode == null) {
		if (other.examcode != null)
			return false;
	} else if (!examcode.equals(other.examcode))
		return false;
	return true;
}
@Override
public String toString() {
	return "Exam [examcode=" + examcode + ", examname=" + examname + ", time=" + time + ", testlist=" + testlist + "]";
}

}
