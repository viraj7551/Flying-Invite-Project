package com.app;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESUtil {

	private static final String KEY = "13Viraj@12345678";
	private static final String IV  = "13Viraj@12345678";

	public static String decrypt(String encrypted) throws Exception {

	    SecretKeySpec secretKey =
	            new SecretKeySpec(KEY.getBytes("UTF-8"), "AES");

	        IvParameterSpec ivSpec =
	            new IvParameterSpec(IV.getBytes("UTF-8"));

	        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

	        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivSpec);

	        byte[] decoded = Base64.getDecoder().decode(encrypted);

	        byte[] original = cipher.doFinal(decoded);

	        return new String(original);
	    
	}
}
