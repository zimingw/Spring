package server.components;

import server.interfaces.HelloWorldService;
import org.springframework.stereotype.Component;

public class HelloWorldComponent implements HelloWorldService {

	@Override
	public String getMessage(String name) {
		// TODO Auto-generated method stub
		System.out.println("Service called by " + name);
		return "Hello World " + name;
	}

}
