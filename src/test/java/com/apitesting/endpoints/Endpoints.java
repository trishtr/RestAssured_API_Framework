package com.apitesting.endpoints;

import com.apitesting.utilities.ReadConfig;

public class Endpoints {
	
	public static ReadConfig rc = new ReadConfig();
	
	public final String base_URI = "https://reqres.in/api";
	public final String get_all_users_baseURI = "/users?page={pagenumber}";
	public final String get_single_user_baseURI = "/users/{userid}";
	public final String post_users_baseURI = "/users";
	public final String patch_users_baseURI = "/users/{userid}";
	public final String delete_users_baseURI = "/users/{userid}";
	public final String login_URI = "/login";
	
	

}
