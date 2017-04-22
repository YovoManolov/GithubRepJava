import java.io.*;
class ShowFile2 {

	public static void main(String[] args) {
		int i;
		FileInputStream fis = null;
		
		if(args.length !=1 ){
			System.out.println("Usage: ShowFile filename ");
			return;			
		}
		
		try{
			fis = new FileInputStream(args[0]);
			
			do{
				i = fis.read();
				if(i!= -1)System.out.println((char)i);
			}while(i != -1);
		}catch(IOException e){
			System.out.println("IO Error occurred");
		}finally{
			try{
				if(fis!= null){
					fis.close();
				}
			}catch(IOException e){
				System.out.println("Error closing file");
			}
			
		}

	}

}
