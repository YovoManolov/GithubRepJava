package client;

import java.io.*;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Client  {
    public static void main(String[] args) throws IOException{

        Socket socket = new Socket("localhost", 3434);
        InputStream in = socket.getInputStream();
        ObjectInputStream oin = new ObjectInputStream(in);
        String stringFromServer = null;
        try {
            stringFromServer = (String) oin.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        FileWriter writer = new FileWriter("received.txt");
        writer.write(stringFromServer);
        in.close();
        writer.close();

    }

}
