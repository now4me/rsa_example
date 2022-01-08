package my.practice.rsa;

import java.io.File;
import java.io.FilenameFilter;

import org.apache.commons.codec.binary.Hex;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import my.practice.rsa.loader.ConfigLoader;
import my.practice.rsa.util.RsaCommonUtil;
import my.practice.rsa.util.RsaKeyUtil;

public class Main {

	private static final ConfigLoader configLoader = ConfigLoader.getInstance();
	
	private static final Logger log = Logger.getLogger(Main.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		PropertyConfigurator.configureAndWatch(configLoader.getConfigValue("path", "logPropertyFile"));
		
		log.debug("RSA Example !!!");
			
		try {
			
			byte[] randomKey = RsaCommonUtil.getRandomKey();
			log.debug("Random Key : " + Hex.encodeHexString(randomKey));
			
			byte[] encodedRandomKey = RsaKeyUtil.encByPublicKey(randomKey);
			log.debug("RSA Encoded Random Key : "+ Hex.encodeHexString(encodedRandomKey) );
		
			for (File file : new File("./trdata/").listFiles( new FilenameFilter() {
				public boolean accept(File dir, String name) {
					return name.startsWith("J534")&& !(name.endsWith(".enc")) && !(name.endsWith(".dec"));
				}
			})) {
				log.debug("=======================");
				log.debug("File Name : " + file.getName());
				log.debug("     Size : " + file.length());
				log.debug("     CRC32: " + RsaCommonUtil.getCrc32(file));
				
			}
			
			log.debug(Long.toHexString(123));
			log.debug(Long.toHexString(0123));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
