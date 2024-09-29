package Rivisionrestassured.restassuredrivision;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Patch {
	@DataProvider(name ="patchData")
	public Object[][] patchData(){
		return new Object[][] {
			{"{\r\n"
					+ "    \"name\": \"morpheus\",\r\n"
					+ "    \"job\": \"zion resident\"\r\n"
					+ "}"}
		};
	}
	@Test(dataProvider="patchData")
	public void patch(String data) {
		RestAssured.baseURI="https://reqres.in/";
		Response r=RestAssured.given().header("Content-Type","application/json").body(data).patch("/api/users/2");
		System.out.println(r.asPrettyString());
		int statusCode=r.getStatusCode();
		System.out.println(statusCode);
	}
}
