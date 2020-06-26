package com.study.EmbeddedJettySpringExample.server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Hello world!
 *
 */
public class App  {
	
	private static final String CONTEXT_PATH = "/";
	private static final String MAPPING_URL = "/*";
	private static final int DEFAULT_PORT = 8098;
	
	private static final Logger logger = LoggerFactory.getLogger(App.class);
	
    public static void main( String[] args ) throws Exception {
    	Server server = new Server();
    	
    	ServerConnector http = new ServerConnector(server);
    	http.setHost("localhost");
        http.setPort(getPortFromArgs(args));
        http.setIdleTimeout(30000);
    	
    	XmlWebApplicationContext context = new XmlWebApplicationContext();
		
		ServletContextHandler contextHandler = new ServletContextHandler();
		contextHandler.setErrorHandler(null);
		contextHandler.setContextPath(CONTEXT_PATH);
		
		DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
		dispatcherServlet.setContextConfigLocation("classpath:applicationContext.xml");
		
		contextHandler.addServlet(new ServletHolder(dispatcherServlet), MAPPING_URL);
		contextHandler.addEventListener(new ContextLoaderListener(context));
		contextHandler.setResourceBase(new ClassPathResource("webapp").getURI().toString());
		
		server.addConnector(http);
		
		server.setHandler(contextHandler);
		
		server.start();
		server.join();
    }
    
    private static int getPortFromArgs(String[] args) {
		if (args.length > 0) {
			try {
				return Integer.valueOf(args[0]);
			} catch (NumberFormatException ignore) {
				// do nothing
			}
		}
		logger.debug("No server port configured, falling back to {}", DEFAULT_PORT);
		return DEFAULT_PORT;
	}
}
