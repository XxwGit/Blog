package com.besjon.setXml;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.dom4j.DocumentException;
import org.junit.jupiter.api.Test;

import com.alibaba.fastjson.JSON;
import com.besjon.getXml.GetInArgs;
import com.besjon.getXml.GetOutArgs;
import com.besjon.getXml.GetComponent;
import com.besjon.getXml.GetEnd;
import com.besjon.getXml.GetFileDescription;
import com.besjon.getXml.GetGeometry;
import com.besjon.getXml.GetStart;
import com.besjon.pojo.Ade;
import com.besjon.pojo.Arg;
import com.besjon.pojo.Component;
import com.besjon.pojo.DataBasket;
import com.besjon.pojo.End;
import com.besjon.pojo.Endstep;
import com.besjon.pojo.Exception;
import com.besjon.pojo.FileDescription;
import com.besjon.pojo.Geometry;
import com.besjon.pojo.In;
import com.besjon.pojo.InArgs;
import com.besjon.pojo.InternalVars;
import com.besjon.pojo.JsonRootBean;
import com.besjon.pojo.Out;
import com.besjon.pojo.OutArgs;
import com.besjon.util.FormatUtil;
import com.besjon.util.JaxbObjectAndXmlUtil;
import com.sun.javafx.geom.Edge;
import com.sun.org.apache.bcel.internal.generic.NEWARRAY;

public class SetXml {
	public static void main(String[] args) throws DocumentException {
		try {
			String fileString = "token.xml";
			
			JsonRootBean jsonRootBean = new JsonRootBean();
			jsonRootBean.setStart(setStart(fileString));
			jsonRootBean.setCaption("111");
			jsonRootBean.setGeometry(setGeometry(fileString));
			jsonRootBean.setFileDescription(setFileDescription(fileString));
			jsonRootBean.setDataBasket(setDataBasket());
			jsonRootBean.setInArgs(setInArgs(fileString));
			jsonRootBean.setOutArgs(setOutArgs(fileString));
			jsonRootBean.setInternalVars(setInternalVars());
			jsonRootBean.setEndstep(setEndstep(fileString));
			jsonRootBean.setEnd(setEnd(fileString));
			jsonRootBean.setComponent(setComponent(fileString));
			String xmlStr = JaxbObjectAndXmlUtil.object2Xml(jsonRootBean);//构造报文 XML 格式的字符串
		    //System.out.println("对象转xml报文： \n"+xmlStr);
		    
		    JsonRootBean jsonRootBean2 = JaxbObjectAndXmlUtil.xml2Object(xmlStr, JsonRootBean.class);
		    FormatUtil formatUtil = new FormatUtil();
		    System.out.println(formatUtil.formatJson(JSON.toJSONString(jsonRootBean2)));
		} finally {
			// TODO: handle finally clause
		}
		
	}
	
	public static String setStart(String fileString) throws DocumentException {
		try {
			GetStart getStart = new GetStart();
			return getStart.Start(fileString);
		} finally {
			// TODO: handle finally clause
		}
		
	}
	
	public static Geometry setGeometry(String fileString) throws DocumentException {
		try {
			GetGeometry getGeometry = new GetGeometry();
			Map<String, String> map = getGeometry.Geometry(fileString);
			Geometry geometry = new Geometry();
			geometry.setX(Integer.valueOf(map.get("x")).intValue());
			geometry.setY(Integer.valueOf(map.get("y")).intValue());
			geometry.setWidth(Integer.valueOf(map.get("width")).intValue());
			geometry.setHeight(Integer.valueOf(map.get("height")).intValue());
			
			return geometry;
		} finally {
			// TODO: handle finally clause
		}
		
	}
	
	public static FileDescription setFileDescription(String fileString) throws DocumentException {
		try {
			FileDescription fileDescription = new FileDescription();
			GetFileDescription getFileDescription = new GetFileDescription();
			Map<String, String> map = getFileDescription.FileDescription(fileString);
			fileDescription.setAuthor(map.get("author"));
			fileDescription.setFunction(map.get("function"));
			fileDescription.setRemark(map.get("remark"));
			return fileDescription;
		} finally {
			// TODO: handle finally clause
		}
		
	}
	
