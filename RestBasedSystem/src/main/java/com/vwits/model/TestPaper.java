package com.vwits.model;

public class TestPaper {
int srno;
String que;
String opt1;
String opt2;
String opt3;
String opt4;
String ans;
int marks;

public TestPaper() {
	// TODO Auto-generated constructor stub
}

public TestPaper(int srno, String que, String opt1, String opt2,  String opt3, String opt4, String ans, int marks) {
	super();
	this.srno = srno;
	this.que = que;
	this.opt1 = opt1;
	this.opt2 = opt2;
	this.opt3 = opt3;
	this.opt4 = opt4;
	this.ans = ans;
	this.marks = marks;
}

public int getSrno() {
	return srno;
}

public void setSrno(int srno) {
	this.srno = srno;
}

public String getQue() {
	return que;
}

public void setQue(String que) {
	this.que = que;
}

public String getOpt1() {
	return opt1;
}

public void setOpt1(String opt1) {
	this.opt1 = opt1;
}

public String getOpt2() {
	return opt2;
}

public void setOpt2(String opt2) {
	this.opt2 = opt2;
}

public String getOpt3() {
	return opt3;
}

public void setOpt3(String opt3) {
	this.opt3 = opt3;
}

public String getOpt4() {
	return opt4;
}

public void setOpt4(String opt4) {
	this.opt4 = opt4;
}

public String getAns() {
	return ans;
}

public void setAns(String ans) {
	this.ans = ans;
}

public int getMarks() {
	return marks;
}

public void setMarks(int marks) {
	this.marks = marks;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + srno;
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
	TestPaper other = (TestPaper) obj;
	if (srno != other.srno)
		return false;
	return true;
}

@Override
public String toString() {
	return "TestPaper [srno=" + srno + ", que=" + que + ", opt1=" + opt1 + ", opt2=" + opt2 + ", opt3=" + opt3
			+ ", opt4=" + opt4 + ", ans=" + ans + ", marks=" + marks + "]";
}

}
