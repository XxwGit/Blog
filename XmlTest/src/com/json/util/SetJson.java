package com.json.util;

import java.io.FileWriter;
import java.io.IOException;
//����json�ļ�
public class SetJson {
	public void write(String string,String fileString) {
        try {
            FileWriter writer = new FileWriter(fileString);
            writer.write(string);
            writer.flush();
            writer.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
      
	}
	public String Fetch(String string,String fileString) {
		SetJson setJson = new SetJson();
		setJson.write(string, fileString);
		return fileString;
	}
	/*
	 * public static void main(String[] args) {
	 * 
	 * }
	 */
}
