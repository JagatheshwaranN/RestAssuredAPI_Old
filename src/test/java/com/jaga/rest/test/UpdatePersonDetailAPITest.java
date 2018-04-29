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
 * @modified 29/4/2018
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
		name = BaseClass.getTestData("NewName");
		surname = BaseClass.getTestData("NewSurName");
		city = BaseClass.getTestData("City");
		landmark = BaseClass.getTestData("LandMark");
		state = BaseClass.getTestData("State");
		zipcode = BaseClass.getTestData("ZipCode");

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

			Assert.assertEquals(updatePersonDetailResponse.getResponse().get(0).getName(), BaseClass.getTestData("NewName"));
			Assert.assertEquals(updatePersonDetailResponse.getResponse().get(0).getSurname(), BaseClass.getTestData("NewSurName"));
			Assert.assertEquals(updatePersonDetailResponse.getResponse().get(0).getAddress().getCity(), BaseClass.getTestData("City"));
			Assert.assertEquals(updatePersonDetailResponse.getResponse().get(0).getAddress().getLandmark(),BaseClass.getTestData("LandMark"));
			Assert.assertEquals(updatePersonDetailResponse.getResponse().get(0).getAddress().getState(), BaseClass.getTestData("State"));
			Assert.assertEquals(updatePersonDetailResponse.getResponse().get(0).getAddress().getZipcode(), BaseClass.getTestData("ZipCode"));
		} else {
			Assert.assertTrue(false, response.asString());
		}
	}

}
