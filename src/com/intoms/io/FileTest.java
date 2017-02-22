package com.intoms.io;

import java.io.File;
import java.io.IOException;

public class FileTest {
	public static void main(String[] args) throws IOException {
		createFile();
	}

	public static void createFile() throws IOException {
		File file = new File("E:test.txt");
		if (!file.exists()) {
			file.createNewFile();
			System.out.println("该分区的大小：" + file.getTotalSpace() / (1024 * 1024 * 1024) + "G");
			file.mkdir();
			System.out.println("文件名  " + file.getName());
			System.out.println("文件父目录字符串 " + file.getParent());
		}
	}
}
