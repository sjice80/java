//package test;

import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.http.HttpMethod;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.*;

public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public String serialParam = "";
	public String[] url = null;
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {		
		BufferedReader br = new BufferedReader(new FileReader("./SERVICE/CUSTOMER.TXT"));
		String s = "";
		ArrayList<String> keylist = new ArrayList<String>();
		while((s=br.readLine())!=null) {
			keylist.add(s);
		}		
		res.setStatus(200);        
        for (Enumeration<String> e = req.getHeaderNames(); 
                e.hasMoreElements();) {
            String name = e.nextElement();
//            System.out.println(name+", "+req.getHeader(name));
            if(keylist.contains(name)) {
            	break;
            }
        }
//		System.out.println(req.getRequestURI());
		serialParam = req.getRequestURI();
		String result = "";
		BufferedReader br_service = new BufferedReader(new FileReader("./SERVICE/REGISTRY.TXT"));
		String service_str = "";
		
		ArrayList<String> serlist = new ArrayList<String>();
		while((service_str=br_service.readLine())!=null) {
			serlist.add(service_str);
			String ser_name = service_str.split("#")[0];
			if(serialParam.split("/")[1].equals(ser_name)) {
				url = service_str.split("#")[2].split(";");
				break;
			}
		}
		HttpClient httpClient = new HttpClient();
		
		try {
			httpClient.start();
			ContentResponse contentRes = httpClient.newRequest(url[0]+serialParam).method(HttpMethod.GET).send();
			System.out.println(contentRes.getContentAsString());	// mock(MyServlet2 res.getWriter().write(json);)에서 받은값 출력
			JsonElement jsonElement = JsonParser.parseString(contentRes.getContentAsString());
			result += jsonElement.toString() + "\n";
//			res.getWriter().write(result);

			// http://127.0.0.1:8081/account/3 보내고 응답 저장 
			// http://127.0.0.1:8082/account/3 보내고 응답 저장 
			// http://127.0.0.1:8083/account/3 보내고 응답 저장
			/*
			for (int i = 0; i < url.length; i++) {
				ContentResponse contentRes = httpClient.newRequest(url[i]+serialParam).method(HttpMethod.GET).send();
				JsonElement jsonElement = JsonParser.parseString(contentRes.getContentAsString());
				result += jsonElement.toString() + "\n";
				res.getWriter().write(result);

				System.out.println(url[i]+serialParam);
				System.out.println(result);
			}
			*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
//		System.out.println(url[0]);
//		res.getWriter().write("test!!");
		
	}
}
