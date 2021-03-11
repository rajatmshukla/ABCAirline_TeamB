package com.myapp.spring;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.myapp.spring.model.Product;
import com.myapp.spring.repository.PassengerRepository;

//@SpringBootTest
@WebMvcTest
class AirlineTeamBApplicationTests {
	List<Product> products;
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PassengerRepository passengerRepository;

	@Test
	public void testGetProducts() throws Exception {

		Product product1 = new Product();
		product1.getUsername("apoorva");

		Product product2 = new Product();
		product2.getUsername("a");

		Mockito.when(passengerRepository.findAll()).thenReturn(products);
		mockMvc.perform(get("/airline")).andExpect(status().isOk()).andExpect(jsonPath("$", Matchers.hasSize(2)))
				.andExpect(jsonPath("$[0].Username", Matchers.equalTo("apoorva")));

	}
}