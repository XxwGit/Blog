package com.json.util;

import java.io.File;

public class RealizeClass {
	public void Xml2Json(String sourseFile,String targetFile,int i) {
		GetFile getFile = new GetFile();
		File file = new File(sourseFile);
		//File file = new File("E://repo//XxwGit.github.io//_includes//XmlTest");
		String[] files = getFile.getFiles(file);
		GetXml getXml = new GetXml();
		String jsonName = getXml.getName(sourseFile+"//"+files[i]);
		//String jsonName = getXml.getName("E://repo//XxwGit.github.io//_includes//XmlTest"+"//"+files[6]);
		System.out.println(jsonName);
		Xml2Json xml2Json = new Xml2Json();
		//1.��ȡxmlתjson���String�ļ�
		String jsonString = xml2Json.name(sourseFile+"//"+files[i]);
		//String jsonString = xml2Json.name("E://repo//XxwGit.github.io//_includes//XmlTest"+"//"+files[6]);
		//2.��String�ļ���ʽ��
		FormatUtil formatUtil = new FormatUtil();
		String formateString = formatUtil.formatJson(jsonString);
		//3.����ʽ�����ļ�д���ļ��н��б���
		SetJson setJson = new SetJson();
		String filString = setJson.Fetch(formateString, targetFile+"//"+jsonName);
		//String filString = setJson.Fetch(formateString, "E://test"+"//"+jsonName);
	}
	
	public int getLength(String sourseFile) {
		GetFile getFile = new GetFile();
		File file = new File(sourseFile);
		//File file = new File("E://repo//XxwGit.github.io//_includes//XmlTest");
		String[] files = getFile.getFiles(file);
		return files.length;
	}
	public static void main(String[] args) {
		RealizeClass realizeClass = new RealizeClass();
		int length = realizeClass.getLength("E://repo//XxwGit.github.io//_includes//XmlTest");
		System.out.println(length);
	}
}