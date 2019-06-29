package com.besjon.getXml;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class GetFileDescription {
	public Map<String, String> FileDescription(String fileString) throws DocumentException {
		Map<String, String> map = new HashMap<String, String>();
		SAXReader saxread = new SAXReader();
		File xmlFile = new File(fileString);
		if (xmlFile.exists()) {
			Document document = saxread.read(xmlFile);// 读取XML文件
			List<Element> nodeElements = document.selectNodes("//Component");
			for (int i = 0; i < nodeElements.size(); i++) {
				Element node = nodeElements.get(i);
				Element author = (Element) node.selectSingleNode("Auth"); // 获得houseMonitor节点下的id值
				Element function = (Element) node.selectSingleNode("RefImpl");
				Element remark = (Element) node.selectSingleNode("Desp");
				map.put("author", author.getTextTrim());
				map.put("function", function.getTextTrim());
				map.put("remark", remark.getTextTrim());
			}
		}
		return map;
	}
	public static void main(String[] args) throws DocumentException {
		GetFileDescription getFileDescription = new GetFileDescription();
		Map<String, String> map = getFileDescription.FileDescription("token.xml");
		 for (String key : map.keySet()) {
			System.out.println("key= "+ key + " and value= " + map.get(key));
		 }
	}
}
