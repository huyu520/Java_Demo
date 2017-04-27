package com.intoms.junit;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;


public class TestIo {
	
	
	/**
	 *	若果是非文本类型，如图片，现则InputStream , outputStream 
	 * **/
	@Test
	public void copyJpg() throws IOException{
		File f1 = new File("D:/test.png");
		File f2 = new File("D:/hy.png");
		
		byte[] arry = new byte[1024];
		
		int count ;
		FileInputStream fileInputStream = new FileInputStream(f1);
		FileOutputStream fileOutputStream = new FileOutputStream(f2);
		
		try {
				while((count = fileInputStream.read(arry))!=-1){
					fileOutputStream.write(arry, 0, count);
				}
			} catch (FileNotFoundException e) {
				System.out.println("FileNotFoundException");
			} 
		fileInputStream.close(); 
		fileOutputStream.close();
	}
	
	@Test
	public void copyTxt() throws IOException{
		File file1 = new File("D:/test.txt");
		File file2 = new File("D:/testhhhhhhhhhhhy.txt");
		
		BufferedReader bReader = new BufferedReader(new FileReader(file1));
		BufferedWriter bWriter = new BufferedWriter(new FileWriter(file2));
		
		char[] ch = new char[1024] ;
		int count ;
		
		while((count = bReader.read(ch)) !=-1){
			bWriter.write(ch, 0, count);
		}
		
		bReader.close();
		bWriter.close(); 
	}
}
