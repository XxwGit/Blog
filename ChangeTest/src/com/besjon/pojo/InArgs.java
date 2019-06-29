/**
  * Copyright 2019 bejson.com 
  */
package com.besjon.pojo;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
public class InArgs {
	@XmlElementWrapper(name = "inArgs")
	@XmlElement(name = "arg")
    private List<Arg> arg;
	public List<Arg> getArgs() {
		return arg;
	}

	public void setArgs(List<Arg> arg) {
		this.arg = arg;
	}
	

}