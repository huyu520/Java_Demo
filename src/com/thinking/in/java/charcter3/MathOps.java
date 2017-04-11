package com.thinking.in.java.charcter3;

import java.util.Random;

/**
 * Demostrater the mathematical operator
 * @author hy
 *
 */
public class MathOps {
	// create a seeded random number generator
	public static void main(String[] args) {
		Random rand = new Random(47);
		float a ; //Allaies to double too
		a = rand.nextFloat() ;
		HyUtil.print(a);
	}
}
