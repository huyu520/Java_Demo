package com.intoms.array;

import java.util.Arrays;

public class TestExpandArray {
	public static void main(String[] args) {
		/*1）Java数组对象的大小是固定不变的，数组对象是不可扩容的。

		　　2）利用数组复制方法可以变通的实现数组扩容。

		　　3）System.arraycopy()可以复制数组。

		　　4）Arrays.copyOf()可以简便的创建数组副本。

		　　5）创建数组副本的同时将数组长度增加就变通的实现了数组的扩容*/
		//数组扩容的算法
		int[] array = {1,2,3};
		array = Arrays.copyOf(array, array.length + 1);
		array[array.length - 1] = 4 ;
		System.out.println(Arrays.toString(array));
		
		//字符串连接原理
		char[] chs = {'中','国'};
		chs = Arrays.copyOf(chs, chs.length+1);
		chs[chs.length-1] = '北';
		chs = Arrays.copyOf(chs, chs.length+1);
		chs[chs.length-1] = '京';
		System.out.println(Arrays.toString(chs));
		System.out.println(chs);
	}
}
