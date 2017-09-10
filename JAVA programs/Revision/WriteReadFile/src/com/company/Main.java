package com.company;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            ServerSocket ss = new ServerSocket(3434);
            Socket socket = ss.accept();
            OutputStream out = socket.getOutputStream();
            ObjectOutputStream oout = new ObjectOutputStream(out);
            System.out.println("Server: EnterSomething " );
            String MyString = sc.next();
            oout.writeObject(MyString);
            oout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}


