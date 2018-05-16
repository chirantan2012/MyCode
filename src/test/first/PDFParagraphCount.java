package test.first;

import java.io.File;
import java.io.FileNotFoundException;

import test.util.ReadPDF;

public class PDFParagraphCount 
{
	public static void main(String args[]) throws FileNotFoundException
	{
		ReadPDF readPDF = new ReadPDF();
		String path = "F:/Personal/Workspace/PracticeProject/TestProject/TestData/";
		File convertedTxt = readPDF.convertPDFtoTxt(path + "Test.pdf", path + "Test.txt");
		int paraCount = readPDF.paragraphCounter(convertedTxt);
		System.out.println(paraCount);
	}

}
