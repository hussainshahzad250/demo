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
package com.hussain.utils;

import com.google.api.gax.paging.Page;
import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * Simple class for creating, reading and modifying text blobs on Google Cloud
 */
public class GoogleCloudStorage {

	private Storage storage;
	private Bucket bucket;
	private static final String BUCKET_NAME = "pubsite_prod_rev_16488945878068153246";

	public static void main(String[] args) throws Exception {


		GoogleCloudStorage googleCloudStorage = new GoogleCloudStorage("loandost-47957793a32c.json", "552973886027");

		Bucket bucket = googleCloudStorage.getBucket(BUCKET_NAME);
		System.out.println(bucket.getName());

		BlobId blobId = googleCloudStorage.saveString("my-first-blob", "Hi there!", bucket);

		String value = googleCloudStorage.getString(blobId);
		System.out.println(value);
		googleCloudStorage.updateString(blobId, "Bye now!");

		value = googleCloudStorage.getString("my-first-blob");

	}

	// Use path and project name
	private GoogleCloudStorage(String pathToConfig, String projectId) throws IOException {
		Credentials credentials = GoogleCredentials.fromStream(new FileInputStream(pathToConfig));
		storage = StorageOptions.newBuilder().setCredentials(credentials).setProjectId(projectId).build().getService();
	}

	// Check for bucket existence and create if needed.
	private Bucket getBucket(String bucketName) {
		bucket = storage.get(bucketName);
		if (bucket == null) {
			System.out.println("Creating new bucket.");
			bucket = storage.create(BucketInfo.of(bucketName));
		}
		return bucket;
	}

	// Save a string to a blob
	private BlobId saveString(String blobName, String value, Bucket bucket) {
		byte[] bytes = value.getBytes(UTF_8);
		Blob blob = bucket.create(blobName, bytes);
		return blob.getBlobId();
	}

	// get a blob by id
	private String getString(BlobId blobId) {
		Blob blob = storage.get(blobId);
		return new String(blob.getContent());
	}

	// get a blob by name
	private String getString(String name) {
		Page<Blob> blobs = bucket.list();
		for (Blob blob : blobs.getValues()) {
			if (name.equals(blob.getName())) {
				return new String(blob.getContent());
			}
		}
		return "Blob not found";
	}

	// Update a blob
	private void updateString(BlobId blobId, String newString) throws IOException {
		Blob blob = storage.get(blobId);
		if (blob != null) {
			WritableByteChannel channel = blob.writer();
			channel.write(ByteBuffer.wrap(newString.getBytes(UTF_8)));
			channel.close();
		}
	}
}