package com.h2.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.h2.model.User;
import com.h2.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {
	
	@Autowired
	private UserController controller;
	
	@MockBean
	private UserService service;
	
	private MockMvc mockmvc;
	
	@Before
	public void setUp(){
		mockmvc=MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	public void addUserTest() throws JsonProcessingException, Exception {
		User user=new User(1, "Dhananjaya", "bbsr");
		Mockito.when(service.saveUser(user)).thenReturn(user);
		
		mockmvc.perform(MockMvcRequestBuilders.post("/user/save")
				.header("Authorization", "authToken")
				.contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(user)))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("Dhananjaya"));
		
		mockmvc.perform(MockMvcRequestBuilders.post("/user/save")
				.header("Authorization", "authToken")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
		
	}

}
