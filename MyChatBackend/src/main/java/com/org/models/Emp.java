package com.org.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
@Entity
@Table(name="emp_s123")
public class Emp {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
private String empTitle;
private String empDescription;
private String skillsRequired;
private String location;
private String salary;
private String companyName;
private Date postedOn;
private String yrsOfExp;
private boolean active;//admin updates the field active false/true
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getEmpTitle() {
	return empTitle;
}
public void setEmpTitle(String empTitle) {
	this.empTitle = empTitle;
}
public String getEmpDescription() {
	return empDescription;
}
public void setEmpDescription(String empDescription) {
	this.empDescription = empDescription;
}
public String getSkillsRequired() {
	return skillsRequired;
}
public void setSkillsRequired(String skillsRequired) {
	this.skillsRequired = skillsRequired;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public String getSalary() {
	return salary;
}
public void setSalary(String salary) {
	this.salary = salary;
}
public String getCompanyName() {
	return companyName;
}
public void setCompanyName(String companyName) {
	this.companyName = companyName;
}
public Date getPostedOn() {
	return postedOn;
}
public void setPostedOn(Date postedOn) {
	this.postedOn = postedOn;
}
public String getYrsOfExp() {
	return yrsOfExp;
}
public void setYrsOfExp(String yrsOfExp) {
	this.yrsOfExp = yrsOfExp;
}
public boolean isActive() {
	return active;
}
public void setActive(boolean active) {
	this.active = active;
}


}
