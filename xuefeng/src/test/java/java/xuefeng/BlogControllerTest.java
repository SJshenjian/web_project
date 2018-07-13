package java.xuefeng;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;//get post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;//view model

import com.haotu369.controller.BlogController;
import com.haotu369.mapper.BlogMapper;
import com.haotu369.service.BlogService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath:spring-mybatis.xml","classpath:spring-mvc.xml"})
public class BlogControllerTest {

	private MockMvc mockMvc;

	@Autowired
	BlogMapper blogMapper;
	
	@Autowired
	BlogService blogService;
	
	@Autowired
	BlogController blogController;
	
	 @Before
	 public void setup() {
	    MockitoAnnotations.initMocks(this);
	    this.mockMvc=MockMvcBuilders.standaloneSetup(blogController).build();
	 }
	 
	 @Test
	 public void testBlog() throws Exception{
		 
		/* Blog blog=blogService.getBlog(15);*/
		 //assertNotNull(blog.getTag().getName());
		 
		 //assertEquals(blogService.selectBlogByPageNumSize("JAVA").size(),4);
		 mockMvc.perform(get("/blog/1?pageNum=1")).andExpect(view().name("blog"))
		 					.andExpect(model().attributeExists("blogs"));
		 mockMvc.perform(get("/blog/1?pageNum=1")).andExpect(view().name("blog"))
			.andExpect(model().attributeExists("blogs"));
		 
		/* List<Blog> list=blogService.getBlogByPageNumSize(1, 1);
		 assertEquals(14,list.size());
		 List<Blog> list2=blogService.getBlogByPageNumSize(2, 1);
		 assertEquals(1,list2.size());
		 */
		/* mockMvc.perform(get("/blog/video")).andExpect(view().name("blog"));*/
		 
		 /*mockMvc.perform(get("/blog/detail?id=2&type=java")).andExpect(view().name("blog_detail"))
			.andExpect(model().attributeExists("blogDetail"));*/
	 }
	 
	 @Test
	 public void testEditBlog() throws Exception{
		
		/* mockMvc.perform(post("/blog/edit")
		         .param("topic", "哈喽")
		         .param("content", "<p>啦啦</p>")
		         .param("type", "1")).andExpect(view().name("blog_index"));
		 mockMvc.perform(post("/blog/edit")
		         .param("topic", "哈喽")
		         .param("content", "<p>啦啦</p>")
		         .param("type", "1")).andExpect(view().name("blog_index"));*/
	 }
	
	 @Test
	 public void testGetDetail() throws Exception{
		
		 
		 mockMvc.perform(get("/blog/detail?id=10")).andExpect(view().name("blog_detail"))
			.andExpect(model().attributeExists("blog"));
		  
	 }
	 
	 /**删除测试
	 * @throws Exception **/
	 @Test
	 public void testDeleteBlog() throws Exception{
		// mockMvc.perform(get("/blog/delete?id=77")).andExpect(view().name("blog_list"));
	 }
	 
	 /**修改测试
	 * @throws Exception **/
	 @Test
	 public void testUpdateBlog() throws Exception{
		 mockMvc.perform(get("/blog/update")
				 .param("topic", "虚拟机")
				 .param("type","3")
				 .param("content", "这是虚拟机内容")
				 .param("id", "7")
				 );
		 
	 }

}
