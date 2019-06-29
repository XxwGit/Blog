package com.json.xxk;

import java.io.File;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Test {
	@org.junit.Test
	public void testGetRoot() throws Exception {
		SAXReader sax = new SAXReader();// ����һ��SAXReader����
		File xmlFile = new File("C:\\Users\\����ΰ\\Desktop\\test\\token.xml");// ����ָ����·������file����
		Document document = sax.read(xmlFile);// ��ȡdocument����,����ĵ��޽ڵ㣬����׳�Exception��ǰ����
		Element root = document.getRootElement();// ��ȡ���ڵ�
		this.getNodes(root);// �Ӹ��ڵ㿪ʼ�������нڵ�

	}
	
    /**
 * ��ָ���ڵ㿪ʼ,�ݹ���������ӽڵ�
 * @author chenleixing
 */
public void getNodes(Element node){
	System.out.println("--------------------");
	
	//��ǰ�ڵ�����ơ��ı����ݺ�����
	System.out.println("��ǰ�ڵ����ƣ�"+node.getName());//��ǰ�ڵ�����
	System.out.println("��ǰ�ڵ�����ݣ�"+node.getTextTrim());//��ǰ�ڵ�����
	List<Attribute> listAttr=node.attributes();//��ǰ�ڵ���������Ե�list
	for(Attribute attr:listAttr){//������ǰ�ڵ����������
		String name=attr.getName();//��������
		String value=attr.getValue();//���Ե�ֵ
		System.out.println("�������ƣ�"+name+"����ֵ��"+value);
	}
	
	//�ݹ������ǰ�ڵ����е��ӽڵ�
	List<Element> listElement=node.elements();//����һ���ӽڵ��list
	for(Element e:listElement){//��������һ���ӽڵ�
		this.getNodes(e);//�ݹ�
	}
}
}
