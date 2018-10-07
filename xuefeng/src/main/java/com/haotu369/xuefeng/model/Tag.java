package com.haotu369.xuefeng.model;

public class Tag {

	private int id;//类别编号
	private String name;//类别名称
	private int totalPage;//该类型博客的总共数量
	
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
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
}
