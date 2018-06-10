package com.hellofresh.utils;

import java.util.Random;

public class Utilities {

	// Get random string
	public static String randomString(int len) {
		String AB = "AABBCC";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		return sb.toString();
	}
}
