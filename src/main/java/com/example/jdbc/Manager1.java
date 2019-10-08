package com.example.jdbc;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class Manager1 {

	private static final String driverClass;
	private static final String url;
	private static final String username;
	private static final String password;
	static
	{
		Properties pr = new Properties();
		FileReader fin = null;
		try
		{
			fin = new FileReader("src/main/resources/application.yml");
			pr.load(fin);
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			try
			{
				if(fin != null);
				{
					fin.close();
					fin = null;
				}
			}
			catch(IOException ex)
			{
				ex.printStackTrace();
			}
		}
		driverClass = pr.getProperty("spring.datasource.driver-class-name");
		url = pr.getProperty("spring.datasource.url");
		username = pr.getProperty("spring.datasource.username");
		password = pr.getProperty("spring.datasource.password");
	}
	public static void main(String[] args) throws Exception {
		System.out.println(driverClass);
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, username, password);
		Statement stmt = con.createStatement();
		String s1 = "CREATE TABLE employee(id int(10) unsigned NOT NULL AUTO_INCREMENT,first_name varchar(255) DEFAULT NULL,last_name varchar(255) DEFAULT NULL,salary double DEFAULT NULL,PRIMARY KEY (id))";
		stmt.execute(s1);
		System.out.println("done");
	}

}
