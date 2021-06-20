//package test;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.http.HttpMethod;
import org.eclipse.jetty.server.*;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.jetty.server.handler.ContextHandler.Context;
import org.eclipse.jetty.servlet.ServletHandler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.internal.LinkedTreeMap;

public class MyServer2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		new MyServer2().start();		
	}

	public void start() throws Exception {

		Server server2 = new Server();
		ServerConnector http2 = new ServerConnector(server2);
		
		http2.setHost("127.0.0.1");
		
		http2.setPort(8081);
		server2.addConnector(http2);
		ServletHandler servletHandler2 = new ServletHandler();
		servletHandler2.addServletWithMapping(MyServlet2.class, "/");///mypath");//new MyServlet().serialParam);
		server2.setHandler(servletHandler2);
		
		server2.start();
		server2.join();
	}
	
}