	public static DataBasket setDataBasket() {
		try {
			DataBasket dataBasket = new DataBasket();
			List<Ade> ades = new ArrayList<Ade>();
			Ade ade = new Ade();
			ades.add(ade);
			dataBasket.setAde(ades);
			return dataBasket;
		} finally {
			// TODO: handle finally clause
		}
		
	}
	public static InArgs setInArgs(String fileString) throws DocumentException {
		try {
			InArgs inArgs = new InArgs();
			List<Arg> listArgs = new ArrayList<Arg>();
			GetInArgs getArgs = new GetInArgs();
			List<Map<String, String>> list = new ArrayList<Map<String,String>>();
			list = getArgs.name(fileString);
			for (int i = 0; i < list.size(); i++) {
				Arg inOutArg = new Arg();
				Map<String, String> map = list.get(i);
				inOutArg.setName(map.get("name"));
				inOutArg.setType(map.get("type"));
				inOutArg.setDescription(map.get("description"));
				inOutArg.setExample(map.get("value"));
				inOutArg.setValue(map.get("value"));
				listArgs.add(inOutArg);
			}
			inArgs.setArgs(listArgs);
			return inArgs;
		} finally {
			// TODO: handle finally clause
		}
		
	}
	
	public static OutArgs setOutArgs(String fileString) throws DocumentException {
		try {
			OutArgs outArgs = new OutArgs();
			List<Arg> args = new ArrayList<Arg>();
			
			GetOutArgs getArgs = new GetOutArgs();
			List<Map<String, String>> list = new ArrayList<Map<String,String>>();
			list = getArgs.name(fileString);
			
			if (list.size()==0) {
				Arg arg = new Arg();
				args.add(arg);
			}else {
				for (int i = 0; i < list.size(); i++) {
					Arg arg = new Arg();
					Map<String, String> map = list.get(i);
					arg.setName(map.get("name"));
					arg.setType(map.get("type"));
					arg.setDescription(map.get("description"));
					arg.setExample(map.get("value"));
					arg.setValue(map.get("value"));
					args.add(arg);
				}
			}
			outArgs.setArgs(args);
			return outArgs;
		} finally {
			// TODO: handle finally clause
		}
		
	}
	public static InternalVars setInternalVars() {
		try {
			InternalVars internalVars = new InternalVars();
			List<Arg> args = new ArrayList<Arg>();
			for (int i = 0; i < 2; i++) {
				Arg arg = new Arg();
				args.add(arg);
			}

			internalVars.setArg(args);
			return internalVars;
		} finally {
			// TODO: handle finally clause
		}
		
	}
	public static Endstep setEndstep(String fileString) throws DocumentException {
		try {
			Endstep endstep = new Endstep();
			
			GetGeometry getGeometry = new GetGeometry();
			Map<String, String> map = getGeometry.Geometry(fileString);
			Geometry geometry = new Geometry();
			geometry.setX(Integer.valueOf(map.get("x")).intValue());
			geometry.setY(Integer.valueOf(map.get("y")).intValue());
			geometry.setWidth(Integer.valueOf(map.get("width")).intValue());
			geometry.setHeight(Integer.valueOf(map.get("height")).intValue());
			
			
			In in = new In();
			in.setName("正常出口");
			in.setCaption("正常出口");
			in.setId("1");
			
			List<In> ins = new ArrayList<In>();
			ins.add(in);
			
			endstep.setId("1000");
			endstep.setGeometry(geometry);
			endstep.setIn(ins);
			return endstep;
		} finally {
			// TODO: handle finally clause
		}
		
	}
	
	public static List<End> setEnd(String fileString) throws DocumentException {
		try {
			List<End> ends = new ArrayList<End>();
			End end = new End();
			GetEnd getEnd = new GetEnd();
			end.setCaption("正常出口");
			end.setName("正常出口");
			end.setId(getEnd.getEndId(fileString));
			
			ends.add(end);
			return ends;
		} finally {
			// TODO: handle finally clause
		}
		
	}
	
