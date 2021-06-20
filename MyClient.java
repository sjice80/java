//package test;

import org.eclipse.jetty.client.*;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.http.*;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class MyClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		HttpClient httpClient = new HttpClient();
		httpClient.start();
//		ContentResponse contentRes = httpClient.newRequest("http://127.0.0.1:8080/account/3").method(HttpMethod.HEAD).send();
		ContentResponse contentRes2 = httpClient.newRequest("http://127.0.0.1:8080/account/3").method(HttpMethod.GET).send();
//		System.out.println(contentRes.getContentAsString());
//		httpClient.stop();
	}

}
