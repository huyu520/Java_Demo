package com.intoms.collection;

public class Person implements Comparable<Person>{
	
	private String name ;
	private Integer id ;
	
	public Person(String name ,Integer id){
		this.id = id ;
		this.name = name ;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public int compareTo(Person o) {
		return this.getId()-o.getId();
	}
	
}
