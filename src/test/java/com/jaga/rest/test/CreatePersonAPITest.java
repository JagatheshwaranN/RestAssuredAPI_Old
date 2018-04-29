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
 * @modified 28/4/2018
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
		name = BaseClass.getTestData("Name");
		surname = BaseClass.getTestData("SurName");
		city = BaseClass.getTestData("City");
		landmark = BaseClass.getTestData("LandMark");
		state = BaseClass.getTestData("State");
		zipcode = BaseClass.getTestData("ZipCode");

	}

	@Test
	public void createPersonAPITest() {
		service = new Service();
		response = service.createPersonAPI(name, surname, city, landmark, state, zipcode);

		if (response.getStatusCode() == 200) {

			System.out.println(response.asString());
			Gson gson = new Gson();

			CreatePersonResponse createPersonResponse = gson.fromJson(response.asString(), CreatePersonResponse.class);

			Assert.assertEquals(createPersonResponse.getResponse().get(0).getName(), BaseClass.getTestData("Name"));
			Assert.assertEquals(createPersonResponse.getResponse().get(0).getSurname(), BaseClass.getTestData("SurName"));
			Assert.assertEquals(createPersonResponse.getResponse().get(0).getAddress().getCity(), BaseClass.getTestData("City"));
			Assert.assertEquals(createPersonResponse.getResponse().get(0).getAddress().getLandmark(), BaseClass.getTestData("LandMark"));
			Assert.assertEquals(createPersonResponse.getResponse().get(0).getAddress().getState(), BaseClass.getTestData("State"));
			Assert.assertEquals(createPersonResponse.getResponse().get(0).getAddress().getZipcode(), BaseClass.getTestData("ZipCode"));
		} else {
			Assert.assertTrue(false, response.asString());
		}
	}

}
