package model;

import java.io.Serializable;

public class Human implements Serializable {
	private String name;
	private String gender;
	private String box;
	
	public Human() {}
	public Human (String name,String gender,String box) {
		this.name = name;
		this.gender = gender;
		this.box = box;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBox() {
		return box;
	}
	public void setBox(String box) {
		this.box = box;
	}
	
}