	public static List<Component> setComponent(String fileString) throws DocumentException {
		try {
			List<Component> components = new ArrayList<Component>();
			GetComponent getComponent = new GetComponent();
			List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
			list = getComponent.Component(fileString);
			for (int i = 0; i < list.size(); i++) {
				Component component = new Component();
				Map<String, Object> map = list.get(i);
				//设置Geometry
				Geometry geometry = new Geometry();
				geometry.setX(Integer.valueOf(map.get("x").toString()).intValue());
				geometry.setY(Integer.valueOf(map.get("y").toString()).intValue());
				geometry.setWidth(Integer.valueOf(map.get("width").toString()).intValue());
				geometry.setHeight(Integer.valueOf(map.get("height").toString()).intValue());
				//设置InArgs
				InArgs inArgs = new InArgs();
				List<Arg> inArgsList = new ArrayList<Arg>();
				List<Map<String, String>> getInArgsList = (List<Map<String, String>>) map.get("InArgs");
				for (int j = 0; j < getInArgsList.size(); j++) {
					Arg arg = new Arg();
					Map<String, String> inArgsMap = getInArgsList.get(j);
					arg.setName(inArgsMap.get("inArgName"));
					arg.setCaption(inArgsMap.get("inArgCaption"));
					arg.setDescription(inArgsMap.get("inArgDescription"));
					arg.setExample(inArgsMap.get("inArgExample"));
					arg.setEditor(inArgsMap.get("inArgEditor"));
					arg.setType(inArgsMap.get("inArgType"));
					arg.setValue(inArgsMap.get("inArgValue"));
					arg.setRequired(inArgsMap.get("inArgRequired"));
					arg.setContains(inArgsMap.get("inArgContains"));
					inArgsList.add(arg);
				}
				inArgs.setArgs(inArgsList);
				//设置OutArgs
				OutArgs outArgs = new OutArgs();
				List<Arg> outArgsList = new ArrayList<Arg>();
				List<Map<String, String>> getOutArgsList = (List<Map<String, String>>) map.get("OutArgs");
				
				for (int j = 0; j < getOutArgsList.size(); j++) {
					Arg arg = new Arg();
					Map<String, String> outArgsMap = getOutArgsList.get(j);
					arg.setName(outArgsMap.get("outArgName"));
					arg.setCaption(outArgsMap.get("outArgCaption"));
					arg.setDescription(outArgsMap.get("outArgDescription"));
					arg.setExample(outArgsMap.get("outArgExample"));
					arg.setEditor(outArgsMap.get("outArgEditor"));
					arg.setType(outArgsMap.get("outArgType"));
					arg.setValue(outArgsMap.get("outArgValue"));
					arg.setRequired(outArgsMap.get("outArgRequired"));
					arg.setContains(outArgsMap.get("outArgContains"));
					outArgsList.add(arg);
				}
				outArgs.setArgs(outArgsList);
				
				//设置Out
				List<Out> outs = new ArrayList<Out>();
				@SuppressWarnings("unchecked")
				List<Map<String, String>> getOutList = (List<Map<String, String>>) map.get("Out");
				for (int j = 0; j < getOutList.size(); j++) {
					Out out = new Out();
					Map<String, String> outMap = getOutList.get(j);
					out.setId(outMap.get("outId"));
					out.setCaption(outMap.get("outCaption"));
					out.setName(outMap.get("outName"));
					out.setNext(outMap.get("outNext"));
					outs.add(out);
				}
				//设置Exception
				Exception exception = new Exception();
				List<Map<String, String>> getexceptionList = (List<Map<String, String>>) map.get("Exception");
				for (int j = 0; j < getexceptionList.size(); j++) {
					Map<String, String> exceptionMap = getexceptionList.get(j);
					exception.setName(exceptionMap.get("outName"));
					exception.setNext(exceptionMap.get("outNext"));
				}
				
				component.setId(map.get("componentId").toString());
				component.setCaption(map.get("componentCaption").toString());
				component.setName(map.get("componentName").toString());
				component.setShowId(map.get("componentShowId").toString());
				component.setGeometry(geometry);
				component.setInArgs(inArgs);
				component.setOutArgs(outArgs);
				component.setOut(outs);
				component.setException(exception);
				components.add(component);
				
			}
			return components;
		} finally {
			// TODO: handle finally clause
		}
		
	}
}
