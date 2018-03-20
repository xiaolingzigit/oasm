package com.hd.jy.oasm.util.file;

import java.io.File;  
import java.io.IOException;  
import java.util.ArrayList;  
  
import javax.xml.parsers.DocumentBuilder;  
import javax.xml.parsers.DocumentBuilderFactory;  
import javax.xml.parsers.ParserConfigurationException;  
  
import org.w3c.dom.Document;  
import org.w3c.dom.Element;  
import org.w3c.dom.Node;  
import org.w3c.dom.NodeList;  
import org.xml.sax.SAXException;  

//����4:20:11
public class XmlRead {
  
	/** 
     * ����xml�ļ���·��������XML�ĵ��ĸ��ڵ�element 
     * @param path   xml�ļ���·�� 
     * @return element 
     */  
    public static Element getElementMyXML(String path) {  
        Element element = null;  
        File file = new File(path);  
        // documentBuilderΪ������ֱ��ʵ����(��XML�ļ�ת��ΪDOM�ļ�)  
        DocumentBuilder db = null;  
        DocumentBuilderFactory dbf = null;  
  
        try {  
            // �õ�DOM�������Ĺ���ʵ��  
            // �õ�javax.xml.parsers.DocumentBuilderFactory�����ʵ����������Ҫ�Ľ���������  
            dbf = DocumentBuilderFactory.newInstance();  
            // ��DOM�������DOM������  
            // ͨ��javax.xml.parsers.DocumentBuilderFactoryʵ���ľ�̬����newDocumentBuilder�����õ�DOM������  
            db = dbf.newDocumentBuilder();  
            // �õ�һ��DOM�����ظ�document����  
            Document dt = db.parse(file);  
            // �õ�XML�ĵ��ĸ��ڵ�  
            // ��DOM��ֻ�и��ڵ���һ��org.w3c.dom.Element����  
            element = dt.getDocumentElement();  
//System.out.println("Element�Ѿ���ȡ");   
        } catch (SAXException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } catch (ParserConfigurationException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
        return element;  
    }  
      
      
      
    /** 
     * ���븸�ڵ�fatherNode�����������ӽڵ�childNode����ArrayList�� 
     * @param element 
     * @return ArrayList 
     */  
    public static ArrayList<Node> getAllChildNodesMyXML(NodeList fatherNode){  
        ArrayList<Node> al = new ArrayList<Node>();  
        //�������нڵ�  
        for (int i = 0; i < fatherNode.getLength(); i++){  
            Node childNode = fatherNode.item(i);  
            //����ӽڵ�Ϊ������  
            if("#text".equals(childNode.getNodeName())){  
                continue;  
            }  
            //�ӽڵ������ݣ����뵽arraylist��  
            al.add(childNode);  
        }  
        return al;  
    }  
      
      
    /** 
     * ���븸�ڵ�fatherNode�����ַ���name�������ӽڵ����ֵ���name��childNode����ArrayList�� 
     * @param element 
     * @param name 
     * @return ArrayList 
     */  
    public static  ArrayList<Node> getChildNodesMyXML(NodeList fatherNode,String name){  
        ArrayList<Node> al = new ArrayList<Node>();  
        //�������нڵ�  
        for (int i = 0; i < fatherNode.getLength(); i++){  
            Node childNode = fatherNode.item(i);  
//System.out.println(fatherNode.getLength());  
//System.out.println(childNode.getNodeName());  
            //����ӽڵ�����ֵ���name  
            if(name.equals(childNode.getNodeName())){  
                //���뵽arraylist��  
                al.add(childNode);  
            }  
        }  
        return al;  
    }  
      
      
    /** 
     * ���븸�ڵ�fatherNode�����ַ���name�������ӽڵ�����attributes����name��childNode����ArrayList�� 
     * @param fatherNode 
     * @param attributes 
     * @param name 
     * @return 
     */  
    public static ArrayList<Node> getChildNodesMyXMLAttributes(NodeList fatherNode,String attributes,String name){  
        ArrayList<Node> al = new ArrayList<Node>();  
        //�������нڵ�  
        for (int i = 0; i < fatherNode.getLength(); i++){  
            Node childNode = fatherNode.item(i);  
            try {  
                //����ӽڵ������attributes����name������뵽arraylist��  
                if(name.equals(childNode.getAttributes().getNamedItem(attributes).getNodeValue())){  
                    al.add(childNode);  
                }  
            } catch (NullPointerException e) {  
                // TODO: handle exception  
                //System.out.println("�ýڵ�û������");  
            }  
        }  
        return al;  
    }  

    public static void main(String[] args) {
		String path="E:"+ "/helloworld.xml";
		String attributes="type";
		String name="Oracle";
		String childName="user";
		Element element = XmlRead.getElementMyXML(path);
		ArrayList<Node> a1 = XmlRead.getChildNodesMyXMLAttributes(element.getChildNodes(), attributes, name);
		ArrayList<Node> a2=null;
		
		System.out.println("��һ���ڵ�");
		for(int i=0;i<a1.size();i++){
			System.out.println("��һ���ڵ������Ϊ��"+a1.get(i).getNodeName());
			System.out.println("��һ���ڵ������"+a1.get(i).getAttributes().getNamedItem(attributes).getNodeValue());
//			System.out.println("��һ���ڵ���ӽڵ�Ϊ��"+a1.get(i).getTextContent());
		}
		//��õڶ����ӽڵ�
		 a2 = XmlRead.getChildNodesMyXML(a1.get(0).getChildNodes(), childName);
		 System.out.println("�ڶ����ӽڵ�");
		 for (int i = 0; i <a1.size(); i++) {
			System.out.println("�ڶ����ӽڵ�����Ϊ��"+a2.get(i).getNodeName());
		}
		
	}
}
