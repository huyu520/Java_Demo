package com.intoms.array;

import java.util.Arrays;

public class TestArray {
	public static void main(String[] args) {
		int[] array = new int[10];
		//填充数组
		Arrays.fill(array, 5);
		for (int i : array) {
			System.out.println(array[i]);
		}
		System.out.println(array.toString());
	}
}
