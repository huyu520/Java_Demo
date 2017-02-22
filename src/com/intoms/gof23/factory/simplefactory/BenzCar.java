/**
 * 
 */
package com.intoms.gof23.factory.simplefactory;

import java.util.Random;

/**
 *  CopyRight by 2016 Mfish
 *  All Right Reserved
 *	
 *  @author hy
 *	Create on 2016年11月24日上午11:38:00
 */
public class BenzCar implements Car {
	
	private String name ;
	private String id;
	private Integer oil;
	private boolean isAvalibale ;
	
	public static BenzCar instance = new BenzCar();
	
	public static BenzCar getInstance(){
	   	return instance;
	}
	private BenzCar() {
		this.name = "defaultName";
		this.id = String.valueOf(new Random().nextInt(100000000));
		this.oil = 0 ;
		this.isAvalibale = false ;
	}
	
	@Override
	public void driver(String name) {
		System.out.println(name + "正在开车!");
	}

	@Override
	public void addOil(int length) {
		System.out.println();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	//加油
	public void addOil(Integer num){
		int oldNum = this.getOil();
		oldNum += num ;
		this.setOil(oldNum);
	}
	public Integer getOil() {
		return oil;
	}

	public void setOil(Integer oil) {
		this.oil = oil;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isAvalibale() {
		return isAvalibale;
	}
	
	public void setAvalibale(boolean isAvalibale) {
		this.isAvalibale = isAvalibale;
	}
	
	//获取***车牌号码
	public String getHiddenId(){
		String hiddenId = this.getId().substring(0, 3);
		for(int i = 0 ;i < 3 ; i++){
			hiddenId += "*";
		}
		hiddenId += this.getId().substring(6);
		return hiddenId ;
	}
	
	//通过使车牌生效
	public void setIdvalue(boolean flag){
		if(this.isAvalibale == false){
			this.setAvalibale(true);
		}else{
			this.setAvalibale(false);
		}
	}
}
