package com.haotu369.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.haotu369.model.Blog;
import com.haotu369.model.Tag;

@Repository
public interface BlogMapper {
    
	/**根据博客类型进行分页查询
	 * pageNum:当前页  pageSize:页的大小
	 * 名称不能更改**/
	List<Blog> getBlogByPageNumSize(@Param("type") int type,@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);
		
	/**查询博客总共数量 根据类型**/
	int getTotalBlogSizeByType(int type);
	
	/**查询详细的博客内容**/
	Blog getBlog(int id);
	
	/**更新博客浏览量, pv(浏览1次加1次) 非 uv(单一用户即使浏览10次也只加1)**/
	void updateCount(int id);

	/**添加博客**/
	void addBlog(Blog blog);
	
	/**博客类别信息查询**/
	List<Tag> getTag();

	/**删除博客**/
	void deleteBlog(int id);

	/**更新博客**/
	void updateBlog(Blog blog);
	
}
