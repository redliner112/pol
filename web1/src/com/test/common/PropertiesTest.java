package com.test.common;
import java.io.IOException;
import java.util.Properties;


public class PropertiesTest {
	
	 Properties pro = new Properties();
	 
	 public static void main(String[]args){
		 PropertiesTest pt = new PropertiesTest();
		 try{
			 pt.pro.load(PropertiesTest.class.getClassLoader().getResourceAsStream("db.properties"));
			 System.out.println(pt.pro.getProperty("db.driver"));
			 System.out.println(pt.pro.getProperty("db.id"));
		 }catch(IOException e){
			 e.printStackTrace();
		 }
	 }

}
