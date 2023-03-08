package com.hussain.utils;

import java.io.*;
import java.util.Properties;

public class FileWriteRead {

    public static void main(String[] args) throws IOException {

        writeFile();
        readFile();

    }

    private static void writeFile() throws IOException {
        Properties properties = new Properties();
        properties.setProperty("server_name", "finncub.com");
        properties.setProperty("request_timeout", "3000");
        try (OutputStream output = new FileOutputStream("config.properties")) {
            properties.store(output, "This is prod server details");
        }
    }

    private static void readFile() throws IOException {
        try (InputStream input = new FileInputStream("config.properties")) {
            Properties properties = new Properties();
            properties.load(input);
            String serverName = properties.getProperty("server_name");
            System.out.println("Server Name " + serverName);
        }

    }
}
