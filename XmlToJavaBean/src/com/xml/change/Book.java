package com.xml.change;

import java.io.StringReader;  
import java.io.StringWriter;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;




@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@XmlType(name = "book", propOrder = { "author", "price", "caledar", "id"})
public class Book {
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	@XmlElement(required = true)
	private String author;
	@XmlElement(name = "price_1", required = true)
	private float price;
	@XmlElement
	private Date caledar;
	@XmlAttribute
	private Integer id;
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Date getCaledar() {
		return caledar;
	}
	public void setCaledar(Date caledar) {
		this.caledar = caledar;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Book [author=" + author + ", price=" + price + ", caledar=" + caledar + ", id=" + id + "]";
	}
	
}