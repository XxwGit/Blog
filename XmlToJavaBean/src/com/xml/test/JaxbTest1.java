package com.xml.test;

import java.util.Date;

import org.junit.Test;

public class JaxbTest1 {
	/**
	 * bean转xml测试.
	 */
	@Test
	public void test1() {
		Student book = new Student();
		book.setId(100);
		book.setName("yangwenxue");
		book.setBirthday(new Date());
		book.setAge(25);

		Role role = new Role();
		role.setRoleId("1233");
		role.setRoleName("管理员");
		role.setMemo("管理用户权限");
		book.setRole(role);

		String str = JaxbUtil.convertToXml(book);
		System.out.println(str);
	}

	/**
	 * xml转bean测试.
	 */
	@Test
	public void test2() {
		String str = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
				+ "<student id=\"100\"><name>yangwenxue</name><age>25</age>"
				+ "<birthday>2016-12-22T13:29:42.662+08:00</birthday><role roleId=\"1233\">"
				+ "<roleName>管理员</roleName><memo>管理用户权限</memo></role></student>";
		Student book = JaxbUtil.converyToJavaBean(str, Student.class);
		System.out.println(book);
	}
}