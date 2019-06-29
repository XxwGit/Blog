package com.xml.useful;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.sun.org.apache.bcel.internal.generic.NEW;

import net.sf.json.JSONObject;

/**
 * 
 * @author BYSocket Jaxb2.0 处理Xml与Object转换
 *
 */
public class JaxbObjectAndXmlUtil {

	/**
	 * @param xmlStr 字符串
	 * @param c      对象Class类型
	 * @return 对象实例
	 */
	@SuppressWarnings("unchecked")
	public static <T> T xml2Object(String xmlStr, Class<T> c) {
		try {
			JAXBContext context = JAXBContext.newInstance(c);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			T t = (T) unmarshaller.unmarshal(new StringReader(xmlStr));
			return t;

		} catch (JAXBException e) {
			e.printStackTrace();
			return null;
		}

	}
	
	 /**
     * @param object 对象
     * @return 返回xmlStr
     */
    public static String object2Xml(Object object)
    { 
        try
        {   
            StringWriter writer = new StringWriter();
            JAXBContext context = JAXBContext.newInstance(object.getClass()); 
            Marshaller  marshal = context.createMarshaller();
             
            marshal.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // 格式化输出 
            marshal.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");// 编码格式,默认为utf-8 
            marshal.setProperty(Marshaller.JAXB_FRAGMENT, false);// 是否省略xml头信息 
            marshal.setProperty("jaxb.encoding", "utf-8"); 
            marshal.marshal(object,writer);
             
            return new String(writer.getBuffer());
             
        } catch (Exception e) { e.printStackTrace(); return null;}    
         
    } 

    
    
    @Test
    public void test() {
    	 /** 构造测试报文头对象 */
        DataBean dataBean = new DataBean();
        dataBean.setBatch_no("N20150204");
        dataBean.setData_type("000001");
        dataBean.setVersion("v1.0");
        dataBean.setUser_name("xx");
        dataBean.setMsg_sign("未知");
        dataBean.setRd_num("6631383");
        dataBean.setRd_time("20150204");
        dataBean.setK_sign("75CC479AAC09F00BA28F0E968B1BC9D1B90ADCC2");
 
        /** 构造测试报文体对象 */
        RegBean regBean = new RegBean();
        regBean.setReg_sn("REG20150204");
        regBean.setUser_id(12);
        regBean.setReg_no("33");
        regBean.setReg_way("pc");
        regBean.setSet_time("20150204 16:18");
        regBean.setRet_url("未知");
        regBean.setRemarks("无备注");
        RegBean regBean2 = new RegBean(); 
        MsgRegBean msgBean = new MsgRegBean();
        List<RegBean> regBeans = new ArrayList<RegBean>();
        regBeans.add(regBean);
        regBeans.add(regBean);
        regBeans.add(regBean2);
        
        
        msgBean.setStart("");
        msgBean.setRegBeans(regBeans);
        msgBean.setDataBean(dataBean);
         
        String xmlStr = JaxbObjectAndXmlUtil.object2Xml(msgBean);//构造报文 XML 格式的字符串
        System.out.println("对象转xml报文： \n"+xmlStr);
    }
    
    
	public static void main(String[] args) {
		MsgRegBean msgBean2 = JaxbObjectAndXmlUtil
				.xml2Object("<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"yes\"?>\r\n" + 
						"<msg_bean>\r\n" + 
						"    <data_bean>\r\n" + 
						"        <batch_no>N20150204</batch_no>\r\n" + 
						"        <data_type>000001</data_type>\r\n" + 
						"        <k_sign>75CC479AAC09F00BA28F0E968B1BC9D1B90ADCC2</k_sign>\r\n" + 
						"        <msg_sign>未知</msg_sign>\r\n" + 
						"        <rd_num>6631383</rd_num>\r\n" + 
						"        <rd_time>20150204</rd_time>\r\n" + 
						"        <user_name>xx</user_name>\r\n" + 
						"        <version>v1.0</version>\r\n" + 
						"    </data_bean>\r\n" + 
						"    <reg_beans>\r\n" + 
						"        <reg_bean>\r\n" + 
						"            <reg_no>33</reg_no>\r\n" + 
						"            <reg_sn>REG20150204</reg_sn>\r\n" + 
						"            <reg_way>pc</reg_way>\r\n" + 
						"            <remarks>无备注</remarks>\r\n" + 
						"            <ret_url>未知</ret_url>\r\n" + 
						"            <set_time>20150204 16:18</set_time>\r\n" + 
						"            <user_id>12</user_id>\r\n" + 
						"        </reg_bean>\r\n" + 
						"        <reg_bean>\r\n" + 
						"            <reg_no>33</reg_no>\r\n" + 
						"            <reg_sn>REG20150204</reg_sn>\r\n" + 
						"            <reg_way>pc</reg_way>\r\n" + 
						"            <remarks>无备注</remarks>\r\n" + 
						"            <ret_url>未知</ret_url>\r\n" + 
						"            <set_time>20150204 16:18</set_time>\r\n" + 
						"            <user_id>12</user_id>\r\n" + 
						"        </reg_bean>\r\n" + 
						"    </reg_beans>\r\n" + 
						"</msg_bean>", MsgRegBean.class);
		System.out.println(msgBean2.getDataBean().toString());
		String string = JSON.toJSONString(msgBean2);
		
		FormatUtil formatUtil = new FormatUtil();
		System.out.println("xml转json： \n" + formatUtil.formatJson(string));
	}
}