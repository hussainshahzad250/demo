/*************************************************************************
* 
* SATIN CREDITCARE NETWORK LIMITED CONFIDENTIAL
* __________________
* 
*  [2018] SATIN CREDITCARE NETWORK LIMITED
*  All Rights Reserved.
* 
* NOTICE:  All information contained herein is, and remains the property of SATIN CREDITCARE NETWORK LIMITED, and
* The intellectual and technical concepts contained herein are proprietary to SATIN CREDITCARE NETWORK LIMITED
* and may be covered by India and Foreign Patents, patents in process, and are protected by trade secret or copyright law.
* Dissemination of this information or reproduction of this material is strictly forbidden unless prior written permission
* is obtained from SATIN CREDITCARE NETWORK LIMITED.
*/
package com.shahzad.hussain;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class TestPan {

	public static void main(String[] args) throws IOException {

		writeFile();
		readFile();

	}

	private static void readFile() {
		try {
			InputStream input = new FileInputStream("config.properties");
			Properties properties = new Properties();
			properties.load(input);
			String serverName = properties.getProperty("server_name");
			System.out.println(serverName);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void writeFile() throws IOException {
		Properties properties = new Properties();
		properties.setProperty("server_name", "server name");
		properties.setProperty("request_timeout", "5000");
		OutputStream output = new FileOutputStream("config.properties");
		properties.store(output, null);

	}

}
