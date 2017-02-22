package com.intoms.hy.publiser;

public class Catagory {
	private String id ;
	private String name ;
	
	public Catagory(String name) {
		this.id = Util.generateRandomId(6);
		this.name = name;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
