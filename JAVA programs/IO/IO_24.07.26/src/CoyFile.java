import java.io.*;
class CoyFile {

	public static void main(String[] args) throws IOException {
		int i;
 
		//Confirming that 	 both files have been specified.
		if(args.length != 2){
			System.out.println("Copy file from - to");
			return;
		}
		
		try(FileInputStream fin = new FileInputStream(args[0]);
				FileOutputStream fout = new FileOutputStream(args[1])){
			//Attempt  to open the files
			
			do{
				i = fin.read();
				if(i != -1)fout.write(i);		
			}while(i != -1);
		}catch(IOException e){
		 System.out.println("I/O Error has occurred!!!");	
		}	
	}

}
