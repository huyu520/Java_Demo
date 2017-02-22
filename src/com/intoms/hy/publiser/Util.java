package com.intoms.hy.publiser;

import java.util.Random;

public class Util {
	public static String generateRandomId(int n){
		StringBuilder sb = new StringBuilder() ;
		for(int i = 0 ;i < n ; i++){
			int num = new Random().nextInt(10) ;
			sb.append(num);
		}
		return sb.toString() ;
	}
}
