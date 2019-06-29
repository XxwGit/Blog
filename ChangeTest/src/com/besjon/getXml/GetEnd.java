package com.besjon.getXml;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class GetEnd {
	public String getEndId(String fileString) throws DocumentException {
		String endString = null;
		SAXReader saxread = new SAXReader();
		File xmlFile = new File("token.xml");
		if (xmlFile.exists()) {
			Document document = saxread.read(xmlFile);// 读取XML文件
			List<Element> nodeElements = document.selectNodes("//Component/Implementation/Node");
			for (int i = 0; i < nodeElements.size(); i++) {
				Element node = nodeElements.get(i);
				Element name = (Element) node.selectSingleNode("Name");
				if (name.getTextTrim().equals("正常结束")) {
					Element id = (Element) node.selectSingleNode("Id");
					endString = id.getTextTrim();
		
				}
				
			}
		}
		return endString;
	}
}
