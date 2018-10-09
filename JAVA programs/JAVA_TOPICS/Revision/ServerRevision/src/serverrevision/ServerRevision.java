package serverrevision;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerRevision{

	public static void main(String[] args) throws IOException {
             int a , b, result;
            
             ServerSocket s = new ServerSocket(35555);
             Socket socket = s.accept();
             
             Scanner scanner = new Scanner(socket.getInputStream());
             a = scanner.nextInt();
             b = scanner.nextInt();
             
             result = a + b;
  
             PrintStream prtStr = new PrintStream(socket.getOutputStream()); 
             prtStr.println(result);
             
             s.close();
             socket.close();
             scanner.close();
        }
}