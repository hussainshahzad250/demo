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
/**
 * 
 */
package com.hussain.googlecloud;

import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.gax.paging.Page;
import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.*;
import com.google.cloud.storage.Storage.BucketListOption;
import com.google.common.collect.Lists;
import org.springframework.core.io.ClassPathResource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.GeneralSecurityException;

/**
 * @author shahzad.hussain
 *
 */
public class GoogleCloudAppData {

	private static final String SERVICE_ACCOUNT_EMAIL = "firebase-adminsdk-6fxn3@loandost-01.iam.gserviceaccount.com";

	private static final String BUCKET_NAME = "pubsite_prod_rev_16488945878068153246";

	private static final String STORAGE_SCOPE = "https://www.googleapis.com/auth/devstorage.read_write";

	private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

	private static final String bucket = "pubsite_prod_rev_16488945878068153246";

	public static void main(String[] args) throws FileNotFoundException, IOException, GeneralSecurityException {
//		GoogleCredentials createScoped = ServiceAccountCredentials
//				.fromStream(new ClassPathResource("loandost-21-jan.json").getInputStream()).createScoped(Lists.newArrayList("https://www.googleapis.com/auth/devstorage.read_write"));
//		Storage storage = StorageOptions.newBuilder().setCredentials(createScoped).setProjectId("loandost-01").build()
//				.getService();
		
		GoogleCredentials credentials = GoogleCredentials.fromStream(new ClassPathResource("loandost-21-jan.json").getInputStream()).createScoped(Lists.newArrayList("https://www.googleapis.com/auth/devstorage.read_write"));

		Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();

		Bucket bucket = storage.get(BUCKET_NAME);
//		Storage storage = StorageOptions.getDefaultInstance().getService();
//		Page<Blob> blobs = storage.list(BUCKET_NAME, BlobListOption.currentDirectory(), BlobListOption.prefix("stats"));
//		for (Blob blob : blobs.iterateAll()) {
//			System.out.println(blob.getBucket());
//		}
//		
//		Page<Bucket> blo = storage.list();
//		for (Bucket blob : blo.iterateAll()) {
//			System.out.println(blob.getName());
//		}
//		
//		createBucket(storage);
//		createNewBucket(storage);
//		listingBuckets(storage);

//		HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
//		JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
//		GoogleCredential credential = GoogleCredential.fromStream(new FileInputStream("loandost-21-jan.json"));

//		Policy policy = storage.getIamPolicy(bucket);
//		Map<Role, Set<Identity>> policyBindings = policy.getBindings();
//		for (Map.Entry<Role, Set<Identity>> entry : policyBindings.entrySet()) {
//			System.out.printf("Role: %s Identities: %s\n", entry.getKey(), entry.getValue());
//		}
		System.out.println("bucket created");

		System.out.println("done");

	}

	private static void crete() throws FileNotFoundException, IOException {
		Storage storage = StorageOptions.getDefaultInstance().getService();
		Credentials credentials = GoogleCredentials.fromStream(new FileInputStream("loandost-47957793a32c.json"));
		storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
		Bucket bucket = storage.create(BucketInfo.of("test-bucket"));
		System.out.println(bucket);
	}

	private static void listingBuckets(Storage storage) {
		Page<Bucket> buckets = storage.list(BucketListOption.pageSize(100), BucketListOption.prefix(bucket));
		int count = 0;
		for (Bucket bucket : buckets.iterateAll()) {
			count++;
			System.out.println(bucket.getName());
		}
		System.out.println("All " + count + " Buckets");
	}

	private static void createNewBucket(Storage storage) {
		Bucket bucket = storage.create(BucketInfo.of("bucketName"));
		System.out.println("Bucket " + bucket.getName() + " Created.");
	}

	private static void createBucket(Storage storage) {
		Bucket bucket = storage.create(
				BucketInfo.newBuilder("bucketName").setStorageClass(StorageClass.COLDLINE).setLocation("asia").build());
		System.out.println("Bucket " + bucket.getName() + " Created.");
	}

}
