package com.qa.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyLogic 
{
	public  Properties pro;
	public void getProperty()
	{
		FileInputStream fs = null;
		String envName = System.getProperty("env");
		pro = new Properties();
			try {
				if(envName==null)
				{
				fs = new FileInputStream("path");
				}
				else
				{
					switch (envName.toLowerCase()) {
					case "qa":
						fs = new FileInputStream("path");
						break;

					default:
						System.out.println("please pass the correct");
						break;
					}
				}
				} 
				catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				pro.load(fs);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}

}
