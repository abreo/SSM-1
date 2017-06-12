package com.example.ssm.util;

public class RedisIdUtil {

	public static String getBlogId(Integer id) {
		String ids = "blog:hits:"+id;
		return ids;
	}
	
}
