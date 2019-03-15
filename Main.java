package WordCount;

import java.io.File; 
import java.io.FileWriter;
import java.io.IOException;  


import java.io.FileInputStream; 
 

public class Main 
{ 
	
	public static void main(String[] args) throws Exception 
	{ 
		
		File file = new File("d:\\input.txt"); 
		String content =Main.readFile(file); 
        System.out.println(content); 
		int charNUM = Count.getCharCount(content); 
		System.out.println("characters:"+charNUM); 
		int wordsNum = Count.getWordsNum(content); 
		System.out.println("words:"+wordsNum); 
		int lineNum =Count.getLineCount(content); 
		System.out.println("lines: "+lineNum); 
		String str = Count.getWordFreq(content); 
		Main.writeFile("d:\\result.txt","characters:"+charNUM + "\r\n" + "words:"+wordsNum + "\r\n" + "lines: "+lineNum+ "\r\n" + str);
	} 


public static String readFile(File file) throws Exception
    { 
	   StringBuilder sb = new StringBuilder();
	   FileInputStream fis = new FileInputStream(file);
	   byte[] buf = new byte[1024]; 
	   int length= 0; 
	   while ((length = fis.read(buf))!= -1 ) 
	   {
	        sb.append(new String(buf, 0, length));
	    }
	    fis.close( );
	    return sb.toString();
    } 


public static void writeFile(String fileName, String content) throws IOException
{
    File f = new File(fileName);
    if (!f.exists())
    {
        f.createNewFile();
    }
    FileWriter fileWriter = new FileWriter(f, false);
    fileWriter.write(content);
    fileWriter.flush();
    fileWriter.close( );
}
}


