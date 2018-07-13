package java.xuefeng;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;//get post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;//view model

import com.haotu369.controller.UserController;
import com.haotu369.mapper.UserMapper;
import com.haotu369.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath:spring-mvc.xml","classpath:spring-mybatis.xml"})
public class UserControllerTest {

	private MockMvc mockMvc;
    
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserService userService;
	
	@Autowired
    private UserController userController;
	
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc=MockMvcBuilders.standaloneSetup(userController).build();
    }
    
	@Test
	public void testGetUser() throws Exception{
		
		assertEquals(userService.getUser().getName(),"沈健");
				
		mockMvc.perform(get("/info")).andExpect(view().name("index"));	
		mockMvc.perform(get("/info")).andExpect(view().name("index"));	
		
	}
}
