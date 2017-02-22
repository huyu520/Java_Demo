/**
 * 
 */
package com.intoms.random;

import java.util.UUID;

/**
 *  CopyRight by 2016 Mfish
 *  All Right Reserved
 *	
 *  @author hy
 *	Create on 2016年11月25日上午11:46:08
 */
public class RandomUUID {
	public static void main(String[] args) {
		System.out.println("随即产生的UUID:"+ UUID.randomUUID().toString().replaceAll("\\-", "")); //不重复的UUID 去掉-
	}
}
