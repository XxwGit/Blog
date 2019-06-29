package com.xml.useful;

import javax.xml.bind.annotation.XmlRootElement;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

/**
 *
 * @author BYSocket
 * 报文头-[报文基础信息]
 */
@XmlRootElement(name = "data_bean")
public class DataBean
{
    // 版本信息(data_version)
	@JSONField(name = "vv")
    String version;

    ////消息类型(data_type)
    // 000001 - 注册[个人信息Post|Respose]
    // 000002 - 绑定银行卡[首次绑定，保存个人信息]
    // 000003 - 绑定银行卡[二次，校验个人信息]
    // 100001 - 支付[钱包支付]
    // 100002 - 查询
    // 200001
    String data_type;
     
    ////订单编号(order_id)
    // 总长20位, 有字母要用大写
    String batch_no;
     
    // 平台账号(platform_account)
    String user_name;
     

     
    // 签名信息(msg_sign)
    String msg_sign;
 
    // 时间戳(randomTime)
    private String rd_time;
 
    // 随机数(randomNum)
    private String rd_num;
 
    // 密钥(keySign)
    private String k_sign;
 
    public String getVersion()
    {
        return version;
    }
 
    public void setVersion(String v)
    {
        this.version = v;
    }
 
    public String getData_type()
    {
        return data_type;
    }
 
    public void setData_type(String data_type)
    {
        this.data_type = data_type;
    }
 
    public String getBatch_no()
    {
        return batch_no;
    }
 
    public void setBatch_no(String batch_no)
    {
        this.batch_no = batch_no;
    }
 
    public String getUser_name()
    {
        return user_name;
    }
 
    public void setUser_name(String user_name)
    {
        this.user_name = user_name;
    }
 
  
 
    public String getMsg_sign()
    {
        return msg_sign;
    }
 
    public void setMsg_sign(String msg_sign)
    {
        this.msg_sign = msg_sign;
    }
 
    public String getRd_time()
    {
        return rd_time;
    }
 
    public void setRd_time(String rd_time)
    {
        this.rd_time = rd_time;
    }
 
    public String getRd_num()
    {
        return rd_num;
    }
 
    public void setRd_num(String rd_num)
    {
        this.rd_num = rd_num;
    }
 
    public String getK_sign()
    {
        return k_sign;
    }
 
    public void setK_sign(String k_sign)
    {
        this.k_sign = k_sign;
    }
	

	public String tojson() {
    	return  JSONObject.toJSON(this).toString();
	}
 
}
