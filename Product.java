package System;

import java.util.ArrayList;

public class Product {
	private String name;
	private Publisher publisher;
	private String publishdate;
	private String plot;
	private double price;
	private ArrayList <String> Comment =new ArrayList<String>();
	
	
	
	public Product(String name, Publisher publisher, String publishdate, String plot, double price) {
		super();
		this.name = name;
		this.publisher = publisher;
		this.publishdate = publishdate;
		this.plot = plot;
		this.price = price;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Publisher getPublisher() {
		return publisher;
	}



	


	public String getPublishdate() {
		return publishdate;
	}



	



	public String getPlot() {
		return plot;
	}



	



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public ArrayList<String> getComment() {
		return Comment;
	}



	

	

	

}
