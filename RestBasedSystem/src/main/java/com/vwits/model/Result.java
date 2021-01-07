package com.vwits.model;

public class Result {
String userid;
String name;
String examname;
int marks;
int total;
public Result() {
	// TODO Auto-generated constructor stub
}
public Result(String userid, String name, String examname, int marks, int total) {
	super();
	this.userid = userid;
	this.name = name;
	this.examname = examname;
	this.marks = marks;
	this.total = total;
}
public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getExamname() {
	return examname;
}
public void setExamname(String examname) {
	this.examname = examname;
}
public int getMarks() {
	return marks;
}
public void setMarks(int marks) {
	this.marks = marks;
}
public int getTotal() {
	return total;
}
public void setTotal(int total) {
	this.total = total;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((userid == null) ? 0 : userid.hashCode());
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
	Result other = (Result) obj;
	if (userid == null) {
		if (other.userid != null)
			return false;
	} else if (!userid.equals(other.userid))
		return false;
	return true;
}
@Override
public String toString() {
	return "Result [userid=" + userid + ", name=" + name + ", examname=" + examname + ", marks=" + marks + ", total="
			+ total + "]";
}

}
