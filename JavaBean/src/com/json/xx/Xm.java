package com.json.xx;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Xm {
	public void analysisXML() throws DocumentException {
		SAXReader saxread = new SAXReader();
		File xmlFile = new File("idcMonitor.xml");
		if (xmlFile.exists()) {
			Document document = saxread.read(xmlFile);// 读取XML文件
			List<Element> houseMonitorList = document.selectNodes("//idcMonitor/houseMonitor"); // 找到位于idcMonitor下的houseMonitor节点
			for (int i = 0; i < houseMonitorList.size(); i++) {
				Element houseMonitor = houseMonitorList.get(i);
				Element id = (Element) houseMonitor.selectSingleNode("id"); // 获得houseMonitor节点下的id值
				System.out.println(id.getName() + "   " + id.getTextTrim());
				Element ip = (Element) houseMonitor.selectSingleNode("ip"); // 获得houseMonitor节点下的ip值
				System.out.println(ip.getName() + "   " + ip.getTextTrim());
				Element port = (Element) houseMonitor.selectSingleNode("port"); // 获得houseMonitor节点下的port值
				System.out.println(port.getName() + "   " + port.getTextTrim());
				Element domain = (Element) houseMonitor.selectSingleNode("domain"); // 获得houseMonitor节点下的domain值
				System.out.println(domain.getName() + "   " + domain.getTextTrim());
				Element serviceType = (Element) houseMonitor.selectSingleNode("serviceType"); // 获得houseMonitor节点下的serviceType值
				System.out.println(serviceType.getName() + "   " + serviceType.getTextTrim());
				Element firstFound = (Element) houseMonitor.selectSingleNode("firstFound"); // 获得houseMonitor节点下的firstFound值
				System.out.println(firstFound.getName() + "   " + firstFound.getTextTrim());
				Element lastFound = (Element) houseMonitor.selectSingleNode("lastFound"); // 获得houseMonitor节点下的lastFound值
				System.out.println(lastFound.getName() + "   " + lastFound.getTextTrim());
				Element illegalInfo = (Element) houseMonitor.selectSingleNode("illegalInfo");// 获得houseMonitor节点下的illegalInfo值
				Iterator<Element> illegalInfoIterator = illegalInfo.elementIterator();
				while (illegalInfoIterator.hasNext()) {
					Element temporary = illegalInfoIterator.next();
					System.out.println(temporary.getName() + "   " + temporary.getTextTrim());
				}
				Element ipInfo = (Element) houseMonitor.selectSingleNode("ipInfo");// 获得houseMonitor节点下的ipInfo值
				Iterator<Element> ipInfoIterator = ipInfo.elementIterator();
				while (ipInfoIterator.hasNext()) {
					Element temporary = ipInfoIterator.next();
					System.out.println(temporary.getName() + "   " + temporary.getTextTrim());
				}

				System.out.println("---------------------");
			}
		}
	}

	public static void main(String[] args) throws DocumentException {
		Xm xm = new Xm();
		xm.analysisXML();
	}
}
