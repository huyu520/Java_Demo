package com.intoms.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SystemUtils {
	/***
	 * @author hy
	 * @since 2016-11-14 11:37
	 */
	
	/**
	 * 判断对象或对象数组中每一个对象是否为空: 对象为null，字符序列长度为0，集合类、Map为empty
	 * 
	 * @param obj 
	 * @return
	 */
	public static boolean isNullOrEmpty(Object obj) {
		if (obj == null)
			return true;

		if (obj instanceof CharSequence)
			return ((CharSequence) obj).length() == 0;

		if (obj instanceof Collection)
			return ((Collection<?>) obj).isEmpty();

		if (obj instanceof Map)
			return ((Map<?, ?>) obj).isEmpty();

		if (obj instanceof Object[]) {
			Object[] object = (Object[]) obj;
			if (object.length == 0) {
				return true;
			}
			boolean empty = true;
			for (int i = 0; i < object.length; i++) {
				if (!isNullOrEmpty(object[i])) {
					empty = false;
					break;
				}
			}
			return empty;
		}
		return false;
	}

	/**
	 * 对象转字节数组
	 * 
	 * @param object
	 * @return
	 */
	public static byte[] serialize(Object object) {
		ObjectOutputStream oos = null;
		ByteArrayOutputStream baos = null;
		try {
			// 序列化
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(object);
			byte[] bytes = baos.toByteArray();
			return bytes;
		} catch (Exception e) {

		}
		return null;
	}

	/**
	 * 字节数组转对象
	 * 
	 * @param bytes
	 * @return
	 */
	public static Object unserialize(byte[] bytes) {
		ByteArrayInputStream bais = null;
		try {
			// 反序列化
			bais = new ByteArrayInputStream(bytes);
			ObjectInputStream ois = new ObjectInputStream(bais);
			return ois.readObject();
		} catch (Exception e) {

		}
		return null;
	}
	
	/**
     * 获取一个字符串的简明效果
     * @return String 返回的字符串格式类似于"abcd***hijk"
     */
	public static String StringSimplify(String str){
		return str.substring(0,4) + "****" + str.substring(str.length()-4);
	}
	
	public static String formatPhone(String pid){
		if(pid.equals("")||pid == null ){
			return "";
		}
		
		String phoneNum = pid.substring(0, 3);
		for(int i = 0; i < 4 ; i++){
			phoneNum += "*";
		}
		phoneNum += pid.substring(7);
		return phoneNum ;
	}
	
	 /**
     * 获取Map中的属性
     * @see 由于Map.toString()打印出来的参数值对,是横着一排的...参数多的时候,不便于查看各参数值
     * @see 故此仿照commons-lang.jar中的ReflectionToStringBuilder.toString()编写了本方法
     * @return String key11=value11 \n key22=value22 \n key33=value33 \n......
     */
	public static String getStringFromMap(Map<String, String> map){
		StringBuilder sb = new StringBuilder();
		sb.append(map.getClass().getName()).append("@").append(map.hashCode()).append("[");
		for(Map.Entry<String, String> entry :map.entrySet()){
			sb.append("\n").append(entry.getKey()).append("=").append(entry.getValue());
		}
		return sb.append("\n]").toString();
	}
	
	public static void main(String[] args) {
//		String string = "abcdefghabcdfr";
//		System.out.println(StringSimplify(string));
		Map<String, String> map = new HashMap<>();
		map.put("Timo", "123");
		map.put("manzi", "456");
		map.put("dema", "789");
		System.out.println(getStringFromMap(map));
	}
}
