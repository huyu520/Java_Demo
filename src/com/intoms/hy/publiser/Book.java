package com.intoms.hy.publiser;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Book implements Comparable<Book> {

	private String id ;
	private String name ;
	private String author ;
	private double price ;
	private Date pubDate ;
	private Publisher publisher ;
	private Catagory catagory ;
	
	public final String style = "yyyy-MM-dd hh:mm:ss" ;
	
	private DateFormat fomart = new SimpleDateFormat(style);
	
	public Book( String id,String name, String author, double price, Date pubDate, Publisher publisher,
			Catagory catagory) {
		super();
		this.id = id ;
		this.name = name;
		this.author = author;
		this.price = price;
		this.pubDate = pubDate;
		this.publisher = publisher;
		this.catagory = catagory;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getPubDate() {
		return pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public Catagory getCatagory() {
		return catagory;
	}

	public void setCatagory(Catagory catagory) {
		this.catagory = catagory;
	}

	public DateFormat getFomart() {
		return fomart;
	}

	public void setFomart(DateFormat fomart) {
		this.fomart = fomart;
	}

	public String getStyle() {
		return style;
	}

	@Override
	public int compareTo(Book o) {
		
		if(pubDate.after(o.pubDate)){
			return 1;
		}
		else if (pubDate.before(o.pubDate)) {
			return -1 ;
		}
		else{
			return 0;
		}
	}

	@Override
	public String toString() {
		return id + "\t" + name + "\t" + author + "\t" + price + "\t" + fomart.format(pubDate) + "\t" + publisher.getName() + "\t" + catagory.getName();
	}
}
