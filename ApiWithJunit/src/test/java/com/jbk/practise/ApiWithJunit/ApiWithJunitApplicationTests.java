package com.jbk.practise.ApiWithJunit;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jbk.ApiController.ApiWithJunitApplication;


@SpringBootTest(classes=ApiWithJunitApplication.class)
@AutoConfigureMockMvc
class ApiWithJunitApplicationTests {

	@Test
	void contextLoads() {
	}
	
	 protected String mapToJson(Object obj) throws JsonProcessingException {
	      ObjectMapper objectMapper = new ObjectMapper();
	      return objectMapper.writeValueAsString(obj);
	   }

}
