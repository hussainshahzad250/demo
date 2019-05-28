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
package com.example.demo;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.UUID;

public class EncodeAndDecode {

	public static void main(String[] args) throws UnsupportedEncodingException {

		encodeAndDecode();
	}

	private static void encodeAndDecode() throws UnsupportedEncodingException {

		// Encode using basic encoder
		String base64encodedString = Base64.getEncoder().encodeToString("TutorialsPoint?java8".getBytes("utf-8"));
		System.out.println("Base64 Encoded String (Basic) :" + base64encodedString);

		// Decode
		byte[] base64decodedBytes = Base64.getDecoder().decode(base64encodedString);

		System.out.println("Base64 Decoded  String: " + new String(base64decodedBytes, "utf-8"));

		base64encodedString = Base64.getUrlEncoder().encodeToString("TutorialsPoint?java8".getBytes("utf-8"));
		System.out.println("Base64 Encoded String (URL) :" + base64encodedString);

		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i < 10; ++i) {
			stringBuilder.append(UUID.randomUUID().toString());
		}

		byte[] mimeBytes = stringBuilder.toString().getBytes("utf-8");
		String mimeEncodedString = Base64.getMimeEncoder().encodeToString(mimeBytes);
		System.out.println("\n\n\nBase64 Encoded String (MIME) :\n\n" + mimeEncodedString);

	}
}
