package com.haotu369.xuefeng.controller;

import java.util.List;

import com.haotu369.xuefeng.model.Blog;
import com.haotu369.xuefeng.model.Tag;
import com.haotu369.xuefeng.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
	private BlogService blogService;
	
    /**根据博客类型进行查询相应博客**/
    //沈健5.20
	@RequestMapping("/{type}")	
	public String blog(@PathVariable int type,@RequestParam(value="pageNum",defaultValue="1") int pageNum, Model model){
		
		List<Blog> blogs=blogService.getBlogByPageNumSize(type,pageNum);
		List<Tag> tags=blogService.getTag();
		
		model.addAttribute("blogs",blogs);
		model.addAttribute("tags",tags);
		
		return "blog";
	}	
	
	/**查询博客的详细信息**/
	//沈健5.20
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	public String getDetail(int id,Model model){
			
		Blog blog=blogService.getBlog(id);
		model.addAttribute("blog",blog);
		
		if(blog.getType()!=12){
			return "blog_detail";
		}
		return "video";
	}
	
	
	/**后台首页(博客添加)**/
	//沈健5.21
	@RequestMapping("/index")
	public String indexBlog(Model model){
		
		List<Tag> tags=blogService.getTag();
		
		model.addAttribute("tags",tags);
		
		return "blog_add";
	}
	
	/**添加博客**/
	//沈健5.21
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addBlog(Blog blog,Model model){
		
		blogService.addBlog(blog);
		List<Tag> tags=blogService.getTag();
		
		model.addAttribute("tags",tags);
		
	    this.listBlog(blog.getType(), 1,model);
	    
	    return "blog_list";
	    
	}
	
	/**博客列表**/
	//沈健6.1
	@RequestMapping("/list")
	public String listBlog(@RequestParam(value="type",defaultValue="1") int type,@RequestParam(value="pageNum",defaultValue="1") int pageNum,Model model){		
		List<Blog> blogs=blogService.getBlogByPageNumSize(type, pageNum);
		List<Tag> tags=blogService.getTag(); 
		
		model.addAttribute("blogs",blogs);
		model.addAttribute("tags",tags);
		return "blog_list";
	}
	
	/**删除博客**/
	//沈健6.1
	@RequestMapping("/delete")
	public String deleteBlog(int id,int type){
		blogService.deleteBlog(id);
		return "redirect:/blog/list?type="+type;
	}
	
	/**修改博客**/
	//沈健6.1
	@RequestMapping("/modify")
	public String modifyBlog(int id,Model model){
		Blog blog=blogService.getBlog(id);
		List<Tag> tags=blogService.getTag(); 
		
		model.addAttribute("blog",blog);
		model.addAttribute("tags",tags);
		return "blog_modify";
	}
	
	/**更新博客**/
	//沈健6.1
	@RequestMapping("/update")
	public String updateBlog(Blog blog,Model model){
		blogService.updateBlog(blog);
		return "redirect:/blog/list?type="+blog.getType();
	}
}
