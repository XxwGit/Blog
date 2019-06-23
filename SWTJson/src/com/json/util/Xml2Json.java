package com.json.util;

import net.sf.json.JSONObject;
import net.sf.json.xml.XMLSerializer;

//将xml转成json后将json数据以String的形式返回
public class Xml2Json {
	public String XmlToJson(String string) {
		GetXml getXml = new GetXml();
		String xml = getXml.turnDocumentToString(string);
		XMLSerializer xmlSerializer = new XMLSerializer();
		String jsonString = xmlSerializer.read(xml).toString();
		return JSONObject.fromObject(jsonString).toString();
	}
}
