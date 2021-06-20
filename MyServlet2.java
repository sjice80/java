import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.http.HttpMethod;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.*;

public class MyServlet2 extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {	
		res.setStatus(200);  
  	  	JsonObject json2 = new JsonObject();
	    // put some value pairs into the JSON object .
	    json2.addProperty("Mobile", 999998888);
	    json2.addProperty("Name", "ManojSarnaik");    	
		String json = new Gson().toJson(json2);
		res.setContentType("application/json");
		res.setCharacterEncoding("UTF-8");
		res.getWriter().write(json);
	}
	
}
