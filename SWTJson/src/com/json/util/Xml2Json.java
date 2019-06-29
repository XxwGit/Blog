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
		return JSONObject.fromObject(jsonString).toString().replace("[]", "\"\"");
	}
	
	public static void main(String[] args) {
		Xml2Json xml2Json = new Xml2Json();
		System.out.println(xml2Json.XmlToJson("MsgRegBean [dataBean=DataBean [v=v1.0, data_type=000001, batch_no=N20150204, user_name=xx, trans_state=null, msg_sign=未知, rd_time=20150204, rd_num=6631383, k_sign=75CC479AAC09F00BA28F0E968B1BC9D1B90ADCC2, reserve=null], regBeans=[RegBean [reg_sn=REG20150204, user_id=12, reg_no=33, reg_way=pc, reserve=null, set_time=20150204 16:18, ret_url=未知, remarks=无备注], RegBean [reg_sn=REG20150204, user_id=12, reg_no=33, reg_way=pc, reserve=null, set_time=20150204 16:18, ret_url=未知, remarks=无备注]]]"));
	}
}
