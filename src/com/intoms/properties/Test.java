/**
 * 
 */
package com.intoms.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *  CopyRight by 2016 Mfish
 *  All Right Reserved
 *	
 *  @author hy
 *	Create on 2016年11月22日下午3:52:57
 */
public class Test {
	public static void main(String[] args) throws IOException {
		Properties pros =new Properties();
		FileInputStream in = new FileInputStream("src/com/intoms/properties/test.properties");
		pros.load(in);
		//获取文件的属性值
		System.out.println("用户名:" + pros.getProperty("username"));
		System.out.println("密码:" + pros.getProperty("password"));
		System.out.println("性别:" + pros.getProperty("gender"));
	}
}
