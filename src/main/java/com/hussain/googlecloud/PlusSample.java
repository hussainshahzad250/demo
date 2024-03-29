package com.hussain.googlecloud;
///*************************************************************************
//* 
//* SATIN CREDITCARE NETWORK LIMITED CONFIDENTIAL
//* __________________
//* 
//*  [2018] SATIN CREDITCARE NETWORK LIMITED
//*  All Rights Reserved.
//* 
//* NOTICE:  All information contained herein is, and remains the property of SATIN CREDITCARE NETWORK LIMITED, and
//* The intellectual and technical concepts contained herein are proprietary to SATIN CREDITCARE NETWORK LIMITED
//* and may be covered by India and Foreign Patents, patents in process, and are protected by trade secret or copyright law.
//* Dissemination of this information or reproduction of this material is strictly forbidden unless prior written permission
//* is obtained from SATIN CREDITCARE NETWORK LIMITED.
//*/
//package co.shahzad.java;
//
//import com.google.api.client.auth.oauth2.Credential;
//import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
//import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
//import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
//import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
//import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
//import com.google.api.client.http.HttpTransport;
//import com.google.api.client.json.JsonFactory;
//import com.google.api.client.json.jackson2.JacksonFactory;
//import com.google.api.client.util.store.DataStoreFactory;
//import com.google.api.client.util.store.FileDataStoreFactory;
//import com.google.api.services.plus.Plus;
//import com.google.api.services.plus.PlusScopes;
//import com.google.api.services.plus.model.Activity;
//import com.google.api.services.plus.model.ActivityFeed;
//import com.google.api.services.plus.model.Person;
//
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Collections;
//
//public class PlusSample {
//
//	private static final String APPLICATION_NAME = "loandost-01";
//
//	/** Directory to store user credentials. */
//	private static final java.io.File DATA_STORE_DIR = new java.io.File(System.getProperty("user.home"),
//			".store/plus_sample");
//
//	/**
//	 * Global instance of the {@link DataStoreFactory}. The best practice is to make
//	 * it a single globally shared instance across your application.
//	 */
//	private static FileDataStoreFactory dataStoreFactory;
//
//	/** Global instance of the HTTP transport. */
//	private static HttpTransport httpTransport;
//
//	/** Global instance of the JSON factory. */
//	private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
//
//	private static Plus plus;
//
//	/** Authorizes the installed application to access user's protected data. */
//	private static Credential authorize() throws Exception {
//		// load client secrets
//		GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY,
//				new InputStreamReader(PlusSample.class.getResourceAsStream("/client_secrets.json")));
//		if (clientSecrets.getDetails().getClientId().startsWith("Enter")
//				|| clientSecrets.getDetails().getClientSecret().startsWith("Enter ")) {
//			System.out.println("Enter Client ID and Secret from https://code.google.com/apis/console/?api=plus "
//					+ "into plus-cmdline-sample/src/main/resources/client_secrets.json");
//			System.exit(1);
//		}
//		// set up authorization code flow
//		GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(httpTransport, JSON_FACTORY,
//				clientSecrets, Collections.singleton(PlusScopes.PLUS_ME)).setDataStoreFactory(dataStoreFactory).build();
//		// authorize
//		return new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
//	}
//
//	public static void main(String[] args) {
//		try {
//			httpTransport = GoogleNetHttpTransport.newTrustedTransport();
//			dataStoreFactory = new FileDataStoreFactory(DATA_STORE_DIR);
//			// authorization
//			Credential credential = authorize();
//			// set up global Plus instance
//			plus = new Plus.Builder(httpTransport, JSON_FACTORY, credential).setApplicationName(APPLICATION_NAME)
//					.build();
//			// run commands
//			listActivities();
//			getActivity();
//			getProfile();
//			// success!
//			return;
//		} catch (IOException e) {
//			System.err.println(e.getMessage());
//		} catch (Throwable t) {
//			t.printStackTrace();
//		}
//		System.exit(1);
//	}
//
//	/** List the public activities for the authenticated user. */
//	private static void listActivities() throws IOException {
//		View.header1("Listing My Activities");
//		// Fetch the first page of activities
//		Plus.Activities.List listActivities = plus.activities().list("me", "public");
//		listActivities.setMaxResults(5L);
//		// Pro tip: Use partial responses to improve response time considerably
//		listActivities.setFields("nextPageToken,items(id,url,object/content)");
//		ActivityFeed feed = listActivities.execute();
//		// Keep track of the page number in case we're listing activities
//		// for a user with thousands of activities. We'll limit ourselves
//		// to 5 pages
//		int currentPageNumber = 0;
//		while (feed.getItems() != null && !feed.getItems().isEmpty() && ++currentPageNumber <= 5) {
//			for (Activity activity : feed.getItems()) {
//				View.show(activity);
//				View.separator();
//			}
//			// Fetch the next page
//			String nextPageToken = feed.getNextPageToken();
//			if (nextPageToken == null) {
//				break;
//			}
//			listActivities.setPageToken(nextPageToken);
//			View.header2("New page of activities");
//			feed = listActivities.execute();
//		}
//	}
//
//	/** Get an activity for which we already know the ID. */
//	private static void getActivity() throws IOException {
//		// A known public activity ID
//		String activityId = "z12gtjhq3qn2xxl2o224exwiqruvtda0i";
//		// We do not need to be authenticated to fetch this activity
//		View.header1("Get an explicit public activity by ID");
//		Activity activity = plus.activities().get(activityId).execute();
//		View.show(activity);
//	}
//
//	/** Get the profile for the authenticated user. */
//	private static void getProfile() throws IOException {
//		View.header1("Get my Google+ profile");
//		Person profile = plus.people().get("me").execute();
//		View.show(profile);
//	}
//}
