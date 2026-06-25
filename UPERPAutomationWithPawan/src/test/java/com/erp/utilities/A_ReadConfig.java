package com.erp.utilities;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class A_ReadConfig {
	
	Properties prop;
	
	public A_ReadConfig()	{
		File src = new File("./Configuration/config.properties");
		
		try	{
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) 	{
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	public String getApplicationURL()	{
		String url = prop.getProperty("baseURL");
		return url;
	}
	
	public String getUsername()	{
		String username = prop.getProperty("username");
		return username;
	}
	
	public String getPassword()	{
		String password= prop.getProperty("password");
		return password;
	}
	
	public String getChromepath()	{
		String chromepath= prop.getProperty("chromepath");
		return chromepath;
	}
	public String getFirefox()	{
		String firefox= prop.getProperty("firefoxpath");
		return firefox;
	}
	public String getIEPath()	{
		String iepath= prop.getProperty("iepath");
		return iepath;
	}
}
