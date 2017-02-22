package com.intoms.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileCount {
	public static void main(String[] args) {
		
		int count = 0 ;
		InputStream inputStream = null ;
		try {
			inputStream = new FileInputStream(new File("E:/test.txt"));
			while(inputStream.read()!= -1){
				count ++ ;
			}
			System.out.println("文件的长度是" + count + "字节");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream!=null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
