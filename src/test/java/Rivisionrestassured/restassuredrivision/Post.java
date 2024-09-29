package Rivisionrestassured.restassuredrivision;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Post {
	@DataProvider(name="postdata")
	public Object[][] objData(){
		return new Object[][] {
			{"{\r\n"
					+ "    \"name\": \"Divya\",\r\n"
					+ "    \"job\": \"Pandey\"\r\n"
					+ "}"},
			{"{\r\n"
					+ "    \"name\": \"Harsh\",\r\n"
					+ "    \"job\": \"Kumar\"\r\n"
					+ "}"},
			{"{\r\n"
					+ "    \"name\": \"Himanshu\",\r\n"
					+ "    \"job\": \"Pandey\"\r\n"
					+ "}"}
		};
	}
	@Test(dataProvider="postdata")
	public void post(String s) {
		RestAssured.baseURI= "https://reqres.in/";
		Response r= RestAssured.given().header("Content-Type","application/json").body(s).post("api/users");
		//System.out.println(r.asPrettyString());
		String i= r.path("id");
		String name= r.path("name");
		int i1= r.getStatusCode();
		//System.out.println(i1);
		System.out.println("ID: "+ i+ " Name: "+name+ " Status Code: " +i1);
	}

}
