package Rivisionrestassured.restassuredrivision;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Get {
	@Test
	public void get() {
		RestAssured.baseURI= "https://reqres.in/";
		Response r= RestAssured.given().get("api/users/2");
		System.out.println(r.asPrettyString());
		int i=r.path("data.id");
		System.out.println(i);
	}
}