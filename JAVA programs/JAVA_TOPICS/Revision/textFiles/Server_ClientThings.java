////Server side ///
ConnectionThread studentt;
ConnectionThread secretariest;

try{
	studentt = new ConnectionThread(5000,true);
	secretariest = new ConnectionThread(5001,false);
}catch(IOException e){
	System.out.println("Can't start server");
	return;
}

studentt.start();
secretariest.start();


SercerSocket ss;
try{
	ss = new ServerSocket(5002);

}catch(IOException e){
   System.out.println("WARNING: Odobreni 
   	service failed to start!!!");
   return;
}

while(true){
	try(Socket sock = ss.accept()){
		ObjetOutputStream in =
			 new ObjetOutputStream(sock.getInputStram());
		ObjetOutputStream out = 
			 new ObjetOutputStream(sock.getOutputStram());		
		out.flush();
		out.writeUTF("Please send your password");
		out.flush();
		String userpass = in.readUTF();
		if(!userpass.equals(ODOBRENIPASSWORD)) {
			out.writeUTF("BAD PASSWORD. BYE");
		}	  
	}
}



////chetem sydyrjanieto na edin fail i go zapisvame w drug
 FileInputStream in = null;
 FileOutputStream out = null ;

 try{
 	in =  new FileInputStream("input.txt");
 	out = new FileOutputStream("output.txt");
 	int c;
 	while((c = in.read()) != -1){
 		out.write(c);
 	}
 	finally {
 		 if(in != null){
 		 	in.close();
 		 }
 		 if(out != null) {
 		 	out.close();
 		 }
 	}
 }

 /*Character Streams 
	Най-популярните сред тях са FileReader / FileWriter чете/пише по 
	2 байта на веднъж. 
 */

	BufferedReader Чете символи 
	BufferedInputStram чете байтове


	int bufferSize = x*1024

	препоръчително е размерът на буффера да е число кратно на 1024;


	BufferedReader bufferedReader = new BufferedReader(
				new FileReader("someSource"),bufferSize);


	bufferedReader чете блок от символи 
	FileReader чете обикновенно char[]

try with resources  ресурсите са такива , че след изпълнението на 
try блока те трябва да бъдатзатворени :) ;


