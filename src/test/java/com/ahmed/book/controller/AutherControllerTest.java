package com.ahmed.book.controller;

import com.ahmed.book.dto.AutherDto;
import com.ahmed.book.entity.Auther;
import com.ahmed.book.service.AutherService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestInstance(Lifecycle.PER_CLASS)
@Log4j2
public class AutherControllerTest {

//	@Autowired
//	TestRestTemplate restTemplate;
	
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;

	@MockitoBean
	AutherService autherService;
	
	@BeforeAll
	public void initMethod () {
	
		log.info("==== >> init method");
		
     Optional<Auther> autherParam = Optional.of(new Auther("Ali", "19.2.125.52", "ali@gmail.com", 0, null));
		
		Mockito.when(autherService.findByEmail(Mockito.anyString())).thenReturn(autherParam);
		
	}
	
//	@Test
//	public void findByEmailNotFoundTest() throws Exception {
//		
//		String email = "ali@gmail.com";
//		
//		mockMvc.perform(get("/auther/email/{email}", email)
//	            .contentType("application/json"))
////	            .param("sendWelcomeMail", "true")
////	            .content(objectMapper.writeValueAsString(new Auther("Ali", "19.2.125.52", "ali@gmail.com", 0, null))))
//		      .andExpect(status().isOk());
//
//	}
	
	
	@Test
	public void insertAutherTest() throws Exception {

		Auther autherParam = new Auther("Ali", "192.1682.125.52", "ali@gmail.com", 0, null);
		

		AutherDto dto = new AutherDto();

		Mockito.when(autherService.insert(Mockito.any(Auther.class))).thenReturn(autherParam);

		mockMvc.perform(post("/auther")
	            .contentType("application/json")
	            .content(objectMapper.writeValueAsString(dto)))
		      .andExpect(status().isOk());

	}
	

//	@Test
//	public void findByEmailNotFoundTest() {
//
//		Optional<Auther> autherParam = Optional.of(new Auther("Ali", "19.2.125.52", "ali@gmail.com", 0, null));
//
//		Mockito.when(autherService.findByEmail(Mockito.anyString())).thenReturn(autherParam);
//
//		String email = "ali@gmail.com";
//		ResponseEntity<AutherDto> respEntity = restTemplate.getForEntity("/auther/email/" + email, AutherDto.class);
//		assertThat(respEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
//		assertEquals(HttpStatus.OK, respEntity.getStatusCode());
////	 assertThat(respEntity.getBody()).isEqualTo("OK");
//	}
	
	@AfterAll
	public void destroy () {
		log.info("=====>> in destroy method");
	}
}
