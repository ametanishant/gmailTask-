package com.nishant.selenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesUtil {

	public static final String homedir = "/Users/nishantameta/Documents/WebDriver/SeleniumLearning/src/com/nishant/selenium/test-data/";
	
	
	static Properties props = new Properties();
	static {
		try {
			props.load(new FileInputStream(homedir+ "env.properties"));
		} catch (FileNotFoundException e) {

		} catch (IOException e) {

		}
	}
	
	
	/**************************************************************
	 * @return returns properties value from properties file.
	 *************************************************************/

	public static String getProperty_(String value) {
		String propertyValue = null;
		try {
			propertyValue = props.getProperty(value);
		} catch (Exception e) {
			// e.printStackTrace();
			propertyValue = "default";
		}
		return propertyValue;
	}
	
	/**************************************************************
	 * @return returns properties value from properties file.
	 *************************************************************/

	public static String getProperty(String value) {
		String propertyValue = null;
		String env_prop_to_load = null;
		try {
			env_prop_to_load = props.getProperty("env_to_use");
			 System.out.print("TESTS RUNNING ON ENV " + env_prop_to_load);
			props.load(new FileInputStream("/Users/nishantameta/Documents/WebDriver/SeleniumLearning/src/com/nishant/selenium/test-data/"+env_prop_to_load));
			propertyValue = props.getProperty(value);
		} catch (Exception e) {
			// e.printStackTrace();
			propertyValue = "default";
		}
		return propertyValue;
	}


	/************************************************************
	 * sets values in the properties file.
	 **********************************************************/

	public static void setProperty(String key, String value) {
		props.setProperty(key, value);
		saveProperties(props, homedir
				+ "silverpage_element.properties.properties");
	}

	/**************************************************************
	 * saves values to the properties file before processing. Example set system
	 * date in properties file.
	 **************************************************************/

	public static void saveProperties(Properties p, String fileName) {
		OutputStream outPropFile;
		try {
			outPropFile = new FileOutputStream(fileName);
			p.store(outPropFile, "Properties File to the Test Application");
			outPropFile.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}


}
