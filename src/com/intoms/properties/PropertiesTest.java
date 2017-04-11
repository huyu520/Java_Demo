/**
 * 
 */
package com.intoms.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 *  CopyRight by 2016 Mfish
 *  All Right Reserved
 *	
 *  @author hy
 *	Create on 2016年11月22日下午3:31:27
 */
public class PropertiesTest {
	public static void main(String[] args) throws FileNotFoundException, IOException {
//		Properties pros = new Properties();
//		pros.setProperty("username", "huyu0822");
//		pros.setProperty("password", "timo0822");
////		pros.store(new FileOutputStream("D:a.ini"), "test timo");
//		pros.store(new FileWriter("D:b.ini"), "sssssss");
		Properties pro1s = new Properties();
//		pro1s.setProperty("gender", "male");
		pro1s.load(new FileInputStream(new File("D:b.ini")));
//		pro1s.store(new FileOutputStream("D:a.ini"), "test timo");
		pro1s.store(new FileWriter(new File("D:b.ini")), "sssssss");
		System.out.println(pro1s);
	}
}
