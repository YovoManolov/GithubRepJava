/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientPackage;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Client {
    public static void main(String args[]) throws IOException {
		
		Socket s = new Socket("localhost", 35555);
		Scanner scan = new Scanner(System.in);
		Scanner scan2 = new Scanner(s.getInputStream());
		PrintStream printout = new PrintStream(s.getOutputStream());
		System.out.println("Enter first number: ");
		try {   
			number1 = scan.nextInt();
			printout.println(number1);
                        System.out.println("Enter second number");
                        number2 = scan.nextInt();
			printout.println(number2);
			String input = scan2.nextLine();
			System.out.println("The result is : " + input);
		} catch (InputMismatchException e) {
			System.out.println("Enter a correct value");
		} finally {
			if (s != null)
				s.close();
			if (scan != null)
				scan.close();
			if (scan2 != null)
				scan2.close();
		}
	}
}
