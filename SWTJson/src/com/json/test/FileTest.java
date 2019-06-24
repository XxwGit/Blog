package com.json.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileTest {
	private static List<File> func(File file) {
		File[] fs = file.listFiles();
		List<File> files = new ArrayList<File>();
		for (File f : fs) {
			if (f.isDirectory()) // 若是目录，则递归打印该目录下的文件
				func(f);
			if (f.isFile()) // 若是文件，直接打印
				files.add(f);
				System.out.println(f);

		}
		return files;
	}

	public static void main(String[] args) {
		String inputPath = "E:\\test";// 要遍历的路径
		File file = new File(inputPath); // 获取其file对象
		List<File> files = func(file);
		for (File file2 : files) {
			System.out.println(file2);
		}
	}
}
