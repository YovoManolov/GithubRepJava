/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaC_thread_CS;

import java.net.InetAddress;
import java.net.Socket;

/**
 *
 * @author yovo
 */
public class Client {
    InetAddress address = InetAddress.getByName("localhost");
    Thread t;
    public Client(Thread t){
        this.t = t;
    }
    
    try {
     Socket s = new Socket( address, 1245);
    if(t.wish.equals("writing")){
           
    } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
  
   
    
}
