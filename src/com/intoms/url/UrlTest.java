package com.intoms.url;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class UrlTest {

	/**
	 * 通过url获取星系
	 * 
	 * @return
	 */
	public static String getHtmlByUrl(String url, String encording) {
		URL urlobj = null;
		URLConnection uc = null;
		InputStreamReader input = null;
		StringBuffer sb = new StringBuffer();
		BufferedReader bufer = null;
		BufferedWriter writer = null;
		try {
			urlobj = new URL(url);
			uc = urlobj.openConnection();
			writer = new BufferedWriter(new FileWriter(new File("d:\\testUrl.txt")));

			input = new InputStreamReader(uc.getInputStream(), encording);
			bufer = new BufferedReader(input);
			String temp = "";
			while ((temp = bufer.readLine()) != null) {
				sb.append(temp + "\n");
				writer.write(temp + "\n");
			}
			return sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("世界上最遥远的就是没网");
		}finally {
			try {
				writer.close();
				input.close(); 
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "";
	}
	
	public static void main(String[] args) {
		System.out.println(getHtmlByUrl("https://www.sina.com", "UTF-8"));
	}
}
