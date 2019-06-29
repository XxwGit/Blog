package com.xml.bank;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class TestXStream {
	
	public static void main(String[] args) {
		try {
			String data="<?xml  version=\\\"1.0\\\" encoding=\\\"GBK\\\" standalone=\\\"no\\\" ?>\r\n" + 
					"<B2CRes>\r\n" + 
					"<interfaceName>ICBC_PERBANK_B2C</interfaceName>\r\n" + 
					"<interfaceVersion>1.0.0.11</interfaceVersion>\r\n" + 
					"<orderInfo>\r\n" + 
					"<orderDate>20100901162142</orderDate>\r\n" + 
					"<curType>001</curType>\r\n" + 
					"<merID>0200EC20001119</merID>\r\n" + 
					"<subOrderInfoList>\r\n" + 
					"<subOrderInfo>\r\n" + 
					"<orderid>0000144</orderid>\r\n" + 
					"<amount>100</amount>\r\n" + 
					"<installmentTimes>1</installmentTimes>\r\n" + 
					"<merAcct>0200026009018372212</merAcct>\r\n" + 
					"<tranSerialNo>HFG000000000000421</tranSerialNo>\r\n" + 
					"</subOrderInfo>\r\n" + 
					"<subOrderInfo>\r\n" + 
					"<orderid>201009011621421</orderid>\r\n" + 
					"<amount>120</amount>\r\n" + 
					"<installmentTimes>1</installmentTimes>\r\n" + 
					"<merAcct>0200026009018372212</merAcct>\r\n" + 
					"<tranSerialNo>HFG000000000000422</tranSerialNo>\r\n" + 
					"</subOrderInfo>\r\n" + 
					"</subOrderInfoList>\r\n" + 
					"</orderInfo>\r\n" + 
					"<custom>\r\n" + 
					"<verifyJoinFlag>0</verifyJoinFlag>\r\n" + 
					"<JoinFlag></JoinFlag>\r\n" + 
					"<UserNum></UserNum>\r\n" + 
					"</custom>\r\n" + 
					"<bank>\r\n" + 
					"<TranBatchNo>000000000000098</TranBatchNo>\r\n" + 
					"<notifyDate>20100910174050</notifyDate>\r\n" + 
					"<tranStat>1</tranStat>\r\n" + 
					"<comment>交易成功！</comment>\r\n" + 
					"</bank>\r\n" + 
					"</B2CRes>";
			XStream xStream = new XStream(new DomDriver());
			//设置了这个别名才能识别下面 xml 中的 类对象节点的别名，否则要用类全限名称   
			xStream.alias("B2CRes", B2CRes.class);
			xStream.alias("orderInfo", OrderInfo.class);
			xStream.alias("subOrderInfo", SubOrderInfo.class);
			xStream.alias("custom", Custom.class);
			xStream.alias("bank", Bank.class);
			B2CRes b2cres=(B2CRes)xStream.fromXML(data); 
			System.out.println("接口名称:"+b2cres.getInterfaceName());
			OrderInfo orderInfo=b2cres.getOrderInfo();
			System.out.println("商户账号:"+orderInfo.getMerID());
			SubOrderInfo subOrderInfo=orderInfo.getSubOrderInfoList()[0];
			System.out.println("支付订单ID："+subOrderInfo.getOrderid());
			System.out.println("银行序列号："+subOrderInfo.getTranSerialNo());
			Custom custom=b2cres.getCustom();
			System.out.println("检验联名标志:"+custom.getVerifyJoinFlag());
			Bank bank=b2cres.getBank();
			System.out.println("备注:"+bank.getComment());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
