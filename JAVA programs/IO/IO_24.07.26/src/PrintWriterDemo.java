import java.io.*;
class PrintWriterDemo {

	public static void main(String[] args) {
		PrintWriter pr = new PrintWriter(System.out,true);
		
		int b = -7;
		pr.println(b);
		String str = "YOVO & MAGI*n";
		pr.println(str);
		double d  = 4.354e-8;
        pr.println(d);
	}

}
