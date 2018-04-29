package com.jaga.rest.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.jaga.rest.service.Service;
import com.jayway.restassured.response.Response;

/**
 * 
 * @author Jagatheshwaran
 * @since 10/4/2018
 * @modified 28/4/2018
 *
 */
public class BaseClass {

	public static Properties properties;
	public static File file;
	public static FileInputStream inputFile;
	public static String propertyFilePath = "//src//main//resources//PropertyFile//object.properties";

	Service service;
	Response response;

	public static String getTestData(String property) {

		properties = new Properties();
		file = new File(System.getProperty("user.dir") + propertyFilePath);
		try {
			inputFile = new FileInputStream(file);

		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		}

		try {
			properties.load(inputFile);

		} catch (IOException exception) {
			exception.printStackTrace();
		}

		String PropData = properties.getProperty(property);
		System.out.println("The Data from Property File is : " + PropData);

		try {

			String dataFromPropertyFile = PropData.trim();
			return dataFromPropertyFile;

		} catch (IllegalStateException exception) {
			exception.printStackTrace();
			return null;
		}

	}
}
