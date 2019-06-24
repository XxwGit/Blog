package com.json.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//����json�ļ�
public class SetJson {
	public void write(String string, String fileString) {
		try {
			File file = new File(fileString);
			File fileParent = file.getParentFile(); 
			if(!fileParent.exists()){  
			    fileParent.mkdirs();  
			}  
			file.createNewFile();
			FileWriter writer = new FileWriter(fileString, false);
			writer.write(string);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String Fetch(String string, String fileString) {
		SetJson setJson = new SetJson();
		String Finalstring1 = string.replace("@", "");
		String finalString = Finalstring1.replace("#", "");
		setJson.write(finalString, fileString);
		return fileString;
	}
}
