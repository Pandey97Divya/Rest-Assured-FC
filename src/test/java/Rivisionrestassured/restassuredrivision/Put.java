package Rivisionrestassured.restassuredrivision;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Put {
	@DataProvider(name="putdata")
	public Object[][] objData(){
		return new Object[][] {
			{"{\r\n"
					+ "    \"name\": \"morpheus\",\r\n"
					+ "    \"job\": \"zion resident\"\r\n"
					+ "}"}
		};
	}
	@Test(dataProvider= "putdata")
	public void put(String s) {
		RestAssured.baseURI= "https://reqres.in/";
		Response r= RestAssured.given().header("Content-Type","application/json").body(s).put("api/users/2");
		System.out.println(r.asPrettyString());
		int i= r.getStatusCode();
		System.out.println(i);
	}
}
