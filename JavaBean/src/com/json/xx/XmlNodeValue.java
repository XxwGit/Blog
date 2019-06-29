package com.json.xx;
import java.io.ByteArrayInputStream;
 
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
 
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
 
public class XmlNodeValue {
	
	
	public static String getStringFile(String xml) throws Exception {
    	String downupload = "";
 
        String statusResult = ""; // 存放应答消息中<status>元素的result属性
        String statusText = ""; // 存放应答消息中<status>元素的text
 
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new ByteArrayInputStream(xml.getBytes()));
 
        // xml中元素的变量命名均以_符号起始.下同
        Element _message = doc.getDocumentElement();
 
        // 取二级元素content
        NodeList _contentList = _message.getElementsByTagName("content");
        
        for (int i = 0; i < _contentList.getLength(); i++) {
			
		}
        
        if (_contentList.getLength() == 1) {
            Element _content = (Element) _contentList.item(0);
 
            // 取三级元素status
            NodeList _statusList = _content.getElementsByTagName("status");
            if (_statusList.getLength() == 1) {
                Element _status = (Element) _statusList.item(0);
                Text t = (Text) _status.getFirstChild();
                statusText = t.getNodeValue();
                statusResult = _status.getAttribute("result");
            }
 
            if (statusResult.equals("exception") || statusResult.equals("error")) {
                System.out.println(statusText);
                throw new Exception(statusText);
            } else if (statusResult.equals("normal")) {
            	downupload = _content.getElementsByTagName("resultPath").item(0).getFirstChild().getNodeValue();
            	//resultPath节点的value值
            	System.out.println("resultPath节点的value值:" + downupload);
            }
        }
        return downupload;
    }
	
	public static void main(String[] args) throws Exception {
		String xml = "<?xml version=\"1.1\" encoding=\"gb2312\"?>"
				+ "<message>"
					+ "<function name=\"query\">query_bad_call_number_143_export</function>"
					+ "<service>call</service>"
					+ "<content>"
						+ "<status result=\"normal\">被操作对象:全部号码,OK</status>"
						+ "<resultPath>/home/abc/efd/datafile/file/doubtResult_143/doubt_result_143_20170901154904.xls</resultPath>"
					+ "</content>"
				+ "</message>";
		
		getStringFile(xml);
		
	}
 
}