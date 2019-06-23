package com.json.util;

import net.sf.json.JSONObject;
import net.sf.json.xml.XMLSerializer;
//½«
public class Xml2Json {
	public String XmlToJson(String string) {
		GetXml getXml = new GetXml();
		String xml = getXml.turnDocumentToString(string);
		XMLSerializer xmlSerializer = new XMLSerializer();
		String jsonString = xmlSerializer.read(xml).toString();
		return JSONObject.fromObject(jsonString).toString();
	}
}
