package my.practice.rsa.util;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;

public class RsaKeyUtil {

	public static byte[] encByPublicKey(byte[] randomKey) throws Exception {
	
		// Key type = PEM (Base64)
		String key = new String(Files.readAllBytes(new File("public.key").toPath()),Charset.defaultCharset());
	
		String publicKeyPEM = key
				.replace("-----BEGIN PUBLIC KEY-----", "")
				.replaceAll(System.lineSeparator(), "")
				.replace("-----END PUBLIC KEY-----", "");
		
		byte[] encoded = Base64.decodeBase64(publicKeyPEM);
		
		// Key type = DER¿Ã∏È
		//byte[] encoded = Files.readAllBytes(Paths.get(new File("public.key").toURI()));
		
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
	    X509EncodedKeySpec keySpec = new X509EncodedKeySpec(encoded);
	    PublicKey publicKey =  keyFactory.generatePublic(keySpec);
	    
	    Cipher encCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
	    encCipher.init(Cipher.ENCRYPT_MODE, publicKey);
	    byte[] encResult = encCipher.doFinal(randomKey);
	    
	    return encResult;
			
	}
}
