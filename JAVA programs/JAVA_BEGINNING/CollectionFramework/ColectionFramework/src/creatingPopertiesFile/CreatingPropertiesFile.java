package creatingPopertiesFile;

import java.io.*;
import java.util.*;

public class CreatingPropertiesFile {

	public static void main(String[] args) throws Exception {
		Properties p = new Properties();
		p.setProperty("name", "yovo");
		p.setProperty("age", "20");
		
		p.store (new FileWriter ("info.properties")  ,  "propertyFileCreatingExapmple");
		
		
        System.out.println("Printion the property file we just created ! \n ");
        
		FileReader reader = new FileReader("info.properties");	
        p.load(reader);
        
        System.out.println(p.getProperty("name"));
        System.out.println(p.getProperty("age"));
        
   }
}
