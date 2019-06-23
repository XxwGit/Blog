package com.json.realize;

import java.io.File;

import com.json.util.FormatUtil;
import com.json.util.GetFile;
import com.json.util.GetXml;
import com.json.util.SetJson;
import com.json.util.Xml2Json;;
public class FolderRealize {
	public void Xml2Json(String sourseFolder,String targetFolder,int i) {
		GetFile getFile = new GetFile();
		File file = new File(sourseFolder);
		//File file = new File("E://repo//XxwGit.github.io//_includes//XmlTest");
		String[] files = getFile.getFiles(file);
		GetXml getXml = new GetXml();
		String jsonName = getXml.getName(sourseFolder+"//"+files[i]);
		//String jsonName = getXml.getName("E://repo//XxwGit.github.io//_includes//XmlTest"+"//"+files[6]);
		System.out.println(jsonName);
		Xml2Json xml2Json = new Xml2Json();
		//1.��ȡxmlתjson���String�ļ�
		String jsonString = xml2Json.XmlToJson(sourseFolder+"//"+files[i]);
		//String jsonString = xml2Json.name("E://repo//XxwGit.github.io//_includes//XmlTest"+"//"+files[6]);
		//2.��String�ļ���ʽ��
		FormatUtil formatUtil = new FormatUtil();
		String formateString = formatUtil.formatJson(jsonString);
		//3.����ʽ�����ļ�д���ļ��н��б���
		SetJson setJson = new SetJson();
		String filString = setJson.Fetch(formateString, targetFolder+"//"+jsonName);
		//String filString = setJson.Fetch(formateString, "E://test"+"//"+jsonName);
	}
	
	public int getLength(String sourseFolder) {
		GetFile getFile = new GetFile();
		File file = new File(sourseFolder);
		//File file = new File("E://repo//XxwGit.github.io//_includes//XmlTest");
		String[] files = getFile.getFiles(file);
		return files.length;
	}
}