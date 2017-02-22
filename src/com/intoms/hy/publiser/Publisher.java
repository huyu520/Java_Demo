package com.intoms.hy.publiser;

public class Publisher {

	public String id ;
	public String name ;
	
	public Publisher(String name) {
		this.id = Util.generateRandomId(4) ;
		this.name = name ;
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
