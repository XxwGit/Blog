package com.json.thread;

import com.json.realize.FileRealize;

public class JsonFileThread implements Runnable{
	private String sourseFile;
	private String targetFolder;
	public JsonFileThread(String sourseFile,String targetFolder) {
		// TODO Auto-generated constructor stub
		this.sourseFile = sourseFile;
		this.targetFolder = targetFolder;
	}
	@Override
	public void run() {
		FileRealize fileRealize = new FileRealize();
		fileRealize.XmlToJson(sourseFile, targetFolder);
	}
}