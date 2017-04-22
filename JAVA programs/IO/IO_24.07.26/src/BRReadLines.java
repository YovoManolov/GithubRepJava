import java.io.*;
class BRReadLines {

	public static void main(String[] args)throws IOException {
		//Creating buffered reader using  Sistem.in
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str ;
		System.out.println("Enter lines of text.");
		System.out.println("Enter 'stop' to quit");
		do{
			str = br.readLine();
			System.out.println(str);
		}while(!str.equals("stop"));  //the same as/// !=  ///(! str.equals(str2);)
		//This method returns true if the String are equal; false otherwise.
	}

}
