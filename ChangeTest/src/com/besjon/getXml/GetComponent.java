package com.besjon.getXml;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class GetComponent {
	public List<Map<String, Object>> Component(String fileString) throws DocumentException {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			SAXReader saxread = new SAXReader();
			File xmlFile = new File(fileString);
			if (xmlFile.exists()) {
				Document document = saxread.read(xmlFile);// 读取XML文件
				List<Element> nodeElements = document.selectNodes("//Component/Implementation/Node");
				for (int i = 0; i < nodeElements.size(); i++) {
					Element node = nodeElements.get(i);
					Element id = (Element) node.selectSingleNode("Id");
					Element caption = (Element) node.selectSingleNode("Name");
					Element name = (Element) node.selectSingleNode("Target");
					if (!(caption.getTextTrim().equals("开始")) && !caption.getTextTrim().equals("正常结束")) {
						Map<String, Object> map = new HashMap<String, Object>();
						map.put("componentId", id.getTextTrim());
						map.put("componentCaption", caption.getTextTrim());
						map.put("componentName", name.getTextTrim());
						map.put("componentShowId", id.getTextTrim());
						//获取geomery
						Element Constraint = (Element) node.selectSingleNode("Constraint");
						Iterator<Element> ConstraintIterator = Constraint.elementIterator();
						while (ConstraintIterator.hasNext()) {
							Element temporary = ConstraintIterator.next();
							if (temporary.getName().equals("Location")) {
								String locationString = temporary.getTextTrim();
								String[] strings = locationString.split(",");
								map.put("x", strings[0]);
								map.put("y", strings[1]);
							} else if (temporary.getName().equals("Size")) {
								String sizeString = temporary.getTextTrim();
								String[] strings = sizeString.split(",");
								map.put("width", strings[0]);
								map.put("height", strings[1]);
							}
							//获取InArgs
							List<Map<String, String>> inArgsList = new ArrayList<Map<String, String>>();
							List<Element> inArgsrgElements = node.selectNodes("InArgs/Arg");
							for (int j = 0; j < inArgsrgElements.size(); j++) {
								Map<String, String> inArgMap = new HashMap<String, String>();
								Element inArgNode = inArgsrgElements.get(j);
								Element inArgName = (Element) inArgNode.selectSingleNode("Key");
								Element inArgCaption = (Element) inArgNode.selectSingleNode("Name");
								Element inArgDescription = (Element) inArgNode.selectSingleNode("Type");
								Element inArgValue = (Element) inArgNode.selectSingleNode("Arg");
								if (inArgValue==null) {
									inArgMap.put("inArgValue", "");
								}else {
									inArgMap.put("inArgValue", inArgValue.getTextTrim());
								}
								inArgMap.put("inArgName", inArgName.getTextTrim());
								inArgMap.put("inArgCaption", inArgCaption.getTextTrim());
								if (inArgDescription==null) {
									inArgMap.put("inArgDescription", "");
								}else {
									inArgMap.put("inArgDescription", inArgDescription.getTextTrim());
								}
								
								inArgMap.put("inArgExample", "");
								inArgMap.put("inArgEditor", "");
								inArgMap.put("inArgType", "");
								inArgMap.put("inArgRequired", "");
								inArgMap.put("inArgContains", "");
								inArgsList.add(inArgMap);
							
							}
							map.put("InArgs", inArgsList);
							
							//获取OutArgs
							List<Map<String, String>> outArgsList = new ArrayList<Map<String, String>>();
							List<Element> outArgElements = node.selectNodes("OutArgs/Arg");
							for (int j = 0; j < outArgElements.size(); j++) {
								Map<String, String> outArgMap = new HashMap<String, String>();
								Element outArgNode = outArgElements.get(j);
								Element outArgName = (Element) outArgNode.selectSingleNode("Key");
								Element outArgCaption = (Element) outArgNode.selectSingleNode("Name");
								Element outArgDescription = (Element) outArgNode.selectSingleNode("Type");
								Element outArgValue = (Element) outArgNode.selectSingleNode("Arg");
								if (outArgValue==null) {
									outArgMap.put("outArgValue", "");
								}else {
									outArgMap.put("outArgValue", outArgValue.getTextTrim());
								}
								outArgMap.put("outArgName", outArgName.getTextTrim());
								outArgMap.put("outArgCaption", outArgCaption.getTextTrim());
								if (outArgDescription==null) {
									outArgMap.put("outArgDescription", "");
								}else {
									outArgMap.put("outArgDescription", outArgDescription.getTextTrim());
								}
								
								outArgMap.put("outArgExample", "");
								outArgMap.put("outArgEditor", "");
								outArgMap.put("outArgType", "");
								outArgMap.put("outArgRequired", "");
								outArgMap.put("outArgContains", "");
								outArgsList.add(outArgMap);
							}
							map.put("OutArgs", outArgsList);
							
							
							//获取Out
							List<Map<String, String>> outList = new ArrayList<Map<String, String>>();
							List<Element> outElements = node.selectNodes("Terminals/Terminal");
							for (int j = 0; j < outElements.size(); j++) {
								Element outNode = outElements.get(j);
								Element outCaption = (Element) outNode.selectSingleNode("Desp");
								Element outName = (Element) outNode.selectSingleNode("Name");
								if (!outCaption.getTextTrim().equals("失败")) {
									Map<String, String> outMap = new HashMap<String, String>();
									outMap.put("outCaption", outCaption.getTextTrim());
									outMap.put("outName", outName.getTextTrim());
									outMap.put("outId", caption.getTextTrim());
									//判断next所需代码
									String nextString = null;
									List<Element> Connections = node.selectNodes("SourceConnections/Connection");
									for (int x = 0; x < Connections.size(); x++) {
										Element ConnectionNode = Connections.get(x);
										Element SourceTerminal = (Element) ConnectionNode.selectSingleNode("SourceTerminal");
										String sourceTerminalString = SourceTerminal.getTextTrim();
										if (sourceTerminalString.equals(outName.getTextTrim())) {
											Element targetId = (Element) ConnectionNode.selectSingleNode("targetId");
											nextString = targetId.getTextTrim();
										}
									}
									outMap.put("outNext", nextString);
									outList.add(outMap);
								}
							}
							map.put("Out", outList);
							//获取exception
							List<Map<String, String>> exceptionList = new ArrayList<Map<String, String>>();
							List<Element> exceptionElements = node.selectNodes("Terminals/Terminal");
							for (int j = 0; j < exceptionElements.size(); j++) {
								Element exceptionNode = exceptionElements.get(j);
								Element exceptionCaption = (Element) exceptionNode.selectSingleNode("Desp");
								Element exceptionName = (Element) exceptionNode.selectSingleNode("Name");
								if (exceptionCaption.getTextTrim().equals("失败")) {
									Map<String, String> exceptionMap = new HashMap<String, String>();
								
									exceptionMap.put("outName", exceptionName.getTextTrim());
								
									//判断next所需代码
									String nextString = null;
									List<Element> Connections = node.selectNodes("SourceConnections/Connection");
									for (int x = 0; x < Connections.size(); x++) {
										Element ConnectionNode = Connections.get(x);
										Element SourceTerminal = (Element) ConnectionNode.selectSingleNode("SourceTerminal");
										String sourceTerminalString = SourceTerminal.getTextTrim();
										if (sourceTerminalString.equals(exceptionName.getTextTrim())) {
											Element targetId = (Element) ConnectionNode.selectSingleNode("targetId");
											nextString = targetId.getTextTrim();
										}
									}
									exceptionMap.put("outNext", nextString);
									exceptionList.add(exceptionMap);
								}
							}
							map.put("Exception", exceptionList);
						}
						list.add(map);
					}

				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;

	}
	
	
	public static void main(String[] args) throws DocumentException {
		GetComponent getComponent = new GetComponent();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		list = getComponent.Component("token.xml");
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map = list.get(i);
			for (String key : map.keySet()) {
				System.out.println("key= " + key + " and value= " + map.get(key));
			}
			System.out.println("----------------");
		}

	}
}
