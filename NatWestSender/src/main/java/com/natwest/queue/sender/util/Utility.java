package com.natwest.queue.sender.util;

import java.util.Base64;

import org.springframework.util.SerializationUtils;

public class Utility {

	public static <T> String encryptObject(T object){
		Base64.Encoder encoder = Base64.getEncoder();
		byte[] byteArr = SerializationUtils.serialize(object);
		return encoder.encodeToString(byteArr);
	}
}
