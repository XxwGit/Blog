package com.xml.change;

public class ReadXml {

	public static void main(String[] args) {
		String str = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" + "<book id=\"100\">"
				+ "    <author>James</author>" + "<calendar>2013-03-29T09:25:56.004+08:00</calendar>"
				+ "    <price_1>23.45</price_1>" + "</book>";
		Book book = JaxbUtil.converyToJavaBean(str, Book.class);
		
		System.out.println(book);
	}
}
