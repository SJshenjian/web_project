package com.haotu369.xuefeng.model;

public class Visitor {

	private int id;//id 主键
	private String name;//访客姓名
	private String email;//访客邮箱号
	private String subject;//留言主题
	private String content;//留言内容
	
	
	public Visitor(){};
	
	public Visitor(String name, String email, String subject, String content) {
		super();
		this.name = name;
		this.email = email;
		this.subject = subject;
		this.content = content;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
