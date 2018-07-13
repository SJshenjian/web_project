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

import com.haotu369.controller.VisitorController;
import com.haotu369.mapper.VisitorMapper;
import com.haotu369.model.Visitor;
import com.haotu369.service.VisitorService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath:spring-mvc.xml","classpath:spring-mybatis.xml"})
public class VisitorCotrollerTest {
	
	private MockMvc mockMvc;
	
	@Autowired
	private VisitorMapper vistorMapper;
	
	@Autowired
	private VisitorService visitorService;
	
	@Autowired
	private VisitorController visitorController;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		this.mockMvc=MockMvcBuilders.standaloneSetup(visitorController).build();
	}
	
	@Test
	public void testContactMe() throws Exception{
		
		Visitor visitor=new Visitor("马良","1515345281@qq.com","哈哈","测试成功");
		mockMvc.perform(post("/contact")).andExpect(view().name("index"));
	}
}
