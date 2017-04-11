package com.thinking.in.java.charcter4;

/**
 * Show all the lowerCase and UpperCase in ASCII letter
 * @author hy
 *
 */
public class ListCharacter {
	public static void main(String[] args) {
		for(char c = 0 ; c < 128 ; c++ ){
			if(Character.isLowerCase(c)||Character.isUpperCase(c)){
				System.out.println("value:" + (int)c + "Chracter:" + c);
			}
		}
	}
}
