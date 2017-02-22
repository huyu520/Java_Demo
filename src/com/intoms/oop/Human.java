/**
 * 
 */
package com.intoms.oop;

/**
 *  CopyRight by 2016 Mfish
 *  All Right Reserved
 *	
 *  @author hy
 *	Create on 2017年2月9日下午8:46:43
 */
public abstract  class Human extends Animal{
	
	public abstract String talk();
	
	/* (non-Javadoc)
	 * @see com.intoms.oop.Animal#excuteActivity()
	 */
	@Override
	public String excuteActivity() {
		// TODO Auto-generated method stub
		return excute();
	}
}
