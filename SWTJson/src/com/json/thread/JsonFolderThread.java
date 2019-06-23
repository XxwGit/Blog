package com.json.thread;

import com.json.realize.FolderRealize;

public class JsonFolderThread implements Runnable{
	private String sourseFolder;
	private String targetFolder;
	public JsonFolderThread(String sourseFolder,String targetFolder) {
		// TODO Auto-generated constructor stub
		this.sourseFolder = sourseFolder;
		this.targetFolder = targetFolder;
	}
	@Override
	public void run() {
		FolderRealize tRealizeClass = new FolderRealize();
		int length = tRealizeClass.getLength(sourseFolder);
		// TODO Auto-generated method stub
		for (int i = 0; i < length; i++) {
			tRealizeClass.Xml2Json(sourseFolder, targetFolder, i);
		}
		
	}
}
