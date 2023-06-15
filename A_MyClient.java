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
}
