package my.practice.rsa.util;

import java.io.File;
import java.security.SecureRandom;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

public class RsaCommonUtil {

	private static final Logger log = Logger.getLogger(RsaCommonUtil.class);
	
	public static byte[] getRandomKey() throws Exception {
		SecureRandom sr = new SecureRandom();
		byte[] rand = new byte[32];
		sr.nextBytes(rand);
		
		return rand;
	}
	
	public static String getCrc32(File file) throws Exception {
		
		log.debug("crc long -> " + FileUtils.checksumCRC32(file));
		return Long.toHexString(FileUtils.checksumCRC32(file));
		
	}
	
	
	
}
