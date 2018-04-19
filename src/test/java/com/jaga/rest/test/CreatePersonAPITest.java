package com.jaga.rest.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.jaga.rest.responsepojo.CreatePersonResponse;
import com.jaga.rest.service.Service;

/**
 * 
 * @author Jagatheshwaran
 * @since 10/4/2018
 *
 */
class CreatePersonAPITest extends BaseClass {

	String name;
	String surname;
	String city;
	String landmark;
	String state;
	String zipcode;

	@BeforeClass
	public void dataSetup() {
		name = "Will";
		surname = "Smith";
		city = "New York";
		landmark = "Cross Mount";
		state = "New York";
		zipcode = "10001";

	}

	@Test
	public void createPersonAPITest() {
		service = new Service();
		response = service.createPersonAPI(name, surname, city, landmark, state, zipcode);

		if (response.getStatusCode() == 200) {

			System.out.println(response.asString());
			Gson gson = new Gson();

			CreatePersonResponse createPersonResponse = gson.fromJson(response.asString(), CreatePersonResponse.class);

			Assert.assertEquals(createPersonResponse.getResponse().get(0).getName(), "Will");
			Assert.assertEquals(createPersonResponse.getResponse().get(0).getSurname(), "Smith");
			Assert.assertEquals(createPersonResponse.getResponse().get(0).getAddress().getCity(), "New York");
			Assert.assertEquals(createPersonResponse.getResponse().get(0).getAddress().getLandmark(), "Cross Mount");
			Assert.assertEquals(createPersonResponse.getResponse().get(0).getAddress().getState(), "New York");
			Assert.assertEquals(createPersonResponse.getResponse().get(0).getAddress().getZipcode(), "10001");
		} else {
			Assert.assertTrue(false, response.asString());
		}
	}

}
