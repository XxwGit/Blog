package com.besjon.getXml;


import java.io.IOException;
 
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
 
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
 
 
 
public class DomTestTwo {
 
	public static void main(String[] args) {
		
		//创建DocumentBuilderFactory对象  
        DocumentBuilderFactory a = DocumentBuilderFactory.newInstance();  
        try {  
            //创建DocumentBuilder对象  
            DocumentBuilder b = a.newDocumentBuilder();  
            //通过DocumentBuilder对象的parse方法返回一个Document对象  
            Document document = b.parse("token.xml");  
            //通过Document对象的getElementsByTagName()返根节点的一个list集合  
            
            NodeList nodeList = document.getElementsByTagName("Node");  
            NodeList componentList = document.getElementsByTagName("Connection");
            for (int i = 0; i < componentList.getLength(); i++) {
				System.out.println("id:"+document.getElementsByTagName("targetId").item(i).getFirstChild().getNodeValue());
				
            }
            for(int i =0; i<nodeList.getLength(); i++){
            	System.out.println("========开始遍历第"+(i+1)+"本书========");
            	
            	//获取id的属性值
            	System.out.println("id:"+document.getElementsByTagName("Id").item(i).getFirstChild().getNodeValue());
            	//获取name的属性值
            	System.out.println("name:"+document.getElementsByTagName("Name").item(i).getFirstChild().getNodeValue());
            	//获取author的属性值
            	System.out.println("author:"+document.getElementsByTagName("Desp").item(i).getFirstChild().getNodeValue());
            	//获取year的属性值
            	System.out.println("year:"+document.getElementsByTagName("Type").item(i).getFirstChild().getNodeValue());
            	//获取price的属性值
            	System.out.println("price:"+document.getElementsByTagName("Target").item(i).getFirstChild().getNodeValue());
                
                System.out.println("========结束遍历第"+(i+1)+"本书========");
            }  
        } catch (ParserConfigurationException e) {  
            e.printStackTrace();  
        } catch (SAXException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } 
	}
 
}
