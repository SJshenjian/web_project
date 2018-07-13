package com.haotu369.model;

public class User {
	
	int id;//id
	String name;//姓名
	String signature;//个性签名
	String resume;//简介
	String mobile;//移动电话
	String email;//电子邮箱
	
	public User(){};
	
	public User(int id, String name, String signature, String resume, String mobile, String email) {
		super();
		this.id=id;
		this.name = name;
		this.signature = signature;
		this.resume = resume;
		this.mobile = mobile;
		this.email = email;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
