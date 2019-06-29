package com.xml.useful;

import javax.xml.bind.annotation.XmlRootElement;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

/**
 *
 * @author BYSocket
 * ����ͷ-[���Ļ�����Ϣ]
 */
@XmlRootElement(name = "data_bean")
public class DataBean
{
    // �汾��Ϣ(data_version)
	@JSONField(name = "vv")
    String version;

    ////��Ϣ����(data_type)
    // 000001 - ע��[������ϢPost|Respose]
    // 000002 - �����п�[�״ΰ󶨣����������Ϣ]
    // 000003 - �����п�[���Σ�У�������Ϣ]
    // 100001 - ֧��[Ǯ��֧��]
    // 100002 - ��ѯ
    // 200001
    String data_type;
     
    ////�������(order_id)
    // �ܳ�20λ, ����ĸҪ�ô�д
    String batch_no;
     
    // ƽ̨�˺�(platform_account)
    String user_name;
     

     
    // ǩ����Ϣ(msg_sign)
    String msg_sign;
 
    // ʱ���(randomTime)
    private String rd_time;
 
    // �����(randomNum)
    private String rd_num;
 
    // ��Կ(keySign)
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
