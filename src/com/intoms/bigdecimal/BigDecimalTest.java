/**
 * 
 */
package com.intoms.bigdecimal;

import java.math.BigDecimal;

/**
 *  CopyRight by 2016 Mfish
 *  All Right Reserved
 *	
 *  @author hy
 *	Create on 2016年11月21日下午5:46:39
 */
public class BigDecimalTest {
	public static void main(String[] args) {
		System.out.println(" 0.05 + 0.01  = "+ (0.05+0.01) );
		System.out.println(" 0.05 - 0.01  = "+ (0.05-0.01) );
		System.out.println(" 0.05 * 0.01  = "+ (0.05*0.01) );
		System.out.println(" 0.05 / 0.01  = "+ (0.05/0.01) );
		
		BigDecimal f1 = new BigDecimal("0.05");
		BigDecimal f2 = BigDecimal.valueOf(0.01);
		BigDecimal f3 = new BigDecimal(0.05);
		System.err.println("使用String作为BigDecimal的构造参数:");
		System.out.println(" 0.05 + 0.01  = "+ (f1.add(f2)) );
		System.out.println(" 0.05 - 0.01  = "+ (f1.subtract(f2)) );
		System.out.println(" 0.05 * 0.01  = "+ (f1.multiply(f2)) );
		System.out.println(" 0.05 / 0.01  = "+ (f1.divide(f2)) );
		

	}
}	
