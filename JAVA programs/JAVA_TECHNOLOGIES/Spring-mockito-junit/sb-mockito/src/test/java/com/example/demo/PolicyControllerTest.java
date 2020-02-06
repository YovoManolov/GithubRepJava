package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.*;

import com.example.demo.controllers.PolicyController;
import com.example.demo.services.PolicyService;

@RunWith(SpringRunner.class)
@WebMvcTest(PolicyController.class)
public class PolicyControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean 
	private PolicyService policyService;
	
	@Test
	public void test() throws Exception {
		final int policyNumber = 4;
		
		given(policyService.getPolicy(policyNumber)).willReturn("plamenov");
		
		mvc.perform(
				get(PolicyController.URL, policyNumber).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().string("plamenov"));
	}
}
