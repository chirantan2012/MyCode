package test.first;

import java.net.URL;
import java.net.URLConnection;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class JSoupTest {

	 private static final String USER_AGENT =
             "Mozilla/55.0 (Windows 10; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";
  
	public static void main(String[] args)
	{
		
	    try {
	     String url = "http://www.ingrammicrocloud.in/";
	     Connection connection = Jsoup.connect( url ).userAgent(USER_AGENT);
	     Document htmlDocument = connection.get();
	     System.out.println(connection.response().statusCode());
	     
	     //Count number of images in a page
	     //Elements s = htmlDocument.getElementsByTag("img");
	     int imgCount = htmlDocument.getElementsByTag("img").size();
	     System.out.println("num of images : " + imgCount);
	     
	     //Search for Broken images and alt-text
	     for (int i = 0; i < imgCount ; i++) 
	     {
	    	// System.out.println(i + " - " + htmlDocument.getElementsByTag("img").get(i));
	    	 String url_1 = htmlDocument.getElementsByTag("img").get(i).attr("src").toString();
	    	 System.out.println(url_1);
	    	 URLConnection url_0 = new URL(url_1).openConnection();
//	    	 System.out.println(url_0.getRequestProperty(""));
	    	 Connection connection_1 = Jsoup.connect( url_1 ).userAgent(USER_AGENT);
		     Document htmlDocument_1 = connection_1.get();
		     
//		     //Broken Image
//	    	 if(connection_1.response().statusCode()==200)
//	    	 {
//	    		 System.out.println("Image is not broken. >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//	    	 }
//	    	 else
//	    	 {
//	    		 System.out.println("Image is broken. <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
//	    	 }
//	    	 
	    	 //Alt-Text
	    	 if(htmlDocument_1.hasAttr("alt"))
	    	 {
	    		 System.out.println("Image has attribute Alt-Txt. >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	    	 }
	    	 else
	    	 {
	    		 System.out.println("Image doesnot have attribute Alt-Txt. <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
	    	 }
	    	 
//	    	 System.out.println(url_1.length()+"              <<<<<<<<<<<<<<<<<<<<<<<<<<");
	    	 
	     }
	     
	     
	     
	     
	     
	     
	     //System.out.println("Page Title " + htmlDocument.title());
	  } catch (Exception e) {
	   // TODO: handle exception
	  }
	 
	    
	    
	    
	    
	    
	    
	    
	    
//	    try{
//	    	URLConnection url = new URL("https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png").openConnection();
//	    	URLConnection url_1 = new URL("https://accounts.google.com/SignOutOptions?hl=en&continue=https://www.google.com/").openConnection();
//
//	    	Thread.sleep(2000);
//	    	System.out.println(url_1.getContentLength());
//	    	System.out.println(url_1.getContentType());
//	    }
//	    catch(Exception e)
//	    {
//	    	
//	    }
	   }
	
	

}


