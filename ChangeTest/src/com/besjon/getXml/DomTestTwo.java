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
		
		//����DocumentBuilderFactory����  
        DocumentBuilderFactory a = DocumentBuilderFactory.newInstance();  
        try {  
            //����DocumentBuilder����  
            DocumentBuilder b = a.newDocumentBuilder();  
            //ͨ��DocumentBuilder�����parse��������һ��Document����  
            Document document = b.parse("token.xml");  
            //ͨ��Document�����getElementsByTagName()�����ڵ��һ��list����  
            
            NodeList nodeList = document.getElementsByTagName("Node");  
            NodeList componentList = document.getElementsByTagName("Connection");
            for (int i = 0; i < componentList.getLength(); i++) {
				System.out.println("id:"+document.getElementsByTagName("targetId").item(i).getFirstChild().getNodeValue());
				
            }
            for(int i =0; i<nodeList.getLength(); i++){
            	System.out.println("========��ʼ������"+(i+1)+"����========");
            	
            	//��ȡid������ֵ
            	System.out.println("id:"+document.getElementsByTagName("Id").item(i).getFirstChild().getNodeValue());
            	//��ȡname������ֵ
            	System.out.println("name:"+document.getElementsByTagName("Name").item(i).getFirstChild().getNodeValue());
            	//��ȡauthor������ֵ
            	System.out.println("author:"+document.getElementsByTagName("Desp").item(i).getFirstChild().getNodeValue());
            	//��ȡyear������ֵ
            	System.out.println("year:"+document.getElementsByTagName("Type").item(i).getFirstChild().getNodeValue());
            	//��ȡprice������ֵ
            	System.out.println("price:"+document.getElementsByTagName("Target").item(i).getFirstChild().getNodeValue());
                
                System.out.println("========����������"+(i+1)+"����========");
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
