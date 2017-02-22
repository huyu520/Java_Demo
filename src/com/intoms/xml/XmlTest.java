/**
 * 
 */
package com.intoms.xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.DOMReader;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.xml.sax.SAXException;

/**
 *  CopyRight by 2016 Mfish
 *  All Right Reserved
 *	
 *  @author hy
 *	Create on 2016年11月23日下午4:10:31
 */
public class XmlTest {
	public static void main(String[] args) throws IOException, DocumentException, ParserConfigurationException, SAXException {
//		createXml();
		readXml();
	}
	
	/**
	 * dom4j.jar包学习
	 * 用java代码产生xml文档
	 * @throws IOException 
	 */
	public static void createXml() throws IOException{
		// 第一种方式：创建文档，并创建根元素
        // 创建文档:使用了一个Helper类
		Document document = DocumentHelper.createDocument();
		//创建根节点病加入
		Element element = DocumentHelper.createElement("student");
		document.setRootElement(element);
		
		// 创建文档:使用了一个Helper类
		Element element1 = DocumentHelper.createElement("student");
		Document document2 = DocumentHelper.createDocument(element1);
		
		//添加属性
		element1.addAttribute("name", "huyu");
		Element sex = element1.addElement("sex");
		Element age = element1.addElement("age");
		
		sex.setText("male");
		age.setText("25");
		
		//输出
		XMLWriter xmlWriter = new XMLWriter();
		xmlWriter.write(document);
		
		// 输出到文件
        // 格式
		OutputFormat format = new OutputFormat("    ", true);
		XMLWriter xmlWriter1 = new XMLWriter(new FileOutputStream("d:student.xml"), format);
		xmlWriter1.write(document2);
		
		//宁外一种输出方式
		XMLWriter xmlWriter2 =  new XMLWriter(new FileWriter("d:student1.xml"), format);
		xmlWriter2.write(document2);
		
		if(xmlWriter2 !=null ||xmlWriter !=null || xmlWriter1 != null){
			xmlWriter.flush();
			xmlWriter1.flush();
			xmlWriter2.flush();
		}
	}
	
	/**
	 * 　程序实例2，读入xml文档并分析，将其内容输出。
　		　首先，待分析的文档如下：
	 * @throws DocumentException 
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 * @throws SAXException 
	 */
	public static void readXml() throws DocumentException, ParserConfigurationException, SAXException, IOException{
		SAXReader sax = new SAXReader();
		Document doc = sax.read(new File("d:student.xml"));
		
		//获取根元素
		Element root = doc.getRootElement();
		System.out.println("root Name is :" + root.getName() );
		
		//获取所有子元素
		@SuppressWarnings("unchecked")
		List<Element> list = root.elements();
		System.out.println("chilren count is :" + list.size() );
		
		//获取特定名称的子元素
		@SuppressWarnings("unchecked")
		List<Element> onlyName = root.elements("hello");
		System.out.println("chilren hello count is :" + onlyName.size() );
		
		//获取指定名字的第一个元素
		Element firstElement = root.element("world");
		System.out.println("the first element attr is " + firstElement.attribute(0).getName()+ " = " + firstElement.attributeValue("name"));
		
		//遍历所有子元素、迭代输出
		for(@SuppressWarnings("rawtypes")
		Iterator iter = root.elementIterator() ; iter.hasNext();){
			Element e = (Element) iter.next() ;
			System.out.println(e.attributeValue("name") + " :" + e.getTextTrim());
		}
		
		System.out.println("用DOMReader-----------------------");
		DocumentBuilderFactory bdf = DocumentBuilderFactory.newInstance() ;//反射？
		DocumentBuilder db = bdf.newDocumentBuilder();
		
		//注意要用完整的类名
		org.w3c.dom.Document docu = db.parse(new File("d:student.xml"));
		DOMReader dreader = new DOMReader();
	
		Document document3 = dreader.read(docu);
		Element rootElement = document3.getRootElement() ;
		System.out.println("the rootElment name is " + rootElement.getName());
	}
}
