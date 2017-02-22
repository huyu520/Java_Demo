/**
 * 
 */
package com.intoms.hy.collection;

import java.util.Stack;

/**
 *  CopyRight by 2016 Mfish
 *  All Right Reserved
 *	
 *  @author hy
 *	Create on 2017年2月16日下午2:49:03
 */
public class TestStack {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();
		stack.push("123");
		stack.push("321");
		stack.push("1222");
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack.peek());
	}
}
