package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromExternalFile 
{
   public static void main(String[] args) throws IOException 
   {
	  //step 1: Open the document in java readable format
	   FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
	   
	   //step 2 : create an object of properties class java.util
	   Properties p=new Properties();
	   
	   //step 3: load the file input stream to properties
	    p.load(fis); 
	   
	   //step 4: provide the key and read the value
	    String value= p.getProperty("firstname");
	    System.out.println(value);
   }
   
}
