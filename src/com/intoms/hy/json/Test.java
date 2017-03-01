/**
 * 
 */
package com.intoms.hy.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

/**
 * CopyRight by 2016 Mfish All Right Reserved
 * 
 * @author hy Create on 2017年2月14日下午2:25:07
 */
public class Test {
	
	@org.junit.Test
	public void testGson() {
		Map<String, String> map = null;
		Gson gson = new Gson();
		System.out.println(gson.toJson(map));
	}
	
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("123", "abcd");
		map.put("1223", "abcd");
		map.put("1233", "abcd");
		map.put("1253", "abcd");
		map.put("12323", "abcd");
		Gson gson = new Gson();
		
		List<String> list = new ArrayList<>();
		for(int i=0 ;i < 10 ; i++){
			list.add(String.valueOf(i));
		}
		
		String[] str = new String[10];
		for(int i = 0 ; i< str.length ; i++){
			str[i] = i+"" ;
		}
		System.out.println(gson.toJson(str));
		System.out.println(list);
	}
}
