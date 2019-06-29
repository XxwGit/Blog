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
			Document document = saxread.read(xmlFile);// ��ȡXML�ļ�
			List<Element> houseMonitorList = document.selectNodes("//idcMonitor/houseMonitor"); // �ҵ�λ��idcMonitor�µ�houseMonitor�ڵ�
			for (int i = 0; i < houseMonitorList.size(); i++) {
				Element houseMonitor = houseMonitorList.get(i);
				Element id = (Element) houseMonitor.selectSingleNode("id"); // ���houseMonitor�ڵ��µ�idֵ
				System.out.println(id.getName() + "   " + id.getTextTrim());
				Element ip = (Element) houseMonitor.selectSingleNode("ip"); // ���houseMonitor�ڵ��µ�ipֵ
				System.out.println(ip.getName() + "   " + ip.getTextTrim());
				Element port = (Element) houseMonitor.selectSingleNode("port"); // ���houseMonitor�ڵ��µ�portֵ
				System.out.println(port.getName() + "   " + port.getTextTrim());
				Element domain = (Element) houseMonitor.selectSingleNode("domain"); // ���houseMonitor�ڵ��µ�domainֵ
				System.out.println(domain.getName() + "   " + domain.getTextTrim());
				Element serviceType = (Element) houseMonitor.selectSingleNode("serviceType"); // ���houseMonitor�ڵ��µ�serviceTypeֵ
				System.out.println(serviceType.getName() + "   " + serviceType.getTextTrim());
				Element firstFound = (Element) houseMonitor.selectSingleNode("firstFound"); // ���houseMonitor�ڵ��µ�firstFoundֵ
				System.out.println(firstFound.getName() + "   " + firstFound.getTextTrim());
				Element lastFound = (Element) houseMonitor.selectSingleNode("lastFound"); // ���houseMonitor�ڵ��µ�lastFoundֵ
				System.out.println(lastFound.getName() + "   " + lastFound.getTextTrim());
				Element illegalInfo = (Element) houseMonitor.selectSingleNode("illegalInfo");// ���houseMonitor�ڵ��µ�illegalInfoֵ
				Iterator<Element> illegalInfoIterator = illegalInfo.elementIterator();
				while (illegalInfoIterator.hasNext()) {
					Element temporary = illegalInfoIterator.next();
					System.out.println(temporary.getName() + "   " + temporary.getTextTrim());
				}
				Element ipInfo = (Element) houseMonitor.selectSingleNode("ipInfo");// ���houseMonitor�ڵ��µ�ipInfoֵ
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
