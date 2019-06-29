package com.besjon.getXml;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class GetStart {
	public String Start(String fileString) throws DocumentException {
		String start = null;
		SAXReader saxread = new SAXReader();
		File xmlFile = new File(fileString);
		if (xmlFile.exists()) {
			Document document = saxread.read(xmlFile);// 读取XML文件
			List<Element> nodeElements = document.selectNodes("//Component/Implementation/Node");
			for (int i = 0; i < nodeElements.size(); i++) {
				Element node = nodeElements.get(i);
				Element name = (Element) node.selectSingleNode("Name");
				if (name.getTextTrim().equals("开始")) {
					Element sourceConnections = (Element) node.selectSingleNode("SourceConnections/Connection");
					Iterator<Element> sourceConnectionsIterator = sourceConnections.elementIterator();
					while (sourceConnectionsIterator.hasNext()) {
						Element temporary = sourceConnectionsIterator.next();
						//System.out.println(temporary.getName() + "   " + temporary.getTextTrim());
						if (temporary.getName().equals("targetId")) {
							start=temporary.getTextTrim();
						}
						
					}
				}
				
			}
		}
		return start;
	}
}
