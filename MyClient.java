//package test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import org.eclipse.jetty.client.*;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.util.StringContentProvider;
import org.eclipse.jetty.http.*;
import org.eclipse.jetty.util.ssl.SslContextFactory;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import com.google.gson.JsonParser;

public class MyClient {
	private HttpClient httpClient;
	public MyClient() {
		SslContextFactory.Client sslClient = new SslContextFactory.Client();
		httpClient = new HttpClient(sslClient);
		httpClient.setFollowRedirects(false);
		try {
			httpClient.start();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public String sendRequest(String url, String method, String body) {
		ContentResponse contentRes;
		HttpMethod httpMethod = HttpMethod.fromString(method);
		try {
			contentRes = httpClient.newRequest(url).method(httpMethod).send();
			String result = contentRes.getContentAsString();
			return result;
		} catch(InterruptedException e) {
			e.printStackTrace();
		} catch(TimeoutException e) {
			e.printStackTrace();
		} catch(ExecutionException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		HttpClient httpClient = new HttpClient();
		httpClient.start();
		/*
		do {
		    HttpRequest request =
		        (HttpRequest)
		            httpClient
		                .newRequest("http://localhost:8080/helloworld/request")
		                .method(HttpMethod.GET);
		    HttpRequest asyncRequest =
		        (HttpRequest)
		            httpClient
		                .newRequest("http://localhost:8080/helloworld/request/async")
		                .method(HttpMethod.GET);
		    HttpRequest postRequest =
		        (HttpRequest)
		            httpClient
		                .newRequest("http://localhost:8080/helloworld/request")
		                .method(HttpMethod.POST);
		    postRequest.content(new StringContentProvider("{\"hello\": \"world\"}"), "application/json");

		    if (request == null) {
		      System.out.println("Request is null");
		      break;
		    }

		    ContentResponse contentRes = request.send();
		    String resStr = contentRes.getContentAsString();
		    JsonObject json2 = new JsonObject();
		    asyncRequest.send();
		    postRequest.send();
		    try {
		      Thread.sleep(15000);
		    } catch (Exception e) {
		    	System.out.println("Error while sleeping");
		    }
		  } while (true);
		*/
		
		ContentResponse contentRes = httpClient.newRequest("http://127.0.0.1:8088/requestDate").method(HttpMethod.GET).send();
//		ContentResponse contentRes2 = httpClient.newRequest("http://127.0.0.1:8080/account/3").method(HttpMethod.GET).send();
		System.out.println(contentRes.getContentAsString());
		httpClient.stop();
		
	}

}
