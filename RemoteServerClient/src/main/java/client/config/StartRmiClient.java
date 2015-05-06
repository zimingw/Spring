package client.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import server.interfaces.HelloWorldService;

public class StartRmiClient {


	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(client.config.ClientConfig.class);
		System.out.println("Calling server for " + args[0]);
		
		HelloWorldService helloWorldService = (HelloWorldService)context.getBean("HelloWorldClient");
		String result = helloWorldService.getMessage(args[0]);
		System.out.println(result);			

	}

}
