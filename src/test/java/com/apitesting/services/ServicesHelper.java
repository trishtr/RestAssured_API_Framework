package com.apitesting.services;

import com.apitesting.endpoints.Endpoints;
import com.apitesting.payload.LoginPayload;
import com.apitesting.payload.Users_Pojo;
import com.apitesting.testbase.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ServicesHelper extends TestBase {

	public static Endpoints ep = new Endpoints();
	//public static Users_Pojo post_payload = new Users_Pojo("morpheus","leader");
	//public static Users_Pojo patch_payload = new Users_Pojo("morpheu","zion resident");
	
	public static Response get_All_Users(Integer pagenumber)
	{	RestAssured.baseURI = ep.base_URI;
		Response response = RestAssured.given().
				contentType(ContentType.JSON).
				pathParam("pagenumber", pagenumber).
				when().
				get(ep.get_all_users_baseURI);
		return response;
					
	}
	
	public static Response get_Single_User(Integer userid) {
		RestAssured.baseURI = ep.base_URI;
		Response response = RestAssured.given().
				contentType(ContentType.JSON).
				pathParam("userid", userid).
				when().
				get(ep.get_single_user_baseURI);
		return response;
				
	}
	
	public static Response Post_Users() {
		Users_Pojo post_payload = new Users_Pojo("morpheus","leader");
		RestAssured.baseURI = ep.base_URI;
		Response response = RestAssured.given()
				.contentType(ContentType.JSON)
				.when()
				.body(post_payload)
				.post(ep.post_users_baseURI);
		return response;
				
	}
	
	public static Response Patch_Users(Integer userid) {
		Users_Pojo patch_payload = new Users_Pojo("morpheu","zion resident");
		RestAssured.baseURI = ep.base_URI;
		Response response = RestAssured.given()
				.contentType(ContentType.JSON)
				.pathParam("userid", userid)
				.when()
				.body(patch_payload)
				.patch(ep.patch_users_baseURI);
		return response;
	}
	
	public static Response Login() {
		LoginPayload login_payload = new LoginPayload("eve.holt@reqres.in","cityslicka");
		RestAssured.baseURI = ep.base_URI;
		Response response = RestAssured.given()
				.contentType(ContentType.JSON)
				.when().body(login_payload).post(ep.login_URI);
		return response;
				
	}
}
