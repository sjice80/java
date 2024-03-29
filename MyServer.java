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

public class MyServer {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		new MyServer().start();		
	}

	public void start() throws Exception {
		Server server = new Server();
		ServerConnector http = new ServerConnector(server);
		
		http.setHost("127.0.0.1");
		
		http.setPort(8080);
		server.addConnector(http);
		ServletHandler servletHandler = new ServletHandler();
		servletHandler.addServletWithMapping(MyServlet.class, "/");///mypath");//new MyServlet().serialParam);
		server.setHandler(servletHandler);
		
		server.start();
		server.join();
	}
	
}