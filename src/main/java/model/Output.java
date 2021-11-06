package model;

import java.io.Serializable;

public class Output implements Serializable {
	private String id;
	private String name;
	private String gender;
	private String contents;
	
	public Output() {}
	public Output(String id,String name,String gender,String contents) {
		this.name = name;
		this.id = id;
		this.gender = gender;
		this.contents = contents;
		
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
}