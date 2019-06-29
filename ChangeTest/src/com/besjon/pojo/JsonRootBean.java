/**
  * Copyright 2019 bejson.com 
  */
package com.besjon.pojo;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.alibaba.fastjson.annotation.JSONField;
@XmlRootElement(name = "text_bean")
public class JsonRootBean {
	private String start;
	private String caption;
	private Geometry geometry;
	private FileDescription fileDescription;
	private DataBasket dataBasket;
	private InArgs inArgs;
	private OutArgs outArgs;
	private InternalVars internalVars;
	private Endstep endstep;
	private List<End> end;
	private List<Component> component;
	public void setStart(String start) {
		this.start = start;
	}
	public String getStart() {
		return start;
	}
	
	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getCaption() {
		return caption;
	}

	
	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}

	public Geometry getGeometry() {
		return geometry;
	}

	public void setFileDescription(FileDescription fileDescription) {
		this.fileDescription = fileDescription;
	}

	public FileDescription getFileDescription() {
		return fileDescription;
	}

	public void setDataBasket(DataBasket dataBasket) {
		this.dataBasket = dataBasket;
	}

	public DataBasket getDataBasket() {
		return dataBasket;
	}
	

	public InArgs getInArgs() {
		return inArgs;
	}

	public void setInArgs(InArgs inArgs) {
		this.inArgs = inArgs;
	}
	
	public OutArgs getOutArgs() {
		return outArgs;
	}

	public void setOutArgs(OutArgs outArgs) {
		this.outArgs = outArgs;
	}
	public InternalVars getInternalVars() {
		return internalVars;
	}

	public void setInternalVars(InternalVars internalVars) {
		this.internalVars = internalVars;
	}

	public void setEndstep(Endstep endstep) {
		this.endstep = endstep;
	}

	public Endstep getEndstep() {
		return endstep;
	}
	

	public void setEnd(List<End> end) {
		this.end = end;
	}

	public List<End> getEnd() {
		return end;
	}

	public void setComponent(List<Component> component) {
		this.component = component;
	}

	public List<Component> getComponent() {
		return component;
	}

}