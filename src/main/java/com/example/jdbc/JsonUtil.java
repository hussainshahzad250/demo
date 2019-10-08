package com.example.jdbc;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

	private static ObjectMapper objectMapper = new ObjectMapper();

	public static <T> String getJson(T data) {
		try {
			return objectMapper.writeValueAsString(data);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <T> T convertToPojo(String json, Class<T> t) throws Exception {
		return objectMapper.readValue(json, t);
	}
	public static <T> T convertFileToPojo(File fileName, Class<T> t) throws Exception {
		return objectMapper.readValue(fileName, t);
	}

	public static <T> List<T> convertToListPojo(String json, Class<T> t) throws Exception {
		return objectMapper.readValue(json, new TypeReference<List<T>>() {
		});
	}
	
	public static <T> List<T> convertToListPojo(File fileName, Class<T> t) throws Exception {
		return objectMapper.readValue(fileName, new TypeReference<List<T>>() {
		});
	}
	
	public static double roundOff(double value, int decimalValue) {
		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(decimalValue, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

	
}
