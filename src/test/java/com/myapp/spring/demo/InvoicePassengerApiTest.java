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
import com.myapp.spring.model.Productinvoice;
import com.myapp.spring.repository.PassengerRepositoryInvoice;
import com.myapp.spring.repository.PassengerRepositoryInvoiceImpl;

@SpringBootTest

@AutoConfigureMockMvc
public class InvoicePassengerApiTest {
	@MockBean
	private PassengerRepositoryInvoice userService;
	@Autowired
	private MockMvc mockMvc;

	private static File DATA_JSON = Paths.get("src", "main", "resources", "Invoice.json").toFile();

	Productinvoice flights[] = null;

	@BeforeEach
	void setup() throws JsonParseException, JsonMappingException, IOException {

		flights = new ObjectMapper().readValue(DATA_JSON, Productinvoice[].class);

	}

	@Test
	public void testCreateUser() throws Exception {
		String username = "vennelAB";
		when(userService.getInvoice(username)).thenReturn(getUserInfo());
		Productinvoice mockFlight = new Productinvoice();
		mockFlight.getUsername();
		mockFlight.getPassword();
		mockFlight.getPrivileges();
		mockFlight.getFirstname();
		mockFlight.getLastname();
		mockFlight.getAge();
		mockFlight.getGender();
		mockFlight.getMobile();
		mockFlight.getEmail();
		mockFlight.getArrivalCity();
		mockFlight.getDepartureCity();
		mockFlight.getTravelDate();
		mockFlight.getSeatNo();
		mockFlight.getNumOfPassenger();
		mockFlight.getNumOfBags();
		mockFlight.getTotalFare();
		ServletInitializer ab = new ServletInitializer();
		PassengerRepositoryInvoiceImpl newrepo = new PassengerRepositoryInvoiceImpl();
		doReturn(mockFlight).when(userService).getInvoice(mockFlight.getUsername());

		MvcResult result = mockMvc.perform(get("/airline/invoice/vennelAB")).andExpect(status().isOk()).andReturn();
		System.out.println(result.getResponse().getContentAsString());
		assertTrue(result.getResponse().getContentAsString()
				.contains("<html><body>" + "<h1>WELCOME TO ABC AIRLINES </h1><br>" + "<h3>Hello "
						+ getUserInfo().getFirstname() + " " + getUserInfo().getLastname() + "<br>"
						+ "<h3>Your Travel is scheduled for " + getUserInfo().getTravelDate() + "<br>"
						+ "<h3>Your Seat No. is " + getUserInfo().getSeatNo() + "<br>" + "<h3>Privileges : "
						+ getUserInfo().getPrivileges() + "<br>" + "<h3>Age : " + getUserInfo().getAge() + "<br>"
						+ "<h3>Gender : " + getUserInfo().getGender() + "<br>" + "<h3>Mobile : "
						+ getUserInfo().getMobile() + "<br>" + "<h3>Email : " + getUserInfo().getEmail() + "<br>"
						+ "<h3>Arrival City : " + getUserInfo().getArrivalCity() + "<br>" + "<h3>Departure City : "
						+ getUserInfo().getDepartureCity() + "<br>" + "<h3>Num of Passengers : "
						+ getUserInfo().getNumOfPassenger() + "<br>" + "<h3> Num of Bags : "
						+ getUserInfo().getNumOfBags() + "<br>" + "<h3>Total Fare : " + getUserInfo().getTotalFare()
						+ "<br>" + "<h3>Thank you for flying with us... <br>" + "</body> </html>"));
		System.out.println(result.getResponse().getContentAsString());
		assertFalse(result.getResponse().getContentAsString().contains("<html><body>"
				+ "<h1>We have run into an error!!</h1><br> <h3>Your Username is not present in our database.<br>Please check your username again</h3>"
				+ "</body></html>"));

	}

	private Productinvoice getUserInfo() {
		Productinvoice user = new Productinvoice();

		user.setUsername("vennelAB");
		user.setPassword("admin");
		user.setPrivileges("bussiness");
		user.setFirstname("vennela");
		user.setLastname("bandla");
		user.setAge(22);
		user.setGender("female");
		user.setMobile(12345);
		user.setEmail("vennela@gmail.com");
		user.setArrivalCity("Pune");
		user.setDepartureCity("Hyderabad");
		user.setTravelDate("2021-05-18");
		user.setSeatNo("2c");
		user.setNumOfPassenger(1);
		user.setNumOfBags(1);
		user.setTotalFare(5555);

		return user;

	}

}