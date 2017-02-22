/**
 * 
 */
package com.intoms.stream;

import java.util.stream.IntStream;
import java.util.stream.IntStream.Builder;

/**
 *  CopyRight by 2016 Mfish
 *  All Right Reserved
 *	
 *  @author hy
 *	Create on 2016年11月22日下午3:14:26
 */
public class StreamTest {
	public static void main(String[] args) {
		IntStream in =  (IntStream) IntStream.builder();
		((Builder) in).add(20);
		((Builder) in).add(22);
		((Builder) in).add(26);
		((Builder) in).add(28);
		((Builder) in).add(29);
		System.out.println("in中的最大值" + in.max().getAsInt());
	}
}
