package com.besjon.getXml;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class GetEndStep {
	public Map<String, String> GetGeometry(String fileString) throws DocumentException {
		Map<String, String> map = new HashMap<String, String>();
		SAXReader saxread = new SAXReader();
		File xmlFile = new File(fileString);
		if (xmlFile.exists()) {
			Document document = saxread.read(xmlFile);// 读取XML文件
			List<Element> nodeElements = document.selectNodes("//Component/Implementation/Node");
			for (int i = 0; i < nodeElements.size(); i++) {
				Element node = nodeElements.get(i);
				Element name = (Element) node.selectSingleNode("Name"); // 获得houseMonitor节点下的id值
				if (name.getTextTrim().equals("正常结束")) {
					Element Constraint = (Element) node.selectSingleNode("Constraint");
					Iterator<Element> ConstraintIterator = Constraint.elementIterator();
					while (ConstraintIterator.hasNext()) {
						Element temporary = ConstraintIterator.next();
						if (temporary.getName().equals("Location")) {
							String locationString=temporary.getTextTrim();
							String[]strings = locationString.split(",");
							map.put("x", strings[0]);
							map.put("y", strings[1]);
						}else if (temporary.getName().equals("Size")) {
							String sizeString = temporary.getTextTrim();
							String[] strings = sizeString.split(",");
							map.put("width", strings[0]);
							map.put("height", strings[1]);
						}
						//System.out.println(temporary.getName() + "   " + temporary.getTextTrim());
					}
				}
			}
		}
		return map;
	}
	
	
	
	public static void main(String[] args) throws DocumentException {
		GetEndStep getEndStep = new GetEndStep();
		Map<String, String> map = getEndStep.GetGeometry("token.xml");
		for (String key : map.keySet()) {
			System.out.println("key= "+ key + " and value= " + map.get(key));
		}
	}
}
