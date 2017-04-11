package com.thinking.in.java.charcter3;

import org.apache.commons.lang.StringUtils;

public class HyUtil {
	/**
	 * 普通的打印方法
	 * @param object
	 */
	public static void print(Object object){
		if(StringUtils.isNotEmpty((String.valueOf(object)))){
			System.out.println("Object:" + object);
		}
	}
}
