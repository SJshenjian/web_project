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

import com.haotu369.controller.ProjectController;
import com.haotu369.mapper.ProjectMapper;
import com.haotu369.service.ProjectService;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath:spring-mvc.xml","classpath:spring-mybatis.xml"})
public class ProjectControllerTest {

	private MockMvc mockMvc;

	@Autowired
	ProjectMapper projectMapper;
	
	@Autowired
	ProjectService projectService;
	
	@Autowired
	ProjectController projectController;
	
	 @Before
	 public void setup() {
	    MockitoAnnotations.initMocks(this);
	    this.mockMvc=MockMvcBuilders.standaloneSetup(projectController).build();
	 }
	 
	 /**测试添加项目
	 * @throws Exception **/
	 @Test
	 public void testAddProject() throws Exception{
		 /*mockMvc.perform(post("/project/add")
				 		.param("name", "name")
				 		.param("descript", "descript")
				 		.param("problem", "problem")
				 ).andExpect(view().name("project_add"));*/
	 }
	 
	 /**测试修改项目
	 * @throws Exception **/
	 @Test
	 public void testUpdateProject() throws Exception{
		 mockMvc.perform(post("/project/update")
			 		.param("name", "沈健")
			 		.param("descript", "descript")
			 		.param("problem", "problem")
			 ).andExpect(view().name("redirect:/project/list?pageNum=1"));
	 }
	
	 /**测试删除项目
	 * @throws Exception **/
	 @Test
	 public void testDeleteProject() throws Exception{
		 mockMvc.perform(get("/project/delete")
				 		.param("id", "1")).andExpect(view().name("redirect:/project/list?pageNum=1"));
	 }
	 
	 /**测试查询项目
	 * @throws Exception **/
	 @Test
	 public void testGetProject() throws Exception{
		 mockMvc.perform(get("/project/list")
				 		.param("pageNum", "1")).andExpect(view().name("project_list"));
	 }
	 
}
