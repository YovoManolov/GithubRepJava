/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yovo
 */
/*В клиентската част, отваряме сокет с IP адрес 
127.0.0.1 – адрес на текущата машина(може да бъде 
замененот от “localhost”) и порт 1211. Създаваме два обекта
от тип Scanner. Първият чете от стандартната клавиатура, 
а вторият чете поток, асоцииран със създадения обект 
от тип сокет. Проверката за невалидни 
символи е направена в клиентската част.
По-добрият подход е това да се направи в сървърната
част, от гледна точка на сигурността.
*/
public class Client {
    public static void main(String[] args)  {
        
        System.out.println("Hi this is client");
        
        int number;
        String result;
        Socket s = null ;
        Scanner scan  = null;
        Scanner scan2  = null;
        PrintStream printOut;
        try {
            s = new Socket("127.0.0.1", 1500);
            //Първият чете от стандартната клавиатура, 
            //а вторият чете поток, асоцииран със създадения обект  
            //от тип сокет.
            scan = new Scanner(System.in);
            scan2 = new Scanner(s.getInputStream());
            printOut = new PrintStream(s.getOutputStream());
            
            System.out.println("Enter some Value");        
            try{
                number = scan.nextInt();
                printOut.println(number);
                result = scan2.nextLine();
                System.out.println( "Comming from server : " + result);
            }catch(InputMismatchException  e){
                System.out.println("Enter correct value");
            }
            if(s != null ) s.close();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(scan != null) scan.close();
        }
        
       
    }
}
