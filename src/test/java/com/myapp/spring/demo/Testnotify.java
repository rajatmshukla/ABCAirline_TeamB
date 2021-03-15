package com.myapp.spring.demo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myapp.spring.ServletInitializer;
import com.myapp.spring.model.Productnotify;
import com.myapp.spring.repository.PassengerRepositoryNotifyImpl;
import com.myapp.spring.repository.PassengerRepositorynotify;

@SpringBootTest

@AutoConfigureMockMvc
public class Testnotify {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private PassengerRepositorynotify userService;

	private static File DATA_JSON = Paths.get("src", "main", "resources", "Notify.json").toFile();

	Productnotify login[] = null;

	@BeforeEach
	void setup() throws JsonParseException, JsonMappingException, IOException {

		login = new ObjectMapper().readValue(DATA_JSON, Productnotify[].class);

	}

	@Test
	public void testCreateUser() throws Exception {
		String username = "apoorva";
		when(userService.Notifyuser(username)).thenReturn(getUserInfo());
		Productnotify mockFlight = new Productnotify();
		mockFlight.getUsername();
		mockFlight.getFirstname();
		mockFlight.getLastname();
		mockFlight.getTravelDate();
		mockFlight.getSeatNo();
		ServletInitializer ab = new ServletInitializer();
		PassengerRepositoryNotifyImpl newrepo = new PassengerRepositoryNotifyImpl();
		doReturn(mockFlight).when(userService).Notifyuser(mockFlight.getUsername());
		MvcResult result = mockMvc.perform(get("/airline/login/notify/apoorva")).andExpect(status().isOk()).andReturn();
		System.out.println(result.getResponse().getContentAsString());
		assertTrue(result.getResponse().getContentAsString()
				.contains("<html><body>" + "<h1>WELCOME TO ABC AIRLINES </h1><br> <h3>Hello</h3>"
						+ getUserInfo().getFirstname() + " " + getUserInfo().getLastname()
						+ "<h3>Your Travel is Scheduled ON : <br>" + getUserInfo().getTravelDate()
						+ "<h3>Your Seat No. Is : <br>" + getUserInfo().getSeatNo()
						+ "<h3>THANK YOU FOR FLYING WITH US! <br>" + "</body> </html>"));

		System.out.println(result.getResponse().getContentAsString());
		assertFalse(result.getResponse().getContentAsString().contains("<html><body>"
				+ "<h1>login Details</h1><br> <h3>Your username is not present in our database.<br>Unfortunatly your login is NOT DONE</h3>"
				+ "</body></html>"));
	}

	private Productnotify getUserInfo() {
		Productnotify user = new Productnotify();
		user.setUsername("apoorva");
		user.setFirstname("apoorva");
		user.setLastname("babu");
		user.setTravelDate("2011-04-21");
		user.setSeatNo("7h");
		return user;

	}

}