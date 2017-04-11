package com.agsnasoft.java.utils;

import java.io.IOException;
import java.util.Properties;

public class SqlUtils {

	private Properties properties;
	private static String FILE_NAME_SQL = "sql.properties";
	
	private static SqlUtils instance = new SqlUtils();
	
	public SqlUtils(){
		properties = new Properties();
		try {
			properties.load(SqlUtils.class.getResourceAsStream(FILE_NAME_SQL));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static SqlUtils getInstance() {
		return instance;
	}	
	
	public String getValue(String name){
		return properties.getProperty(name);
	}
}
