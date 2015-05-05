package server.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.remoting.rmi.RmiServiceExporter;

import server.components.*;
import server.interfaces.*;

@Configuration
@ComponentScan(basePackageClasses={HelloWorldComponent.class})
public class ServerConfig{

	@Bean(name="HelloWorldServiceBean")
	public HelloWorldService helloWorldService()
	{
		return new HelloWorldComponent();
	}
	
	@Bean
	public RmiServiceExporter rmiExporter(HelloWorldService helloWorldService)
	{
		RmiServiceExporter rmiExporter = new RmiServiceExporter();
		rmiExporter.setService(helloWorldService);
		rmiExporter.setServiceName("HelloWorldService");
		rmiExporter.setServiceInterface(HelloWorldService.class);
		return rmiExporter;
	}
	
}
