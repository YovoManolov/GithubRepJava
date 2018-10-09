/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads_home;

import Thread_Runnable.MyThread;

/**
 *
 * @author yovo
 */
public class Test {

	public static void main(String[] args) {

		MyThread th = new MyThread("NameOfThread");
		th.start();
		System.out.println("I am the main thread");
	}
}

 class MyThread extends Thread {
	public MyThread(String name) {
		super(name);
	}

	void print() {
		System.out.println("I am  thread " + this.getName());
	}

        @Override
	public void run() {
		this.print();
	}
}