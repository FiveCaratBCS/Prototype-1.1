package com.block;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropFile {
	
	
	
	public static String readProp() throws IOException {
		
		InputStream in = ReadPropFile.class.getClassLoader().getResourceAsStream("config/bcconfig.config");
		
		System.out.println("inputStream is: " + in);
		
		Properties props = new Properties();
		props.load(in);
		
		String num = props.getProperty("block_value");
		
		System.out.println("Block value is: " + num);
		
		return num;
	}
}
