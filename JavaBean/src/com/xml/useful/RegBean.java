package com.xml.useful;

import javax.xml.bind.annotation.XmlRootElement;

import com.alibaba.fastjson.JSONObject;

/**
 *
 * @author BYSocket
 * 报文体-[用户注册报文体信息]
 */
@XmlRootElement(name="reg_bean")
public class RegBean
{
     
    // 注册报文体流水号(reg_data_sn)
    private String reg_sn;
     
    ////用户编号(user_info_id)
    // 业务系统的用户编号只做记录不在支付系统中逻辑处理
    private Integer user_id;
 
    // 注册账号(reg_account)
    private String reg_no;
     
    // 注册途径(reg_way)
    private String reg_way;
     
    // 保留域
    private String reserve;
     
    ////提交日期(set_time)
    // 业务系统上传
    private String set_time;
     
    // 后台信息返回路径(return_url)
    private String ret_url;
     
    // 备注
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
