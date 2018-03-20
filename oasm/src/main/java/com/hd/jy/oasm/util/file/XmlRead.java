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

//下午4:20:11
public class XmlRead {
  
	/** 
     * 传入xml文件的路径，返回XML文档的根节点element 
     * @param path   xml文件的路径 
     * @return element 
     */  
    public static Element getElementMyXML(String path) {  
        Element element = null;  
        File file = new File(path);  
        // documentBuilder为抽象不能直接实例化(将XML文件转换为DOM文件)  
        DocumentBuilder db = null;  
        DocumentBuilderFactory dbf = null;  
  
        try {  
            // 得到DOM解析器的工厂实例  
            // 得到javax.xml.parsers.DocumentBuilderFactory；类的实例就是我们要的解析器工厂  
            dbf = DocumentBuilderFactory.newInstance();  
            // 从DOM工厂获得DOM解析器  
            // 通过javax.xml.parsers.DocumentBuilderFactory实例的静态方法newDocumentBuilder（）得到DOM解析器  
            db = dbf.newDocumentBuilder();  
            // 得到一个DOM并返回给document对象  
            Document dt = db.parse(file);  
            // 得到XML文档的根节点  
            // 在DOM中只有根节点是一个org.w3c.dom.Element对象。  
            element = dt.getDocumentElement();  
//System.out.println("Element已经获取");   
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
     * 传入父节点fatherNode，返回所有子节点childNode放入ArrayList中 
     * @param element 
     * @return ArrayList 
     */  
    public static ArrayList<Node> getAllChildNodesMyXML(NodeList fatherNode){  
        ArrayList<Node> al = new ArrayList<Node>();  
        //遍历所有节点  
        for (int i = 0; i < fatherNode.getLength(); i++){  
            Node childNode = fatherNode.item(i);  
            //如果子节点为空跳过  
            if("#text".equals(childNode.getNodeName())){  
                continue;  
            }  
            //子节点有内容，加入到arraylist中  
            al.add(childNode);  
        }  
        return al;  
    }  
      
      
    /** 
     * 传入父节点fatherNode，和字符串name，返回子节点名字等于name的childNode放入ArrayList中 
     * @param element 
     * @param name 
     * @return ArrayList 
     */  
    public static  ArrayList<Node> getChildNodesMyXML(NodeList fatherNode,String name){  
        ArrayList<Node> al = new ArrayList<Node>();  
        //遍历所有节点  
        for (int i = 0; i < fatherNode.getLength(); i++){  
            Node childNode = fatherNode.item(i);  
//System.out.println(fatherNode.getLength());  
//System.out.println(childNode.getNodeName());  
            //如果子节点的名字等于name  
            if(name.equals(childNode.getNodeName())){  
                //加入到arraylist中  
                al.add(childNode);  
            }  
        }  
        return al;  
    }  
      
      
    /** 
     * 传入父节点fatherNode，和字符串name，返回子节点属性attributes等于name的childNode放入ArrayList中 
     * @param fatherNode 
     * @param attributes 
     * @param name 
     * @return 
     */  
    public static ArrayList<Node> getChildNodesMyXMLAttributes(NodeList fatherNode,String attributes,String name){  
        ArrayList<Node> al = new ArrayList<Node>();  
        //遍历所有节点  
        for (int i = 0; i < fatherNode.getLength(); i++){  
            Node childNode = fatherNode.item(i);  
            try {  
                //如果子节点的属性attributes等于name，则加入到arraylist中  
                if(name.equals(childNode.getAttributes().getNamedItem(attributes).getNodeValue())){  
                    al.add(childNode);  
                }  
            } catch (NullPointerException e) {  
                // TODO: handle exception  
                //System.out.println("该节点没有属性");  
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
		
		System.out.println("第一个节点");
		for(int i=0;i<a1.size();i++){
			System.out.println("第一个节点的名字为："+a1.get(i).getNodeName());
			System.out.println("第一个节点的属性"+a1.get(i).getAttributes().getNamedItem(attributes).getNodeValue());
//			System.out.println("第一个节点的子节点为："+a1.get(i).getTextContent());
		}
		//获得第二级子节点
		 a2 = XmlRead.getChildNodesMyXML(a1.get(0).getChildNodes(), childName);
		 System.out.println("第二级子节点");
		 for (int i = 0; i <a1.size(); i++) {
			System.out.println("第二个子节点名字为："+a2.get(i).getNodeName());
		}
		
	}
}
