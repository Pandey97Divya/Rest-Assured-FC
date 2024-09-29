package Rivisionrestassured.restassuredrivision;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Delete {
	@Test
	public void delete() {
		RestAssured.baseURI= "https://reqres.in/";
		Response r= RestAssured.given().delete("/api/users/2");
		System.out.println(r.asPrettyString());
		int statusCode= r.getStatusCode();
		System.out.println(statusCode);
	}

}
