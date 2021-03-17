

package com.myapp.spring.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myapp.spring.ServletInitializer;
import com.myapp.spring.model.Product;
import com.myapp.spring.*;
import com.myapp.spring.repository.*;


@SpringBootTest


@AutoConfigureMockMvc
public class PassengerApiTest {

	@MockBean
	private PassengerRepository service;

	@Autowired
	private MockMvc mockMvc;
	
	

	private static File DATA_JSON = Paths.get("src", "main", "resources", "crm.json").toFile();

	Product flights[] = null;

	@BeforeEach
	void setup() throws JsonParseException, JsonMappingException, IOException {

		flights = new ObjectMapper().readValue(DATA_JSON, Product[].class);

	}

	@Test
	public void testGetFlightById() throws Exception {

		Product mockFlight = new Product();
		mockFlight.setFirstname("jaasir");
		mockFlight.setLastname("kp");
		mockFlight.setEmail("jas@gmail.com");
		mockFlight.setMobile("9048081234");
		mockFlight.setFlightid(90);
		mockFlight.setTraveldate("2020-09-18");
		mockFlight.setFeedback("nice");
		mockFlight.setRating(4);

		
		Product mockFlightcons = new Product("jaasir","kp","jas@gmail.com","9048081234",90,"2020-09-18","nice",4);
		mockFlight.getFirstname();
		ServletInitializer ab = new ServletInitializer();
		PassengerRepositoryImpl newrepo = new PassengerRepositoryImpl();
			doReturn(mockFlight).when(service).findByNamecrm(mockFlight.getFirstname());
		mockMvc.perform(MockMvcRequestBuilders.get("/airline/feedback/jaasir", "jaasir")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))

				

				.andExpect(jsonPath("$.lastname", is("kp")));

	}
	
	@Test
	public void testGetFlightById2() throws Exception {

		Product mockFlight = new Product();
		mockFlight.setFirstname("madhu");
		mockFlight.setLastname("mk");
		mockFlight.setEmail("mmm@gmail.com");
		mockFlight.setMobile("9048812346");
		mockFlight.setFlightid(92);
		mockFlight.setTraveldate("2018-12-06");
		mockFlight.setFeedback("nice");
		mockFlight.setRating(5);

		
		mockFlight.getFirstname();
		ServletInitializer ab = new ServletInitializer();
		PassengerRepositoryImpl newrepo = new PassengerRepositoryImpl();
		
		doReturn(mockFlight).when(service).findByNamecrm(mockFlight.getFirstname());
		mockMvc.perform(MockMvcRequestBuilders.get("/airline/feedback/madhu", "madhu")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))

				

				.andExpect(jsonPath("$.lastname", is("mk")));

	}

	@Test
	
	public void testAddNewFlight() throws Exception {

		Product mockFlight = new Product();
		mockFlight.setFirstname("sushma");
		mockFlight.setLastname("g");
		mockFlight.setEmail("sg@gmail.com");
		mockFlight.setMobile("9054672834");
		mockFlight.setFlightid(73);
		mockFlight.setTraveldate("2021-02-28");
		mockFlight.setFeedback("new");
		mockFlight.setRating(5);
		doReturn(mockFlight).when(service).saveProductcrm(ArgumentMatchers.any());

		mockMvc.perform(post("/airline/feedback").contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(new ObjectMapper().writeValueAsString(mockFlight)))

				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$.firstname", is("sushma")));

	}

}

