package my.practice.rsa;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import my.practice.rsa.loader.ConfigLoader;

public class Main {

	private static final ConfigLoader configLoader = ConfigLoader.getInstance();
	
	private static final Logger log = Logger.getLogger(Main.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		PropertyConfigurator.configureAndWatch(configLoader.getConfigValue("path", "logPropertyFile"));
		
		log.debug("RSA Example !!!");
			
		
	}

}
