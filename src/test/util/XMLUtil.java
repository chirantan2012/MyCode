package test.util;

import java.io.File;



import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLUtil 
{
	public void parseXML(String xmlFilePath)
	{
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		try
		{
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
		    Document doc = docBuilder.parse (new File(xmlFilePath));
		    Node node = doc.getDocumentElement();
		    node.normalize();
		    NodeList listOfElements = node.getChildNodes();
		    //System.out.println(listOfElements.item(0).getNodeName().toString());
		    for(int i=0; i<listOfElements.getLength(); i++)
	    	{
	    		Node inner = listOfElements.item(i);
	    		//System.out.println(inner.getNodeName().toString());
	    		NodeList nodelist = inner.getChildNodes();
	    		for (int j = 0; j < nodelist.getLength(); j++) 
	    		{
	    			Node children = nodelist.item(j);
	    			System.out.println(children.getTextContent().toString().trim());
	    			//System.out.println(children.getNodeValue().toString());
				}
	    	}
		    
		    
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
	}
	

}
