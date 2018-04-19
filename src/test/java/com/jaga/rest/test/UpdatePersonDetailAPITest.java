package com.jaga.rest.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.jaga.rest.responsepojo.UpdatePersonDetailResponse;
import com.jaga.rest.service.Service;

/**
 * 
 * @author Jagatheshwaran
 * @since 11/4/2018
 *
 */
class UpdatePersonDetailAPITest extends BaseClass {

	String name;
	String surname;
	String city;
	String landmark;
	String state;
	String zipcode;

	@BeforeClass
	public void dataSetup() {
		name = "John";
		surname = "Blake";
		city = "New York";
		landmark = "Cross Mount";
		state = "New York";
		zipcode = "10001";

	}

	@Test
	public void updatePersonDetailAPITest() {
		service = new Service();
		response = service.updatePesonDetailAPI(name, surname, city, landmark, state, zipcode);

		if (response.getStatusCode() == 200) {

			System.out.println(response.asString());
			Gson gson = new Gson();

			UpdatePersonDetailResponse updatePersonDetailResponse = gson.fromJson(response.asString(),
					UpdatePersonDetailResponse.class);

			Assert.assertEquals(updatePersonDetailResponse.getResponse().get(0).getName(), "John");
			Assert.assertEquals(updatePersonDetailResponse.getResponse().get(0).getSurname(), "Blake");
			Assert.assertEquals(updatePersonDetailResponse.getResponse().get(0).getAddress().getCity(), "New York");
			Assert.assertEquals(updatePersonDetailResponse.getResponse().get(0).getAddress().getLandmark(),"Cross Mount");
			Assert.assertEquals(updatePersonDetailResponse.getResponse().get(0).getAddress().getState(), "New York");
			Assert.assertEquals(updatePersonDetailResponse.getResponse().get(0).getAddress().getZipcode(), "10001");
		} else {
			Assert.assertTrue(false, response.asString());
		}
	}

}
