package com.json.test;

import java.io.File;
import java.io.IOException;

public class Test {
	public static void main(String[] args) throws IOException {
		String strPath = "E:\\a\\aa";  
		File file = new File(strPath);  
		File fileParent = file.getParentFile();  
		if(!fileParent.exists()){  
		    fileParent.mkdirs();  
		}  
		file.createNewFile();
	}
}
