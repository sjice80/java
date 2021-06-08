//package test;

import org.eclipse.jetty.server.*;
import org.eclipse.jetty.servlet.ServletHandler;

public class MyServer {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		System.out.println("Hello World");
		new MyServer().start();
	}

	public void start() throws Exception {
		Server server = new Server();
		ServerConnector http = new ServerConnector(server);
		
		http.setHost("127.0.0.1");
//		http.setHost("0.0.0.0");
		
		http.setPort(8080);
//		System.out.println(server.getURI());
		server.addConnector(http);
		
		ServletHandler servletHandler = new ServletHandler();
		servletHandler.addServletWithMapping(MyServlet.class, "/mypath");
		
		server.setHandler(servletHandler);
		
		server.start();
		server.join();
		
	}
	
}
