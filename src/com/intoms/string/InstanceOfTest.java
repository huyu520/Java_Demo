package com.intoms.string;

import java.io.Serializable;

import com.intoms.gamebase.object.Obj;
import com.intoms.gamebase.object.SimpleObj;
import com.intoms.oop.ISpecial;

public class InstanceOfTest extends Obj implements Serializable ,ISpecial{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public <T extends Obj> SimpleObj<T> simplify() {
		// TODO Auto-generated method stub
		return null;
	}
	public static void main(String[] args) {
		String s  = "I am Obj" ;
		
		System.out.println(s instanceof Object);
		System.out.println(new InstanceOfTest() instanceof Obj);
		System.out.println(new InstanceOfTest() instanceof Serializable);
	}
	@Override
	public String fire() {
		// TODO Auto-generated method stub
		return null;
	}
}
