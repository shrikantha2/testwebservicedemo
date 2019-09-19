package com.abc.employeetestcae;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.abc.employeebase.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;


public class TestToGetAllEmployee  extends   TestBase {
	
	@BeforeClass
	void getEmployees() throws InterruptedException
	{
		logger.info("test started to get employee detail---");
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/";
		
		  httpRequest= RestAssured.given();
		  /*
		 * .header("x-rapidapi-host",
		 * "community-open-weather-map.p.rapidapi.com") .header("x-rapidapi-key",
		 * "648b6debaemsh8f5cc993da9a0a4p1aea91jsnec9359c69877");
		 */
		//httpRequest= RestAssured.given().param("api_account_id", "5ae784ebac69e70e142d8cb8").	
		
		response =httpRequest.request(Method.GET,"employees");
		
		Thread.sleep(3000);
		
		
	}
	
	@Test
	void checkResponse()
	{
		logger.info("checking response");
		String responseBody=response.getBody().asString();
		logger.info(responseBody);
		
		
		Assert.assertTrue(responseBody !=null);
	}
	
	@Test
	void checkStatus()
	{
		
		logger.info("checking status "+response.getStatusCode());
		int statusCode= response.getStatusCode();
		Assert.assertEquals(statusCode,200);
	}
	
	@Test
	void checkResponseTime()
	{
		logger.info("---Response time verification started --");
		long responseTime=response.getTime();
		logger.info("response time is ==>"+responseTime);
		
		
		if(responseTime>2000)
		{
			logger.warn("server response is greated than 2000 ");
			
			
		}
		
		Assert.assertTrue(responseTime<2000);
		
		
	}
	
	@Test
	void checkStatusLine()
	{
		logger.info("checking status line ");
		String statusLine=response.getStatusLine();
		Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");
		
	}
	
	

}
