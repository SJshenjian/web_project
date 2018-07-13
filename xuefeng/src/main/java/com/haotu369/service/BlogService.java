package com.haotu369.service;

import java.util.List;

import com.haotu369.model.Blog;
import com.haotu369.model.Tag;

public interface BlogService {

	/**根据用户点击类型算法查询相关信息列表**/
	//沈健5.20
	List<Blog> getBlogByPageNumSize(int type,int pageNum);
	
	/**查看博客详细信息**/
	//沈健5.20
	Blog getBlog(int id);

	/**发布博客**/
	//沈健5.21
	void addBlog(Blog blog);
	
	/**查询博客类型**/
	//沈健5.22
	List<Tag> getTag();

	/**删除博客**/
	//沈健6.1
	void deleteBlog(int id);

	/**更新博客**/
	//沈健6.1
	void updateBlog(Blog blog);
	
}
