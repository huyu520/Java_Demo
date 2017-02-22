package com.intoms.hy.publiser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Test {
	public static List<Book> booksList = new ArrayList<>() ;
	
	static{
		Publisher p1 = new Publisher( "人名出版社");
		Publisher p2 = new Publisher( "湖南出版社");
		Publisher p3 = new Publisher( "清华出版社");
		Publisher p4 = new Publisher( "华东出版社");
		
		Catagory c1 = new Catagory("文学") ;
		Catagory c2 = new Catagory("军事") ;
		Catagory c3 = new Catagory("计算机") ;
		
		Book b1 = new Book(Util.generateRandomId(10),"图书111", "鲁迅", 12.5, new Date(), p1, c1);
		Book b2 = new Book(Util.generateRandomId(10),"图书222", "张三", 23.5, new Date(), p2, c1);
		Book b3 = new Book(Util.generateRandomId(10),"图书333", "李四", 54.5, new Date(), p3, c1);
		Book b4 = new Book(Util.generateRandomId(10),"图书444", "timo", 2.5, new Date(), p4, c1);
		Book b5 = new Book(Util.generateRandomId(10),"图书555", "hy", 1.5, new Date(), p1, c1);
		Book b6 = new Book(Util.generateRandomId(10),"图书666", "yake", 9.5, new Date(), p1, c2);
		Book b7 = new Book(Util.generateRandomId(10),"图书777", "vn", 3.5, new Date(), p1, c3);
		Book b8 = new Book(Util.generateRandomId(10),"图书888", "huni", 59.5, new Date(), p1, c3);
		
		booksList.add(b1);
		booksList.add(b2);
		booksList.add(b3);
		booksList.add(b4);
		booksList.add(b5);
		booksList.add(b6);
		booksList.add(b7);
		booksList.add(b8);
	}
	
	public static void main(String[] args) {
		methed();
		System.out.println("***********************************************");
		methed1("人名出版社");
		System.out.println("***********************************************");
		methed2(3.5,22.0);
		System.out.println("***********************************************");
		methed3("计算机");
	}
	
	public static void methed(){
		Collections.sort(booksList);
		for(Book book : booksList){
			System.out.println(book.toString());
		}
	}
	
	//打印指定出版社的所有的图书的信息
	public static void methed1(String pubName){
		for(Book book : booksList){
			if(book.getPublisher().getName().equals(pubName)){
				System.out.println(book.toString());
			}
		}
	}
	
	//打印指定价格趋于的所有的图书信息
	public static void methed2(double minPrice ,double maxPrice){
		for(Book book : booksList){
			if(minPrice <= book.getPrice() && maxPrice >= book.getPrice()){
				System.out.println(book);
			}
		}
	}
	
	//删除指定类别的图书
	public static void methed3(String cataName){
		List<Book> removeBook = new ArrayList<>();
		for(Book book :booksList){
			if(book.getCatagory().getName().equals(cataName)){
				removeBook.add(book) ;
			}
		}
		booksList.removeAll(removeBook);
		System.out.println("-------------------------");
		methed();
	}
}
