package com.intoms.javabasic;

public class StringSort {
	public static void main(String[] args) {
		String[] array = new String[]{"bb","aa","wewew","abc"};
//		for(String s : array){
//			System.out.println(s);
//		}
		for(int i = 0 ; i < array.length ; i ++){
			for(int j = i + 1 ; j < array.length - 1 ; j++ ){
//				String temp = array[i];
				if(array[i].compareTo(array[j]) > 0){
					String temp = array[i];
					array[i] = array[j] ;
					array[j] = temp ;
				}
			}
		}
		
		for(String s : array){
			System.out.println(s);
		}
	}
}
