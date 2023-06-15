import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.http.HttpMethod;
import org.eclipse.jetty.server.*;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.jetty.server.handler.ContextHandler.Context;
import org.eclipse.jetty.servlet.*;

import java.io.IOException;
import java.io.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.internal.LinkedTreeMap;

public class MyHttpServer {
	public void start() throws Exception {
		List<Server> serverList = new ArrayList<Server>();
		File[] files = new File("./").listFiles();
		for(File f : files) {
			if(f.getName().startsWith("Proxy-") && f.getName().endsWith(".json"))
			{
				try {
					JsonElement element = JsonParser.parseReader(new FileReader(f.getPath()));
					Server server = new Server();
					ServerConnector http = new ServerConnector(server);		
					http.setHost("127.0.0.1");	
					http.setPort(element.getAsJsonObject().get("port").getAsInt());
					server.addConnector(http);
					
					ServletContextHandler context = new ServletContextHandler();
					
					context.setAttribute("proxy.routes", element.getAsJsonObject().get("routes"));
					context.setAttribute("proxy.name", f.getName().split("[.]"));
					context.addServlet(MyServlet.class, "/");///mypath");//new MyServlet().serialParam);
					server.setHandler(context);
					
					server.start();
					serverList.add(server);
				} catch(JsonIOException e) {
					e.printStackTrace();
				} catch(JsonSyntaxException e) {
					e.printStackTrace();
				} catch(FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
		for(Server server:serverList) {
			server.join();
		}
	}
}
