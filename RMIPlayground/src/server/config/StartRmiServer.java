package server.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StartRmiServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new AnnotationConfigApplicationContext(server.config.ServerConfig.class);
		System.out.println("Waiting for client to call...");
		
	}

}
