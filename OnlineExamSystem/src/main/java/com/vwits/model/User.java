package com.vwits.model;


public class User {
String userid;
String name;
String password;
String email;
int contact;
String profile;
String status;

public User() {
	// TODO Auto-generated constructor stub
}

public User(String userid, String name, String password, String email, int contact, String profile, String status) {
	super();
	this.userid = userid;
	this.name = name;
	this.password = password;
	this.email = email;
	this.contact = contact;
	this.profile = profile;
	this.status = status;
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

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public int getContact() {
	return contact;
}

public void setContact(int contact) {
	this.contact = contact;
}

public String getProfile() {
	return profile;
}

public void setProfile(String profile) {
	this.profile = profile;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
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
	User other = (User) obj;
	if (userid == null) {
		if (other.userid != null)
			return false;
	} else if (!userid.equals(other.userid))
		return false;
	return true;
}

@Override
public String toString() {
	return "User [userid=" + userid + ", name=" + name + ", password=" + password + ", email=" + email + ", contact="
			+ contact + ", profile=" + profile + ", status=" + status + "]";
}

}
