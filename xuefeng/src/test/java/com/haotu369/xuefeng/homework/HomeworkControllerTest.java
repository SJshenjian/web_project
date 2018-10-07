package com.haotu369.xuefeng.homework;

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

import com.haotu369.xuefeng.controller.HomeworkController;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;//get post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;//view model

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath:spring-mybatis.xml","classpath:spring-mvc.xml"})
public class HomeworkControllerTest {

	MockMvc mockMvc;
	
	@Autowired	
	HomeworkController homeworkController;
	
	 @Before
	 public void setup() {
	    MockitoAnnotations.initMocks(this);
	    this.mockMvc=MockMvcBuilders.standaloneSetup(homeworkController).build();
	 }
	 
	 @Test
	 public void downloadHomeworkTest() throws Exception{
		 mockMvc.perform(get("/homework/download")).andExpect(view().name("homework_download"));
	 }
}
