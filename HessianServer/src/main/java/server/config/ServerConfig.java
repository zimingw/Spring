package server.config;

import java.util.Properties;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.remoting.rmi.RmiServiceExporter;
import org.springframework.remoting.caucho.HessianServiceExporter;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

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
	
	@Bean
	public HessianServiceExporter hessianExportedHelloWorldService(HelloWorldService helloWorldService)
	{
		HessianServiceExporter exporter = new HessianServiceExporter();
		exporter.setService(helloWorldService);
		exporter.setServiceInterface(HelloWorldService.class);
		return exporter;
	}
	
	@Bean
	public HandlerMapping hessianMapping(){
		SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
		Properties mappings = new Properties();
		mappings.setProperty("/helloworld.service", "hessianExportedHelloWorldService");
		mapping.setMappings(mappings);
		return mapping;
	}
}
