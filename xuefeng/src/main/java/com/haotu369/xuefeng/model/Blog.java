package com.haotu369.xuefeng.model;

public class Blog {

	private int id;//博客编号
	private String topic;//博客标题
	private String content;//内容
	private int type;//类别
	private String date;//日期
    private String count;//阅读量
    private Tag tag;//类别详情   
    
    public Blog(){};
    
    public Blog(String topic,String content,int type){
    	this.topic=topic;
    	this.content=content;
    	this.type=type;
    }
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}	
	
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getCount() {
		return count;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setCount(String count) {
		this.count = count;
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}
}
