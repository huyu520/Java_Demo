package com.thinking.in.java.charcter3;


/**
 * 测试别名
 * @author hy
 *
 */
public class PassObject {
	static void f(letter y){
		y.c = 'z';
	}
	public static void main(String[] args) {
		letter letter = new letter();
		letter.c = 's';
		HyUtil.print("1:letter.c---" + letter.c);
		f(letter);
		HyUtil.print("1:letter.c---" + letter.c);
	}
}
class letter{
	char c ;
}
