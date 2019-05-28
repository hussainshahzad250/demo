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
package co.shahzad.googlecloud;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;

public class StorageServiceAccountSample {

	/** E-mail address of the service account. */
	private static final String SERVICE_ACCOUNT_EMAIL = "loandost@satincreditcare.com";

	/** Global configuration of Google Cloud Storage OAuth 2.0 scope. */
	private static final String STORAGE_SCOPE = "https://www.googleapis.com/auth/devstorage.read_write";

	/** Global instance of the HTTP transport. */
	private static HttpTransport httpTransport;

	/** Global instance of the JSON factory. */
	private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

	public static void main(String[] args) {
		try {
			try {
				httpTransport = GoogleNetHttpTransport.newTrustedTransport();
				// Check for valid setup.
//				Preconditions.checkArgument(!SERVICE_ACCOUNT_EMAIL.startsWith("[["),
//						"Please enter your service account e-mail from the Google APIs "
//								+ "Console to the SERVICE_ACCOUNT_EMAIL constant in %s",
//						StorageServiceAccountSample.class.getName());
//				Preconditions
//						.checkArgument(!BUCKET_NAME.startsWith("[["),
//								"Please enter your desired Google Cloud Storage bucket name "
//										+ "to the BUCKET_NAME constant in %s",
//								StorageServiceAccountSample.class.getName());
//				String p12Content = Files.readFirstLine(new File("loandost.p12"), Charset.defaultCharset());
//				Preconditions.checkArgument(!p12Content.startsWith("Please"), p12Content);

				// [START snippet]
				// Build a service account credential.

				JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
				GoogleCredential credential = new GoogleCredential.Builder().setTransport(httpTransport)
						.setJsonFactory(JSON_FACTORY).setServiceAccountId(SERVICE_ACCOUNT_EMAIL)
						.setServiceAccountScopes(Collections.singleton(STORAGE_SCOPE))
						.setServiceAccountPrivateKeyFromP12File(new File("loandost.p12")).setJsonFactory(jsonFactory)
						.build();
				
				System.out.println("Ho Gya");
				

				// Set up and execute a Google Cloud Storage request.
				String URI = "https://www.googleapis.com/storage/v1/b?project=552973886027";
//				String URI = "https://storage.googleapis.com/" + BUCKET_NAME + "?project=loandost-01";
			
				
				HttpRequestFactory requestFactory = httpTransport.createRequestFactory(credential);
				GenericUrl url = new GenericUrl(URI);
				HttpRequest request = requestFactory.buildGetRequest(url);
				HttpResponse response = request.execute();
				String content = response.parseAsString();
				System.out.println("content  " + content);
				// [END snippet]

				// Instantiate transformer input.
//				Source xmlInput = new StreamSource(new StringReader(content));
//				StreamResult xmlOutput = new StreamResult(new StringWriter());

				// Configure transformer.
//				Transformer transformer = TransformerFactory.newInstance().newTransformer(); // An identity
//																								// transformer
//				transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "testing.dtd");
//				transformer.setOutputProperty(OutputKeys.INDENT, "yes");
//				transformer.setOutputProperty(OutputKeys.INDENT, "yes");
//				transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
//				transformer.transform(xmlInput, xmlOutput);
//
//				// Pretty print the output XML.
//				System.out.println("\nBucket listing for " + BUCKET_NAME + ":\n");
//				System.out.println(xmlOutput.getWriter().toString());
//				System.exit(0);

			} catch (IOException e) {
				e.printStackTrace();
				System.err.println(e.getMessage());
			}
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
}