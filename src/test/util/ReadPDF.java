package test.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.Scanner;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class ReadPDF
{
	public static File convertPDFtoTxt(String one,String two)
	{
		 PDDocument pd;
		 BufferedWriter wr;
		 File PDFFile = new File(one);  // The PDF file from where you would like to extract
		 File convertedTxt = new File(two);
		 String extract = null;
		 try 
		 {			 
			 
	         pd = PDDocument.load(PDFFile);
	         System.out.println(pd.getNumberOfPages());
	         
	         PDFTextStripper stripper = new PDFTextStripper();
	         wr = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(convertedTxt)));
	         stripper.writeText(pd, wr);
	         extract = stripper.getText(pd);
	         if (pd != null) 
	         {
	             pd.close();
	         }
	        // I use close() to flush the stream.
	        wr.close();
		 } 
		 catch (Exception e)
		 {
		         e.printStackTrace();
		 }
		 return convertedTxt;
	}
	
	public int paragraphCounter(File convertedTxt) throws FileNotFoundException
	{
		Scanner input = new Scanner(new FileReader(convertedTxt));

       // PrintWriter output = new PrintWriter(new FileOutputStream("newfile.txt"));

        int lineNum = 0;
        int wordCount = 1;
        int charCount = 0;
        int paraCount = 0;
          boolean key = true;  

        while (input.hasNextLine()) 
        {
	        String line;
	        line = input.nextLine();
	        lineNum++;
	        wordCount += getWords(line);        
	        charCount += (line.length());
	        if (!line.isEmpty())
	        { 
	             key = false; 
	        }
	        if (!key)
	            paraCount += getPara(line);
	        }
        return paraCount;

	}
	
	public static int getWords(String line) {
	    String str[] = line.split((" "));
	    int count = 0;
	    for (int i = 0; i < str.length; i++) {
	        if (str[i].length() > 0) {
	            count++;

	        }

	    }
	    return count;

	}
	public static int getPara(String line){  
	    int count = 0; 
	    if(line.isEmpty()) {
	        count++;
	    }
	    return count;
	}
	
	
}
