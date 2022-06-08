package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils {
	
	public static Properties prop;
	public static FileInputStream fs;
	public static RequestSpecification req;
	
	public static RequestSpecification requestSpec() throws IOException
	{
		
		fs = new FileInputStream("F:\\FinalAPIREstAssuredProject\\FinalPracticeCucumberAPI\\src\\test\\java\\resources\\config.properties");
	    prop = new Properties();
	    prop.load(fs);
	    
		if(req==null)
		{
		PrintStream ps = new PrintStream(new FileOutputStream("loggingAPI.txt"));
		
		RequestSpecBuilder reqspec = new RequestSpecBuilder().setContentType(ContentType.JSON)
				.setBaseUri(prop.getProperty("baseurl")).addFilter(RequestLoggingFilter.logRequestTo(ps)).
				addFilter(ResponseLoggingFilter.logResponseTo(ps));
		 req = reqspec.build();
		 return req;
		}
		return req;
	}
	
	public static ResponseSpecification responseSpec()
	{
		ResponseSpecBuilder respspec = new ResponseSpecBuilder().expectStatusCode(200).
				expectContentType(ContentType.JSON);
		
		ResponseSpecification resp = respspec.build();
		
		return resp;
	}
	
	
	public String getJsonPath(Response response, String key)
	{
		
		JsonPath js = new JsonPath(response.asString());
		String responseval = js.get(key);
		return responseval;
	}


}
