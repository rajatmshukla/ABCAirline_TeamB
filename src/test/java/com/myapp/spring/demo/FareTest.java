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
import java.util.Date;

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
import com.myapp.spring.model.ProductFare;
import com.myapp.spring.repository.PassengerRepositoryFare;
import com.myapp.spring.repository.PassengerRepositoryFareImpl;

@SpringBootTest

@AutoConfigureMockMvc
public class FareTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private PassengerRepositoryFare userService;

	private static File DATA_JSON = Paths.get("src", "main", "resources", "Fare.json").toFile();

	ProductFare login[] = null;

	@BeforeEach
	void setup() throws JsonParseException, JsonMappingException, IOException {

		login = new ObjectMapper().readValue(DATA_JSON, ProductFare[].class);

	}

	@Test
	public void testCalcFare() throws Exception {
		String flightname = "abc14";
		String classf="eco";
		
		
		when(userService.Notifyuser(flightname,classf)).thenReturn(getUserInfo1());
		ProductFare mockFlight = new ProductFare();
		mockFlight.getFlightname();
		mockFlight.getDuration();
		mockFlight.getSrc();
		mockFlight.getDes();
		mockFlight.getKms();
		mockFlight.getCapacity();
		mockFlight.getFoodbeverages();
		mockFlight.getFuelprice();
		mockFlight.getMaintanencecharges();
		mockFlight.getMiscellaneous();
		mockFlight.isSplday();
		mockFlight.getTechnicalexp();
		
			
		doReturn(mockFlight).when(userService).Notifyuser(mockFlight.getFlightname(),mockFlight.getClassf());
		MvcResult result = mockMvc.perform(get("/calc/abc14/eco")).andExpect(status().isOk())
				.andReturn();
		System.out.println(result.getResponse().getContentAsString());
		assertTrue(result.getResponse().getContentAsString()
				.contains("<html><body>" + "<h1>WELCOME TO ABC AIRLINES </h1><br> <h3>Hello current fare for flight:" + getUserInfo1().getFlightname() + " for " + getUserInfo1().getClassf()
						+ " class</h3><h5> as ON : "+"   is:</h5><h3> Rs. " +userService.dispFare(flightname, classf)
						+ "</h3><h3>HAVE A NICE DAY </h3>" + "</body> </html>"));
		
		
		
		

	}

	@Test
	public void testCalcFareErr() throws Exception {
		String flightname = "abc123";
		String classf="eco";
		
		Date date=new Date();
		when(userService.Notifyuser(flightname,classf)).thenReturn(getUserInfo2());
		ProductFare mockFlight = new ProductFare();
		mockFlight.getFlightname();
		mockFlight.getDuration();
		mockFlight.getSrc();
		mockFlight.getDes();
		mockFlight.getKms();
		mockFlight.getCapacity();
		mockFlight.getFoodbeverages();
		mockFlight.getFuelprice();
		mockFlight.getMaintanencecharges();
		mockFlight.getMiscellaneous();
		mockFlight.isSplday();
		mockFlight.getTechnicalexp();
		
			
		doReturn(mockFlight).when(userService).Notifyuser(mockFlight.getFlightname(),mockFlight.getClassf());
		MvcResult result = mockMvc.perform(get("/calc/abc123/eco")).andExpect(status().isOk())
				.andReturn();
		System.out.println(result.getResponse().getContentAsString());
		
		assertFalse(result.getResponse().getContentAsString().contains("<html><body>"
				+ "<h1>We have run into an error!!</h1><br> <h3>Your Flightname/class is not present in our database.<br>Please check your flightname/class again</h3>"
				+ "</body></html>"));
		
		
		

	}
	
	
	@Test
	public void testMethod() throws Exception{
		ProductFare mockFlight=new ProductFare();
		String flightname="abc12";
		String classf="eco";
		PassengerRepositoryFareImpl newrepo = new PassengerRepositoryFareImpl();
		int a=newrepo.calcFuelCost(mockFlight);
		int b=newrepo.addExpense(mockFlight);
		int c=newrepo.perSeatCalc(mockFlight);
		
		
	}
	private ProductFare getUserInfo1() {
		ProductFare user = new ProductFare();
		user.setFlightname("abc14");
		user.setSrc("CHN");
		user.setDes("DEL");
		user.setClassf("eco");
		user.setKms(1756);
		user.setDuration(2);
		user.setFuelprice(40000);
		user.setMaintanencecharges(10000);
		user.setFoodbeverages(9000);
		user.setCapacity(256);
		user.setTechnicalexp(20000);
		user.setMiscellaneous(5000);
		user.setSplday(true);
		return user;

	}
	private ProductFare getUserInfo2() {
		ProductFare user = new ProductFare("abc123","eco",2,40000,10000,9000,256,20000,5000);
		
		return user;

	}
}