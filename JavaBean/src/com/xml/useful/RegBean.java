package com.xml.useful;

import javax.xml.bind.annotation.XmlRootElement;

import com.alibaba.fastjson.JSONObject;

/**
 *
 * @author BYSocket
 * ������-[�û�ע�ᱨ������Ϣ]
 */
@XmlRootElement(name="reg_bean")
public class RegBean
{
     
    // ע�ᱨ������ˮ��(reg_data_sn)
    private String reg_sn;
     
    ////�û����(user_info_id)
    // ҵ��ϵͳ���û����ֻ����¼����֧��ϵͳ���߼�����
    private Integer user_id;
 
    // ע���˺�(reg_account)
    private String reg_no;
     
    // ע��;��(reg_way)
    private String reg_way;
     
    // ������
    private String reserve;
     
    ////�ύ����(set_time)
    // ҵ��ϵͳ�ϴ�
    private String set_time;
     
    // ��̨��Ϣ����·��(return_url)
    private String ret_url;
     
    // ��ע
    String remarks;
 
    public String getReg_sn()
    {
        return reg_sn;
    }
 
    public void setReg_sn(String reg_sn)
    {
        this.reg_sn = reg_sn;
    }
 
    public Integer getUser_id()
    {
        return user_id;
    }
 
    public void setUser_id(Integer user_id)
    {
        this.user_id = user_id;
    }
 
    public String getReg_no()
    {
        return reg_no;
    }
 
    public void setReg_no(String reg_no)
    {
        this.reg_no = reg_no;
    }
 
    public String getReg_way()
    {
        return reg_way;
    }
 
    public void setReg_way(String reg_way)
    {
        this.reg_way = reg_way;
    }
 
    public String getReserve()
    {
        return reserve;
    }
 
    public void setReserve(String reserve)
    {
        this.reserve = reserve;
    }
 
    public String getSet_time()
    {
        return set_time;
    }
 
    public void setSet_time(String set_time)
    {
        this.set_time = set_time;
    }
 
    public String getRet_url()
    {
        return ret_url;
    }
 
    public void setRet_url(String ret_url)
    {
        this.ret_url = ret_url;
    }
 
    public String getRemarks()
    {
        return remarks;
    }
 
    public void setRemarks(String remarks)
    {
        this.remarks = remarks;
    }

    public String tojson() {
    	return  JSONObject.toJSON(this).toString();
	}
 
}
