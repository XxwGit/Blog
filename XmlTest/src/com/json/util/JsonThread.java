package com.json.util;

public class JsonThread implements Runnable{
	private String sourseFile;
	private String targetFile;
	public JsonThread(String sourseFile,String targetFile) {
		// TODO Auto-generated constructor stub
		this.sourseFile = sourseFile;
		this.targetFile = targetFile;
	}
	@Override
	public void run() {
		RealizeClass tRealizeClass = new RealizeClass();
		int length = tRealizeClass.getLength(sourseFile);
		// TODO Auto-generated method stub
		for (int i = 0; i < length; i++) {
			tRealizeClass.Xml2Json(sourseFile, targetFile, i);
		}
		
	}
}
