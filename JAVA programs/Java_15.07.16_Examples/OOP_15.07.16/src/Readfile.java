import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFile(String fileName){
	public static void readFile(String fileName) {
			throws IOException{
					FileInputStram fis = null;
					BufferedReader in = null;
					
					  try{
						  fis = new FileInputStream(FileName.txt);
						  in  = new BufferedReader(fis);
						  String tmp = null;
						  
						  while((tmp = in.readLine()) != null){
							  System.out.println(tmp);
						  }
					  	  	  
					  }
					  catch(FileNotFoundException e){
						  System.out.println("The file \""+ fileName + "\" does not exist! Unable to read it. ");
				      }finally{
				    	  if(in != 0 ){
				    		  in.close();
				    	  }
				    	  if(fis != 0 ){
				    		  fis.close();
				    	  }
				    	 
				      }
				  		  
			}
			
			public static void main (String[] args){
				try{
					readFile("C:\\tools\\eclipse\\eclipse.ini");
				}catch(IOException e){
					e.printStackTrace();
				}
			}
	}
	
}	
		