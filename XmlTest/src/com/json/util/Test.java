package com.json.util;

public class Test {
	public static void main(String[] args) {
		JsonThread jsonThread = new JsonThread("E://repo//XxwGit.github.io//_includes//XmlTest", "E://test");
		Thread thread = new Thread(jsonThread);
		thread.run();
	}
}
