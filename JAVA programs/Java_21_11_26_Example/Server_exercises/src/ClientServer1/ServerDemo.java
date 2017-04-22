package ClientServer1;


import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yovo
 */
public class ServerDemo {
    public static void main(String[] args) {
        System.out.println("Hi this is server");
        
        int number;
        try {
            ServerSocket server = new ServerSocket(1211);
            // accept сървъра приема заявката на клиента чрез този метод
            //ако не се приеме заявка програмата не продължава(блокиращ)
            Socket socket = server.accept();
            // accept() - връща променлива от тип сокет 
            // тя съдържа IP  и  порт
            PrintStream printout = new PrintStream(socket.getOutputStream());
            Scanner scan = new Scanner(socket.getInputStream());
            //number - lockal variable;
            
            number = scan.nextInt();
            if((number%2) == 0){
                printout.println("your number is even");
            }else{
                 printout.println("your number is odd");
            }
            server.close(); 
            scan.close();
        } catch (IOException ex) {
            Logger.getLogger(ServerDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        
}
