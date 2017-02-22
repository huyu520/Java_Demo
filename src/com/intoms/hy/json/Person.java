/**
 * 
 */
package com.intoms.hy.json;

import com.google.gson.Gson;

/**
 *  CopyRight by 2016 Mfish
 *  All Right Reserved
 *	
 *  @author hy
 *	Create on 2017年2月14日下午2:22:59
 */
public class Person {
	private String name ;
	private int age ;
	
	public Person() {
	}
	
	public Person(String name ,int age ){
		this.name = name ;
		this.age = age ;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String show(){
		return "name:" + name + "---age:" + age ;
	}
	
	public static void main(String[] args) {
		String[] gsonStr = new String[]{"",
									"abc",
									"{}",
									"{\"nick_name\":\"JACK\"}",
									"{\"name\":\"HY\",\"age\":\"15\"}",
									"{\"name\":\"TIMO\",\"age\":\"999\",\"id\":\"110\"}"};
		Gson gson = new Gson() ;
		Person p = null ;
		StringBuilder sb = null ;
		for(int i=0;i<gsonStr.length;i++){
			sb = new StringBuilder();
			try {
				sb.append(i).append(":").append(gsonStr[i]).append("\n\t");
				p = gson.fromJson(gsonStr[i], Person.class);
				sb.append(p==null?"NULL":p.show());
				System.out.println(sb.toString());
			} catch (Exception e) {
				sb.append(e.getClass().getName());
			}
		}
	}
}
