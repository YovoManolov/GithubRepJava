import java.util.concurrent.Semaphore;

public class Main {

	public static Semaphore semaphore = new Semaphore(1);
	public static int globalVar = 222;
	
	public static void main(String[] args) {
		
		Thread th1 = new Thread(new MyThread(1,3));
		Thread th2 = new Thread(new MyThread(2,5));
		Thread th3 = new Thread(new MyThread(3,7));
		Thread th4 = new Thread(new MyThread(4,17));
		
		th1.start();
		th2.start();
		th3.start();
		th4.start();
	}
}

/*�� �� ������ ������������ �� , �����
�������� 4�� �����.

 ����� �� ������� ��� �� ��� �� 

 ��������� �������� �� ������ �� �����
  � ������ �� ����� ������� � ���������� �� ���� �������� .

  ����� ����� ��������� ��������� k , 

  kogato stojnsta � ������ ����� �� �� ���� ����������� �� k �� ������ ������������ � ������� ����������� ������ � ������� �� k 
������� , 


��� ��� ��������� �� ������ ���������� � ������ �� k , �� ������ �� ������������ � k+1 , a ������� ������� �� ���� ������� .

, �� ��� ��������� �� ����������� ���������� �� ���� �� �������� �� K �� ������� ������� 2k +1 � �� ������� . 


����������� �� � �� ������� ����� �� ��������� 3,5,7,17*/