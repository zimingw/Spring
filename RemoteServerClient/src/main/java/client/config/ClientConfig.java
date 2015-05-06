package client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

import server.interfaces.HelloWorldService;

@Configuration
public class ClientConfig {
	@Bean(name="HelloWorldClient")
	public RmiProxyFactoryBean helloWorldClient(){
		RmiProxyFactoryBean rmiProxy = new RmiProxyFactoryBean();
		rmiProxy.setServiceUrl("rmi://localhost/HelloWorldService");
		rmiProxy.setServiceInterface(HelloWorldService.class);
		return rmiProxy;
	}
}
