package com.myapp.spring.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myapp.spring.ServletInitializer;
import com.myapp.spring.model.ProductLogin;
import com.myapp.spring.repository.PassengerRepositoryLogin;
import com.myapp.spring.repository.PassengerRepositoryLoginImpl;

@SpringBootTest

@AutoConfigureMockMvc
public class LoginTest {

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private PassengerRepositoryLogin userService;

	private static File DATA_JSON = Paths.get("src", "main", "resources", "Login.json").toFile();

	ProductLogin login[] = null;

	@BeforeEach
	void setup() throws JsonParseException, JsonMappingException, IOException {

		login = new ObjectMapper().readValue(DATA_JSON, ProductLogin[].class);

	}

	@Test
	public void testCreateUserLogin() throws Exception {
		String username = "swati";
		String pass = "adcd";
		when(userService.findByUsernameLog(username, pass)).thenReturn(getUserInfo());
		ProductLogin mockFlight = new ProductLogin();
		mockFlight.getUsername();
		mockFlight.getPass();
		ProductLogin mockFlightcons = new ProductLogin("swati", "adcd");
		ServletInitializer ab = new ServletInitializer();
		PassengerRepositoryLoginImpl newrepo = new PassengerRepositoryLoginImpl();
		doReturn(mockFlight).when(userService).findByUsernameLog(mockFlight.getUsername(), mockFlight.getPass());

		MvcResult result = mockMvc.perform(get("/airlogin/login/swati/adcd")).andExpect(status().isOk()).andReturn();
		System.out.println(result.getResponse().getContentAsString());
		assertFalse(result.getResponse().getContentAsString()
				.contains("<html><body>" + "<h1>login Details</h1><br> <h3>Your Username " + getUserInfo().getUsername()
						+ " is present in our database.<br>Congratulations your login Done!</h3>" + "</body></html>"));

	}

	@Test
	public void testCreateUserLogin2() throws Exception {
		String username = "swatim";
		String pass = "adcd";
		when(userService.findByUsernameLog(username, pass)).thenReturn(getUserInfo());
		ProductLogin mockFlight = new ProductLogin();
		mockFlight.getUsername();
		mockFlight.getPass();
		ProductLogin mockFlightcons = new ProductLogin("swati", "adcd");
		ServletInitializer ab = new ServletInitializer();
		PassengerRepositoryLoginImpl newrepo = new PassengerRepositoryLoginImpl();
		doReturn(mockFlight).when(userService).findByUsernameLog(mockFlight.getUsername(), mockFlight.getPass());

		MvcResult result = mockMvc.perform(get("/airlogin/login/swati/adcd")).andExpect(status().isOk()).andReturn();

		System.out.println(result.getResponse().getContentAsString());

		assertTrue(result.getResponse().getContentAsString().contains("<html><body>"
				+ "<h1>login Details</h1><br> <h3>Your username is not present in our database.<br>Unfortunatly your login is NOT DONE</h3>"
				+ "</body></html>"));

	}

	private ProductLogin getUserInfo() {
		ProductLogin user = new ProductLogin();
		user.setUsername("swati");
		user.setPass("adcd");

		return user;

	}

	@Test
	public void testCreateWelcomeLogin() throws Exception {

		MvcResult result = mockMvc.perform(get("/airlogin/login")).andExpect(status().isOk()).andReturn();
		System.out.println(result.getResponse().getContentAsString());
		assertTrue(result.getResponse().getContentAsString().contains(

				"<html><body>" + "<h1>WELCOME TO ABC AIRLINES </h1><br> <h3>login </h3>" + "</body></html>"));

		System.out.println(result.getResponse().getContentAsString());

	}

	@Test

	public void testLogin() throws Exception {
		ProductLogin mockFlight = new ProductLogin();
		mockFlight.setUsername("swati");
		mockFlight.setPass("adcd");

		doReturn(mockFlight).when(userService).saveProductLog(ArgumentMatchers.any());
		mockMvc.perform(post("/airlogin").contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(new ObjectMapper().writeValueAsString(mockFlight))).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$.username", is("swati")));
	}

}