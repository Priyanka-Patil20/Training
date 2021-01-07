package com.vwits.model;

public class Admin {
String adminid;
String name;
String password;
String email;
int contact;
public Admin() {
	// TODO Auto-generated constructor stub
}
public String getAdminid() {
	return adminid;
}
public void setAdminid(String adminid) {
	this.adminid = adminid;
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
public Admin(String adminid, String name, String password, String email, int contact) {
	super();
	this.adminid = adminid;
	this.name = name;
	this.password = password;
	this.email = email;
	this.contact = contact;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((adminid == null) ? 0 : adminid.hashCode());
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
	Admin other = (Admin) obj;
	if (adminid == null) {
		if (other.adminid != null)
			return false;
	} else if (!adminid.equals(other.adminid))
		return false;
	return true;
}
@Override
public String toString() {
	return "Admin [adminid=" + adminid + ", name=" + name + ", password=" + password + ", email=" + email + ", contact="
			+ contact + "]";
}

}
