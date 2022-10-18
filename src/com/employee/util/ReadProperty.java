package com.employee.util;

import java.util.logging.Level;

import com.employee.common.CommonConstants;

import java.util.logging.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class ReadProperty {
	//constant for property file path
	public static final String FILE_PATH = "src\\config.properties";
	
	
	private static Properties prop;
	
	protected ReadProperty() {
        super();

        init();
    }
	
	private static class PropertiesInstance {
        private static ReadProperty instance = null;

        public static ReadProperty getInstance() {
            if (null == instance) {
                instance = new ReadProperty();
            }
            return instance;
        }
    }
	
	public static ReadProperty getInstance() {
        return PropertiesInstance.getInstance();
    }
	
	private void init() {

        prop = new Properties();
        try (
        		InputStream input = getClass().getResourceAsStream(FILE_PATH)) {
        

            // load a properties file
            prop.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public static String getProperty(String key) {
        try {
			return prop.getProperty(key);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return key;
    }

//	static {
//		try {
//			property.load(UtilQ.class.getResourceAsStream(FILE_PATH));
//		}catch(FileNotFoundException e) {
//			
//		}catch (IOException e) {
////			CommonConstants.log.log(e.getMessage());
//		}
//	}
}
