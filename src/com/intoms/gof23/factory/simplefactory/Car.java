/**
 * 
 */
package com.intoms.gof23.factory.simplefactory;

/**
 *  CopyRight by 2016 Mfish
 *  All Right Reserved
 *	
 *  @author hy
 *	Create on 2016年11月24日上午11:33:12
 */
public interface Car {
	/**
	 * 谁在开车
	 * @param name 
	 */
	public void driver(String name);
	/**
	 * 加油的多少升
	 * @param length
	 */
	public void addOil(int length);
}
