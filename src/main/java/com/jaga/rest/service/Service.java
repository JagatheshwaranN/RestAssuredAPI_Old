package com.jaga.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.jaga.rest.requestpojo.Address;
import com.jaga.rest.requestpojo.CreatePerson;
import com.jaga.rest.requestpojo.UpdatePersonDetail;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

/**
 * 
 * @author Jagatheshwaran
 * @since 6/4/2018
 * @Modified 9/4/2018
 *
 */
public class Service {
	List<JSONObject> jsonList;

	public Response createPersonAPI(String name, String surname, String city, String landmark, String state,
			String zipcode) {
		CreatePerson createPerson = new CreatePerson();
		createPerson.setName(name);
		createPerson.setSurname(surname);

		Address address = new Address();
		createPerson.setAddress(address);
		address.setCity(city);
		address.setLandmark(landmark);
		address.setState(state);
		address.setZipcode(zipcode);

		JSONObject jsonObject = new JSONObject(createPerson);
		System.out.println("json payload details");
		jsonList = new ArrayList<JSONObject>();
		jsonList.add(jsonObject);
		System.out.println("Json PayLoad in List : " + jsonList);

		RequestSpecification request = RestAssured.given();
		request.contentType("application/json");
		request.accept("application/json");
		request.body(jsonList.toString());
		System.out.println("Service end point url : " + ServiceUrl.createPersonUrl);
		Response response = request.post(ServiceUrl.createPersonUrl);
		return response;

	}

	public Response updatePesonDetailAPI(String name, String surname, String city, String landmark, String state,
			String zipcode) {
		UpdatePersonDetail updatePersonDetail = new UpdatePersonDetail();
		updatePersonDetail.setName(name);
		updatePersonDetail.setSurname(surname);

		Address address = new Address();
		updatePersonDetail.setAddress(address);
		address.setCity(city);
		address.setLandmark(landmark);
		address.setState(state);
		address.setZipcode(zipcode);

		JSONObject jsonObject = new JSONObject(updatePersonDetail);
		System.out.println("json payload details");
		jsonList = new ArrayList<JSONObject>();
		jsonList.add(jsonObject);
		System.out.println("Json PayLoad in List : " + jsonList);

		RequestSpecification request = RestAssured.given();
		request.contentType("application/json");
		request.accept("application/json");
		request.body(jsonList.toString());
		System.out.println("Service end point url : " + ServiceUrl.updatePesronDetailUrl);
		Response response = request.put(ServiceUrl.updatePesronDetailUrl);
		return response;

	}

	public Response getSateDetails() {
		RequestSpecification request = RestAssured.given();
		request.contentType("application/json");
		request.accept("application/json");
		System.out.println("Service end point url : " + ServiceUrl.getStateDetailUrl);
		Response response = request.get(ServiceUrl.getStateDetailUrl);
		return response;

	}

}
