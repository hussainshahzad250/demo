package com.hussain.utils;

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
			fin = new FileReader("application.yml");
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
		driverClass = pr.getProperty("driverClass");
		url = pr.getProperty("url");
		username = pr.getProperty("username");
		password = pr.getProperty("password");
	}
	public static void main(String[] args) throws Exception {
		System.out.println(driverClass);
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dev", "root", "P@ssw0rd");
		Statement stmt = con.createStatement();
		String s1 = "CREATE TABLE employee(id int(10) unsigned NOT NULL AUTO_INCREMENT,first_name varchar(255) DEFAULT NULL,last_name varchar(255) DEFAULT NULL,salary double DEFAULT NULL,PRIMARY KEY (id))";
		stmt.execute(s1);
		System.out.println("done");
	}

}
