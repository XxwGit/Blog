package com.json.realize;

import java.io.File;

import com.json.util.CheckName;
import com.json.util.FormatUtil;
import com.json.util.GetFile;
import com.json.util.GetXml;
import com.json.util.SetJson;
import com.json.util.Xml2Json;;
public class FolderRealize {
	public void Xml2Json(String sourseFolder,String targetFolder,int i) {
		
		try {
			GetFile getFile = new GetFile();
			File file = new File(sourseFolder);
			//File file = new File("E://repo//XxwGit.github.io//_includes//XmlTest");
			String[] files = getFile.getFilStrings(file);
			GetXml getXml = new GetXml();
			String jsonName = getXml.getName(files[i]);
			String target = files[i].replace(sourseFolder, "");
			
			CheckName checkName = new CheckName();
			
			String finalFile = checkName.name(target);
			if (target.contains(".xml")) {
				finalFile = target.replace(".xml", ".json");
			}else if (target.contains(".lfc") ){
				finalFile = target.replace(".lfc", ".json");
			}
			System.out.println(finalFile);
			//String jsonName = getXml.getName("E://repo//XxwGit.github.io//_includes//XmlTest"+"//"+files[6]);
			System.out.println(jsonName);
			Xml2Json xml2Json = new Xml2Json();
			//1.获取xml转json后的String文件
			String jsonString = xml2Json.XmlToJson(files[i]);
			//String jsonString = xml2Json.name("E://repo//XxwGit.github.io//_includes//XmlTest"+"//"+files[6]);
			//2.将String文件格式化
			FormatUtil formatUtil = new FormatUtil();
			String formateString = formatUtil.formatJson(jsonString);
			//3.将格式化的文件写入文件中进行保存
			SetJson setJson = new SetJson();
			setJson.Fetch(formateString, targetFolder+finalFile);
			//String filString = setJson.Fetch(formateString, "E://test"+"//"+jsonName);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}
	
	public int getLength(String sourseFolder) {
		GetFile getFile = new GetFile();
		File file = new File(sourseFolder);
		//File file = new File("E://repo//XxwGit.github.io//_includes//XmlTest");
		String[] files = getFile.getFilStrings(file);
		return files.length;
	}
}
