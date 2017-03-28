package com.intoms.string;

import java.util.HashMap;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;

import com.google.common.collect.Maps;

/**
 * apcche commons 的使用
 * @author Administrator
 *
 */
public class CommonsUitlsTest {
	public static void main(String[] args) {
		
		String a = null ;
		String bString = null ;
		
		System.out.println(StringUtils.equals(a, bString));
		HashMap<String, Integer> map = Maps.newHashMap();
		map.put("hy", 213);
		String result = MapUtils.getString(map, "hy");
		String result2 = MapUtils.getString(map, "h2y", "hahh");
						
		System.out.println(result);
		System.out.println(result2);
	}
}
