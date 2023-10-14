package com.Api;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class LibraryAPITest {
	
	 @BeforeClass
	    public void setUp() {
	        // Set the base URL for the API
	        RestAssured.baseURI = "https://reqres.in/api/users";
	    }

	    @Test
	    public void testUpdateUser() {
	        int userId = 2;

	        // Defining the request body (JSON)
	        String requestBody = "{ \"name\": \"API Demo\", \"job\": \"API Tester\" }";

	        // Send the PUT request
	        Response response = RestAssured.given()
	                .contentType(ContentType.JSON)
	                .body(requestBody)
	                .put("/" + userId);

	        // Assertion
	        response.then()
	                .statusCode(200);
	    }

	 @Test
	    public void testGetUser() {
	        RestAssured.baseURI = "https://reqres.in/api/users";

	        given()
	            .when()
	            .get("/2")
	            .then()
	            .statusCode(200)
	            .body("data.id", equalTo(2))
	            .body("data.email", equalTo("janet.weaver@reqres.in"))
	            .body("data.first_name", equalTo("Janet"))
	            .body("data.last_name", equalTo("Weaver"));
	    }
	 
	  
}
