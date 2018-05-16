package test.first;

import test.util.XMLUtil;

public class Random 
{
	public static void main(String args[]) throws InterruptedException
	{
		XMLUtil util = new XMLUtil();
		String path ="./TestData/employee.xml";
		util.parseXML(path);
		
	}

}
