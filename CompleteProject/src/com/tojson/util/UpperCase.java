package com.tojson.util;

public class UpperCase {
	 /**
     * ���ַ�������ĸת��д
     * @param str
     * @return
     */
    public static String upperCase(String str) {
        if ((str == null) || (str.length() == 0)) return str;
        char[] ch = str.toCharArray();  
        if (ch[0] >= 'a' && ch[0] <= 'z') {  
            ch[0] = (char) (ch[0] - 32);  
        }  
        return new String(ch);  
    }
}
