package my.practice.rsa.loader;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class ConfigLoader {

	private static final ConfigLoader configLoader = new ConfigLoader();
	
	private static final Logger log = Logger.getLogger(ConfigLoader.class);
	
	private SAXBuilder oBuilder;
	private Document oDoc;
	private Element xmlRoot;
	
	public ConfigLoader() {
		try {
			this.oBuilder = new SAXBuilder();
			this.oDoc = oBuilder.build(new File("config.xml"));
			this.xmlRoot = oDoc.getRootElement();
		}catch(JDOMException ex) {
			log.error("�������� �ε� ����(JDOM)");
		}catch(IOException ex) {
			log.error("�������� �ε� ����(IO)");
		}
	}
	
	public static ConfigLoader getInstance() {
		return configLoader;
	}
	
	public String getConfigValue(String classNm, String elementNm) {
		String value = xmlRoot.getChild(classNm).getChildText(elementNm);
		log.debug("�������� �δ� [" + classNm +"]-["+elementNm+"] = "+ value );
		return value;
	}
	
}
