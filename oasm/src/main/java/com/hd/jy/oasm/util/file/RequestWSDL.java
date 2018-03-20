package com.hd.jy.oasm.util.file;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class RequestWSDL {

	/**
	 * ģ������WEBSERVICE����
	 * @param url	�����Webservice��ַ
	 * @param request	����ı��ģ�XML��ʽ���ַ���
	 * @return
	 */
	public static Map<String,String> doRequestWS(URL url, String request) {
		HttpURLConnection connection = null;
		String rspMsg = "";
		String rspCode = "ERROR";
		try {
			byte[] requestBuf = (byte[]) null;
			requestBuf = request.getBytes("gbk");
			
			connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestMethod("POST");
			connection.setUseCaches(false);
			connection.setRequestProperty("Content-Type", "text/plain");
			connection.connect();
			
			DataOutputStream out = new DataOutputStream(
					connection.getOutputStream());
			out.write(requestBuf);
			out.flush();
			out.close();

			if (connection.getResponseCode() != 200) {
				System.out.println("ERROR: " + connection.getResponseMessage());
			}
			
			InputStream in = connection.getInputStream();
			ByteArrayOutputStream bufOut = new ByteArrayOutputStream();
			byte[] readBuf = new byte[100];
			while (true) {
				int ret = in.read(readBuf);
				if (ret < 0){
					break;
					};
				bufOut.write(readBuf, 0, ret);
			}
			byte[] rspBuf = bufOut.toByteArray();
			
			rspMsg = new String(rspBuf, "gbk");
			rspCode = connection.getResponseMessage();
		} catch (Exception e) {
			e.printStackTrace();
		}

		connection = null;
		Map<String,String> map = new HashMap<String,String>();
		map.put("rspCode", rspCode);
		map.put("rspMsg", rspMsg);
		return map;
	}

	public static void main(String[] args) throws Exception,
			UnsupportedEncodingException {
		URL url = new URL("http://www.webxml.com.cn/webservices/qqOnlineWebService.asmx?wsdl");
		System.out.println(url);

//		Map<String,String> map =RequestWSDL.doRequestWS(
//						url,
//						"<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ws=\"http://ws.com/\">"
//								+ "<soapenv:Header/>"
//								+ "<soapenv:Body>"
//								+ "<catt:hello>"
//								+ "<arg0>����</arg0>"
//								+ "</catt:hello>"
//								+ "</soapenv:Body>" 
//								+ "</soapenv:Envelope>");
//		System.out.println(map);
		Map<String,String> map = RequestWSDL.doRequestWS(url, 
				"<wsdl:types>"
				+"<s:schema elementFormDefault='qualified' targetNamespace='http://WebXml.com.cn/'>"
			    +"<s:element name='qqCheckOnline'>"
			    +"<s:complexType>"
			    +"<s:sequence>"
			    + "<s:element minOccurs='0' maxOccurs='1' name='qqCode' type='s:string'/>"
			    		+ "</s:sequence>"
			    		+ "</s:complexType>"
			    		+ "</s:element><s:element name='qqCheckOnlineResponse'>"
			    				+ "<s:complexType><s:sequence>"
			    				+ "<s:element minOccurs='0' maxOccurs='1' name='qqCheckOnlineResult' type='s:string'/>"
			    						+ "</s:sequence></s:complexType></s:element>"
			    						+ "<s:element name='string' nillable='true' type='s:string'/>"
			    								+ "</s:schema></wsdl:types>"
				);
		System.out.println(map);
		long round = Math.round(-11.6);
		System.out.println(round);
		
	}
}
