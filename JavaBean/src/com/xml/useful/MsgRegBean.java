package com.xml.useful;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

@XmlRootElement(name = "msg_bean")
public class MsgRegBean {
	private String start;
	@JSONField(name = "dataBean")
	private DataBean dataBean;
	@JSONField(name = "regBeans")
	private List<RegBean> regBeans;

	public String getStart() {
		return start;
	}
	@XmlElement(name = "start")
	public void setStart(String start) {
		this.start = start;
	}

	public DataBean getDataBean() {
		return dataBean;
	}

	@XmlElement(name = "data_bean")
	public void setDataBean(DataBean dataBean) {
		this.dataBean = dataBean;
	}

	@XmlElementWrapper(name = "reg_beans")
	@XmlElement(name = "reg_bean")
	public List<RegBean> getRegBeans() {
		return regBeans;
	}

	public void setRegBeans(List<RegBean> regBeans) {
		this.regBeans = regBeans;
	}

	public String tojson() {
		return JSONObject.toJSON(this).toString();
	}

}
