package com.intoms.hy.demo;

public class Student {
	
	public String name ;
	
	public String account ;
	
	public String password ;
	
	public double weight ;
	
	public double height ;
	
	public Student(String account ,String password){
		this.account = account ;
		this.password = password ;
	}
	
	public Student(String account ,String password,String name ,double height,double weight){
		this(account, password);
		this.height = height ;
		this.weight = weight ;
		this.name = name ;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	public String calcuBMI(){
		double bim = weight/(height*height) ;
		if(bim < 0){
			bim = -bim ;
		}
		
		if(bim < 18.5) {
			return getName() + ":过轻";
		}else if(bim < 24.99) {
			return getName() +"正常" ;
		}else if( bim < 28){
			return getName() +"过重";
		}else if (bim < 32) {
			return getName() +"肥胖" ;
		}else{
			return getName() +"过于肥胖";
		}
	}
	
	@Override
	public String toString() {
		return name + ":" + calcuBMI() ;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student){
			Student student = (Student)obj;
			if(student.getAccount().equals(account)&&student.getPassword().equals(password)){
				return true ;
			}else {
				return false ;
			}
		}
		return false ;
	}
}
