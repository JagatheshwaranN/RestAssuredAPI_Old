package com.jaga.rest.test;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.jaga.rest.responsepojo.GetStateDetail;
import com.jaga.rest.responsepojo.GetStateDetailResponse;
import com.jaga.rest.service.Service;

/**
 * 
 * @author Jagatheshwaran
 * @since 10/4/2018
 * @Modified 11/4/2018
 *
 */
public class GetStateDetailsAPITest extends BaseClass {

	List<Object> testData;
	List<Object> list;

	@BeforeClass
	public void dataSetup() {
		testData = new ArrayList<Object>();
		testData.add("Bihar");
		testData.add("UP");
		testData.add("karnataka");
		testData.add("Kerala");
		testData.add("tamil nadu");
		testData.add("MP");

	}

	@Test
	public void getStateDetailsAPITest() {
		service = new Service();
		response = service.getSateDetails();

		if (response.getStatusCode() == 200) {
			System.out.println(response.asString());
			Gson gson = new Gson();
			GetStateDetailResponse getStateDetailResponse = gson.fromJson(response.asString(),
					GetStateDetailResponse.class);

			List<GetStateDetail> states = getStateDetailResponse.getGetStateDetails();
			list = new ArrayList<Object>();
			for (int i = 0; i < states.size(); i++) {
				System.out.println(states.get(i).getName());
				list.add(states.get(i).getName());
			}

			Assert.assertEquals(list, testData);

		} else {
			Assert.assertTrue(false, response.asString());
		}

	}

}
