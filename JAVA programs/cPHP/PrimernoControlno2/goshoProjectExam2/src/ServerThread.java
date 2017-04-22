import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
// ���� � ������� ����� �� ��������� ��������� ����� ������� �� ������.
// ��� �� �� ������� ����� � ���� ������, ����� �� � �������.
// �� ����� �� �� �������� ������������� ��� � ������, ����� �� �� �������� ��� ����.
public class ServerThread extends Thread{ // ��������� ����� � ����������� Thread �� �� ����� �����
	private Socket socket; 
	private static final File usersFile = new File("users"); // �������� ��������� �� ������, ����� ������� �������������
	
	public ServerThread(Socket socket) { //������������ ������ ������(�����) �� �� ���� �� ���� ����� ��� �� ���������� ��� �������
		this.socket = socket;
	}
	
	private UserType checkUser(String username,String password){ // �������� �����, ����� �� ������������ ������� ���� ���������� � �� ����� ����� ��� � �����������
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(usersFile));// ������� ������ � �������������
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		String row = null;
		try {
			while((row = br.readLine()) != null){ // ������ ���������� �� ����a
				String[] user = row.split(","); // �������� �������� �� �� ���� ��� � ������
				if(user[0].equals(username) && user[1].equals(password)){ // ���������� ���� ����������� �� ������ � ������� � ���������
					if(user[2].equals("Student")){ // ���������� ���� ����������� � ������� 
						return UserType.Student; // ������ �� ����������� � �������
					}
					if(user[2].equals("Secretary")){ // ���������� ���� ��������� � ����������
						return UserType.Secretary; // ������ �� ����������� � ����������
					}
					return UserType.Error;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return UserType.Error;
	}
	
	@Override
	public void run() {
		try {
			Scanner sc = new Scanner(socket.getInputStream()); // ������� scanner �� ������ �� �������
			String[] userFields = sc.nextLine().split("/"); // �������� �� ������� ���� ���
			UserType ut = checkUser(userFields[0],userFields[1]); // ��������� �� ����� ���������� � ������ ���� �� �����������
			if(ut == UserType.Student){ // ���������� ���� ����������� � ������� 
				new Student(socket).start(); //��������� ����� �� ������� 
			}
			if(ut == UserType.Secretary){ // ���������� ���� ��������� � ����������
				new Secretary(socket).start(); //��������� ����� �� ����������
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
