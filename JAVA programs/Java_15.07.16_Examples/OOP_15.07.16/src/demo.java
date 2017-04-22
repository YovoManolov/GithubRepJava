import java.io.FileInputStream;


class demo {
  FileInputStream fis = new FileInputStream(filename.txt);
    try {
    	BufferedReader in = new BufferedReader(new InputStreamReader(fis));
    	try{
    		//using in here !
    	}
    	finally{
    	     in.close();	
    	    }
    }
    finally{
     fis.close();	
    }
}
