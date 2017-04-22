import java.io.*;
class ShowFile {

	public static void main(String[] args) {
		int i;
		FileInputStream fin;
		
		if(args.length != 1){
			System.out.println("Usage: ShowFile file name ");
			return;
		}
		
		//attempt to open the file 
		try{
			fin =  new FileInputStream(args[0]);
		}catch(FileNotFoundException e){
			System.out.println("File not found!!!");
			return;
		}		
		try{
			i = fin.read();
			//read( ) returns –1 when the end of the file is encountered.
			if(i!= -1)System.out.println((char) i);
		}catch(IOException e){
			System.out.println("Error reading from file");
		}finally{
			try{
				fin.close();
			}catch(IOException e){
				System.out.println("Error closing file");
			}
		}
		
	}

}
