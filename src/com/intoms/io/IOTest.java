/**
 * 
 */
package com.intoms.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  CopyRight by 2016 Mfish
 *  All Right Reserved
 *	
 *  @author hy
 *	Create on 2017年2月9日下午8:03:42
 */
public class IOTest {
	public static void main(String[] args) {
		test();
	}
	
	public static void test() {
		BufferedReader reader = null ;
			try {
				reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\test.txt"))));
				String readLine = "" ;
				try {
					while((readLine = reader.readLine())!=null){
						System.out.println(readLine);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
	}
}
