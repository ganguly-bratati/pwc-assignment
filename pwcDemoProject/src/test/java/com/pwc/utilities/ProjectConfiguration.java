package com.pwc.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ProjectConfiguration {
	
	public static String loadProperties(String key) {
		String value = null;
		
		
		Properties prop = new Properties();
		FileInputStream input;
		
		try {
			input = new FileInputStream(System.getProperty("user.dir") + "/Configuration/config.properties");
			prop.load(input);
			value = prop.getProperty(key);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return value;
		
	}

}
