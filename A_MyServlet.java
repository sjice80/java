//package test;

import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.nio.file.Files;
import java.time.LocalTime;
import java.util.Date;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.http.HttpMethod;

import com.google.gson.*; //Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import com.google.gson.JsonParser;




public class MyServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	public String serialParam = "";
	public String[] url = null;
	private JsonArray jsonRoutes;
	private String proxyName;
	private MyClient myClient;
	
	public void init() throws ServletException
	{
		this.jsonRoutes = (JsonArray)getServletContext().getAttribute("proxy.routes");
		this.proxyName = (String)getServletContext().getAttribute("proxy.name");
		this.myClient = new MyClient();
		System.out.println(this.jsonRoutes);
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {	
        System.out.println("Request : "+ req.getRequestURL());
        String redirectUrl = "";

        res.setStatus(200);
        
        if(!req.getRequestURI().contains("favicon.ico")) {
        	for(JsonElement route:jsonRoutes) 
        	{
        		String path = route.getAsJsonObject().get("pathPrefix").getAsString();
        		if(req.getRequestURI().startsWith(path))
        		{
        			String url = route.getAsJsonObject().get("url").getAsString();
        			redirectUrl = url + req.getRequestURI();
        			String query = req.getQueryString();
        			if(query!=null)            		
        				redirectUrl = redirectUrl+"?"+query;
        			    		
	        		String resContents = myClient.sendRequest(redirectUrl, "GET", null);
	        		res.getWriter().write(resContents);
	        		System.out.println(resContents);
	        		break;
        		}
        	}
        }

       
/*
		res.setStatus(200);  
  	  	JsonObject json2 = new JsonObject();
	    // put some value pairs into the JSON object .
	    json2.addProperty("Mobile", 999998888);
	    json2.addProperty("Name", "ManojSarnaik");    	
		String json = new Gson().toJson(json2);
		res.setContentType("application/json");
		res.setCharacterEncoding("UTF-8");
		res.getWriter().write(json);
		*/
	/*
		BufferedReader br = new BufferedReader(new FileReader("./SERVICE/CUSTOMER.TXT"));
		String s = "";
//		System.out.println("Hello 4\n");
		ArrayList<String> keylist = new ArrayList<String>();
		while((s=br.readLine())!=null) {
//			System.out.println(s);
			keylist.add(s);
		}		
		res.setStatus(200); 
//		res.getWriter().write("Hello\n");
		
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
			System.out.println(service_str);
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
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	*/
//		System.out.println(url[0]);
//		res.getWriter().write("test!!");
		
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("Request : "+ req.getRequestURL());
        String redirectUrl = "";
        String data = "";
        if(!req.getRequestURI().contains("favicon.ico")) {
        	for(JsonElement route:jsonRoutes) {
        		String path = route.getAsJsonObject().get("pathPrefix").getAsString();
        		if(req.getRequestURI().startsWith(path))
        		{
        			String url = route.getAsJsonObject().get("url").getAsString();
        			redirectUrl = url + path;
        			StringBuilder buffer = new StringBuilder();
        			BufferedReader reader = req.getReader();
        			String line;
        			while((line = reader.readLine()) != null) {
        				buffer.append(line);
        				buffer.append(System.lineSeparator());
        			}
        			data = buffer.toString();
        			
        		}
        		String resContents = myClient.sendRequest(redirectUrl, "POST", data);
        		res.getWriter().write(resContents);
        		System.out.println(resContents);
        		break;
        	}
        }
        
        // Client로부터 전달된 json data 저장
        if (req.getRequestURI().equals("/fileList")) {
            File destFolder = new File("./OUTPUT");
            if(!destFolder.exists()) {
                destFolder.mkdirs(); 
            }
            LocalTime currentTime = LocalTime.now();
            String fname = String.format("./OUTPUT/%02d%02d%02d.json", currentTime.getHour(), currentTime.getMinute(), currentTime.getSecond());
            PrintWriter printWriter = new PrintWriter(new FileWriter(new File(fname)));
            BufferedReader input = new BufferedReader(new InputStreamReader(req.getInputStream()));
            String buffer;
            while ((buffer = input.readLine()) != null) {
                printWriter.print(buffer);
            } 
            input.close(); 
            printWriter.close();
            res.setStatus(200);
            res.getWriter().write(fname + " saved!");
        }
		else if (req.getRequestURI().equals("/fileList2")) {
	        Gson gson = new Gson();	
	        System.out.println("Request : "+ req.getRequestURL());	
	        ////////////////////////////////////////////////	
	        File destFolder = new File("./SERVER");	
	        if(!destFolder.exists()) {
	            destFolder.mkdirs(); 
	        }
	        BufferedReader input = new BufferedReader(new InputStreamReader(req.getInputStream()));	
	        String buffer;	
	        StringBuilder sb = new StringBuilder();	
	        while ((buffer = input.readLine()) != null) {	
	            sb.append(buffer + "\n");	
	        }	
	        String strBody = sb.toString();	
	        input.close(); 
	
	        JsonObject jObj = gson.fromJson(strBody, JsonObject.class);	
	        String fileName = jObj.get("FileName").getAsString();	
	        String fileContent = jObj.get("FileContent").getAsString();	
	        PrintWriter printWriter = new PrintWriter(new FileWriter(new File("./SERVER/"+fileName)));	
	        printWriter.print(fileContent);	
	        printWriter.close();	
	        /////////////////////////////////////////////////
	        res.setStatus(200);	
	        res.getWriter().write(fileName + " saved!"); 	
	    }     
	}
}
