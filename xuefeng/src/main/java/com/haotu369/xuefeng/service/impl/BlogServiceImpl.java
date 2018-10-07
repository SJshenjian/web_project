package com.haotu369.xuefeng.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haotu369.xuefeng.mapper.BlogMapper;
import com.haotu369.xuefeng.model.Blog;
import com.haotu369.xuefeng.model.Tag;
import com.haotu369.xuefeng.service.BlogService;

@Service
@Transactional
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogMapper blogMapper;
	
	@Override
	@Cacheable(value="blogCache")
	public List<Blog> getBlogByPageNumSize(int type,int pageNum) {
		System.out.println("仅出现一次"+pageNum);
		int pageSize=14;//设置页的大小,由于作品展中也需要进行分页，可能不根据14分页，故不设为全局。
		
		int totalSize=blogMapper.getTotalBlogSizeByType(type);
		
		if(totalSize == 0){
			return null;
		}
		
		int totalPage=(totalSize/pageSize)+1;
		
		List<Blog> blogs=blogMapper.getBlogByPageNumSize(type,pageNum,pageSize);
		blogs.get(0).getTag().setTotalPage(totalPage);
		
		return blogs;
	}

	@Override
	//@Cacheable(value="blogDetailCache")
	public Blog getBlog(int id) {
		blogMapper.updateCount(id);//更新博客浏览量
		return blogMapper.getBlog(id);
	}

	@Override
	@CacheEvict(value="blogCache",allEntries=true)
	//allEntries=true:去除所有存储子blogCache中的缓存
	public void addBlog(Blog blog) {
		blogMapper.addBlog(blog);
	}
	
	@Override
	@Cacheable(value="blogTagInfoCache")
	public List<Tag> getTag(){
		System.out.println("执行getTag一次");
		return blogMapper.getTag();
	}

	/**删除博客**/
	@Override
	@CacheEvict(value="blogCache",allEntries=true)
	public void deleteBlog(int id) {
		blogMapper.deleteBlog(id);
	}

	/**更新博客**/
	@Override
	@CacheEvict(value="blogCache",allEntries=true)
	public void updateBlog(Blog blog) {
		blogMapper.updateBlog(blog);
	}

}
