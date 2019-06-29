package com.besjon.getXml;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class GetOutArgs {
	public List<Map<String, String>> name(String fileString) throws DocumentException {
		List<Map<String, String>> listmaps = new ArrayList<Map<String, String>>();
		SAXReader saxread = new SAXReader();
		File xmlFile = new File(fileString);
		if (xmlFile.exists()) {
			Document document = saxread.read(xmlFile);// ¶ÁÈ¡XMLÎÄ¼þ
			List<Element> nodeElements = document.selectNodes("//Component/OutArgs/Arg");
			for (int i = 0; i < nodeElements.size(); i++) {
				Map<String, String> map = new HashMap<String, String>();
				Element node = nodeElements.get(i);
				Element name = (Element) node.selectSingleNode("Key");
				Element type = (Element) node.selectSingleNode("DefValue");
				Element description = (Element) node.selectSingleNode("Desp");
				Element example = (Element) node.selectSingleNode("Key");
				Element value = (Element) node.selectSingleNode("Key");
				if (name == null) {
					map.put("name", "");
				} else {
					map.put("name", name.getTextTrim());
				}
				if (type == null) {
					map.put("type", "");
				} else {
					map.put("type", type.getTextTrim());
				}
				if (description == null) {
					map.put("description", "");
				} else {
					map.put("description", description.getTextTrim());
				}
				if (example == null) {
					map.put("example", "");
				} else {
					map.put("example", "");
				}
				if (value == null) {
					map.put("value", "");
				} else {
					map.put("value", "");
				}

				
				
				
				
				listmaps.add(map);
				// Element type = node.selectSingleNode("");
			}
		}
		return listmaps;
	}

	public static void main(String[] args) throws DocumentException {
		GetOutArgs getArgs = new GetOutArgs();
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		list = getArgs.name("token.xml");
		for (int i = 0; i < list.size(); i++) {
			Map<String, String> map = list.get(i);
			for (String key : map.keySet()) {
				System.out.println("key= " + key + " and value= " + map.get(key));
			}
			System.out.println("-----------------------");
		}
	}
}
