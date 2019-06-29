package com.agree.xml2java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class GetXmlRoot {
	public static void getRoot() throws DocumentException {
		// 先读xml文件，生成一个document实例
		SAXReader saxReader = new SAXReader();
		// 读取Xml文件
		Document document = saxReader.read("token.xml");
		// 得到xml文档根节点元素
		Element xmlRoot = document.getRootElement();
		// 获取根节点的子节点
		List<Element> listRootElements = xmlRoot.elements();
		
		for (int i = 0; i < listRootElements.size(); i++) {
			System.out.println(listRootElements.get(i).getName().toString());
			List<Element> list = listRootElements.get(i).elements();
			if (list.size() == 0) {
				continue;
			} else {
				getRoot();
			}
		}
	}

	public static void main(String[] args) throws DocumentException {
			
			// 先读xml文件，生成一个document实例
			SAXReader saxReader = new SAXReader();
			// 读取Xml文件
			Document document = saxReader.read("token.xml");
			// 得到xml文档根节点元素
			Element xmlRoot = document.getRootElement();
			// 获取根节点的子节点
			List<Element> listRootElements = xmlRoot.elements();
			Element element = xmlRoot.element("Implementation");
			List<Element> contactList = element.elements();
			for (Element e:contactList){
				            System.out.println(e.getName());
				            System.out.println(e.getStringValue());
				         }    
		
		
	}
}
