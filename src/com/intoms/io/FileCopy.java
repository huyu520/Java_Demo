package com.intoms.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
	public static void main(String[] args) {
		byte[] bt = new byte[256];
		int numberRead = 0 ;
		FileInputStream fi = null ;
		FileOutputStream fo = null; 
		
		try {
			fi = new FileInputStream(new File("E:/t1.txt"));
			fo = new FileOutputStream(new File("E:/t2.txt"));
			
			try {
				
				while((numberRead =fi.read(bt))!=-1 ){
					fo.write(bt, 0, numberRead);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				fi.close();
				fo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
