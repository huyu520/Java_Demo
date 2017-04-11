package com.thinking.in.java.charcter3;

public class Equivalence {
	public static void main(String[] args) {
		test2();
	}
	
	/**
	 * 测试==与equals
	 */
	public static void test1(){
		Integer int1 = new Integer(33);
		Integer int2 = new Integer(33);
		System.out.println(int1 == int2);
		System.out.println(int1.equals(int2));
	}
	
	public static void test2() {
	    Value value1 = new Value() ;	
	    Value value2 = new Value() ;
	    value1.i =  value2.i =10 ;
	    System.out.println(value1 == value2);
	    System.out.println(value1 .equals(value2));
	}
}
class Value{
	int i ;
	
	/**
	 * 重写obj 的equals方法
	 */
	@Override
	public boolean equals(Object obj) {
		if(this == obj ){
			return true ;
		}
		Value value = null ;
		if(obj != null && obj instanceof Value){
			 value = (Value)obj ;
		}
		if(value.i != this.i){
			return false ;
		}
		return true ;
	}
}