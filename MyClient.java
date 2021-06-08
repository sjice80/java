//package test;

import org.eclipse.jetty.client.*;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.http.*;

public class MyClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		HttpClient httpClient = new HttpClient();
		httpClient.start();
		ContentResponse contentRes = httpClient.newRequest("http://127.0.0.1:8080/mypath").method(HttpMethod.GET).send();
		System.out.println(contentRes.getContentAsString());
		
//		ContentResponse contentResPost = httpClient.newRequest("http://127.0.0.1:8080/mypath").method(HttpMethod.POST).send();
		ContentResponse contentResPost = httpClient.newRequest("http://127.0.0.1:8080/mypath").method(HttpMethod.POST).param("hike", "Perl").send();
		ContentResponse contentResDel = httpClient.newRequest("http://127.0.0.1:8080/mypath").method(HttpMethod.DELETE).param("hike", "South Maroon Peak").send();
		System.out.println(contentResPost.getContentAsString());
		System.out.println(contentResDel.getContentAsString());
//		System.out.println(httpClient.newRequest("http://127.0.0.1:8080/mypath").method(HttpMethod.POST).getParams());

	}

}
