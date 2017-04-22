package PexesoServer;
import java.io.IOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.LinkedList;
import java.util.ArrayList;

public class PexesoServer{
  // ���� �� ������ ��� �������
  static int port = 1234;
  static int usersPerGame = 3;
  public static void main(String [] args){
    // ���������� �������
    ServerSocket servSock;
    try{
      servSock = new ServerSocket(port);
    }
    catch(IOException e){
      System.err.println("Can't start server");
      return;
    }
    System.out.println("Server started");
    
    // �� �������� ��� �������� id �� ���������� ����
    int lastGameID = 1;
    
    // �� ��������� ��������� ������
    LinkedList<User> usersQueue = new LinkedList<User>();
    // ������������� �������� ��� ��������� �� ��������,
    // �� � ����������� ��������� ������
    synchronized(usersQueue){
      // �������� ����� �� �������� �� ���� ������
      mainloop: while(true){
        // ��� �� ������� ����������
        User u = new User();
        try{
          // �������� ��� ������
          u.initSocket(servSock.accept());
          System.out.println("New user is connected");
          // �������� �� � �������
          usersQueue.add(u);
          // ������� �� �� ������
          u.send("SRV: Please wait for opponents");
        }
        catch(IOException e){
          // ��� ��� ������� - ��� �������� ��� ���
          // ��������� �� �����������, - ���������� �������
          System.out.println("Connection to user failed");
          usersQueue.remove(usersQueue.indexOf(u));
          continue mainloop;
        }
        
        // ��� ���� ��� ��������� ����� ������
        if(usersQueue.size() == usersPerGame){
          // ��������� �� ���� ��������� �� �����.
          // ���� �� ���������, �� ������ �� �������
          for(User tu: usersQueue){
            try{
              tu.send("SRV: Please wait a bit more...");
            }
            catch(IOException userIsGone){
              // ���������� �������� �����
              usersQueue.remove(usersQueue.indexOf(tu));
              // ��� ����� �� �������� ������, ��
              // �� ������� �� ������ ������� ���� � �� ��
              // ������� �� ������� ��� ����� �� ��� �����
            }
          }
          
          // ��� �� �������� ��������, �� ������ ���
          if(usersQueue.size() != usersPerGame) continue mainloop;
          // ��� �� �������, ����� � �� ������ ����!
          else{
            // ������ ����� �� ������� � ��������
            LinkedList<User> UQCopy = new LinkedList<User>();
            for(User i: usersQueue){
              UQCopy.add(i);
            }
            // ��������� ������ � ����������
            usersQueue = new LinkedList<User>();
            // ���������� ������ � �������
            Thread t = new Thread(
                                  new PexesoGame(lastGameID, UQCopy));
            t.start();
            System.out.println("Game id "+lastGameID+" started");
            lastGameID++;
          }
        }
      }
    }
  }
}  

// ���� ���� ���� �� ������������ � ������� ������
class User{
  Socket s;
  DataInputStream in;
  DataOutputStream out;
  int points;
  int number;
  
  // �������� �� �� ������ �����������
  public User(){
    this.points = 0;
    this.number = 0;
  }
  
  // ��� �������������� ��������
  void initSocket(Socket s) throws IOException{
    this.s = s;
    in = new DataInputStream(s.getInputStream());
    out = new DataOutputStream(s.getOutputStream());
  }
  
  // �� ��������� �� ��������� �� �����
  void send(String msg)  throws IOException{
    this.out.writeUTF(msg);
  }
  
  // �� ���������� �� ������� �� �����
  int get() throws IOException{
    return this.in.readInt();
  }
}

class PexesoBoard{
  int[][] board;
  public PexesoBoard(int n, int m) throws Exception{
    if((n*m)%2 != 0) throw new Exception("Please choose n*m even");
    this.board = new int[n][m];
    int element = 1;
    int changeFlag = 1;
    for(int i=0; i<n; i++){
      for(int j=0; j<m; j++){
        this.board[i][j] = element;
        if(changeFlag%2 == 0) element++;
        changeFlag++;
      }
    }
    this.shuffle();
  }
  
  private void shuffle(){
    java.util.Random rnd = new java.util.Random();
    for(int i=0; i<this.board.length; i++){
      for(int j=0; j<this.board[i].length; j++){
        int newRow = rnd.nextInt(this.board.length);
        int newColumn = rnd.nextInt(this.board[i].length);
        int copyEl = this.board[newRow][newColumn];
        this.board[newRow][newColumn] = this.board[i][j];
        this.board[i][j] = copyEl;
      }
    } 
  }
  
  int doMove(int i, int j, int n, int m) throws Exception{
    if(i<0 || i>this.board.length ||
       j<0 || j>this.board.length ||
       n<0 || n>this.board[0].length ||
       m<0 || m>this.board[0].length ||
       (i==n && j==m) ||
       this.board[i][j] == -1 ||
       this.board[n][m] == -1
      ){
      throw new Exception("Invalid coordinates");
    }
    if(this.board[i][j] == this.board[n][m]){
      int result = this.board[i][j];
      this.board[i][j] = -1;
      this.board[n][m] = -1;
      return result;
    }
    else return -1;
  }
  
  boolean noMoreElements(){
    for(int i=0; i<this.board.length; i++){
      for(int j=0; j<this.board[i].length; j++){
        if(this.board[i][j]!=-1) return false;
      }
    }
    return true;
  }
}


// ������ ���� �� ���������� �� ���
class PexesoGame implements Runnable{
  int id;                 // ����� �� ������
  int activePlayers;      // ����� ������� ������ ���
  LinkedList<User> users; // ������ � ��������
  int playerOnTurn;       // ��� ����� � �� ���
  PexesoBoard PB;         // ������� � ����������
  
  // �����������
  public PexesoGame(int id, LinkedList<User> users){
    this.id = id;
    this.users = users;
    this.playerOnTurn = 0;
    this.sendToAll("SRV: Game started. "+
                   "Player 1 is choosing board size...");
  }
  
  // ������ �������
  public void run(){
    // � ���� ���� ������� ��������� �� ������� �� ����� 1
    try{
      users.get(playerOnTurn).send("SRV: Please send board size:");
      this.PB = new PexesoBoard(users.get(playerOnTurn).get(), users.get(playerOnTurn).get());
    }
    catch(Exception e){
      sendToAll("SRV: Player 1 sent incorrect board size");
      sendToAll("SRV: We will use the default board size - (5,4)");
      try{
        this.PB = new PexesoBoard(5,4);
      }
      catch(Exception e3){
        System.err.println("Something bad happened in game "+this.id);
      }
    }
    
    for(this.playerOnTurn=0; playerOnTurn<users.size(); playerOnTurn++){
      try{
        users.get(playerOnTurn).number = playerOnTurn+1;
        users.get(playerOnTurn).send("SRV: You are player "+users.get(playerOnTurn).number);
        
      }
      catch(IOException e){
        this.sendToAll("SRV: Player "+users.get(playerOnTurn).number+" has left the game");
      }
    }
    this.sendToAll("SRV: Sending board...");
    this.sendToAll(this.PB.board.length+","+this.PB.board[0].length);
    playerOnTurn = 0;
    this.sendToAll("SRV: Board is updated");
    
    // ���� ��� ������ �� �������� �� ��������
    this.sendToAll("SRV: We are ready to go. Player 2's turn");
    
    // ����� �������� �� ���� ����� �� � ��� �� �����
    runloop: while(true){
      // ��� ���� � ����� ��������� �����, ������� �� �����
      if(playerOnTurn < PexesoServer.usersPerGame-1) playerOnTurn++;
      else playerOnTurn=0;
      
      // ��� ����� ���� ���� ������� �����, ��� ������
      if(this.users.size()<2){
        this.sendToAll("SRV: All players left. You win");
        this.sendToAll("SRV: BYE");
        break runloop;
      }
      // ��� �� �� �������� �������� �� �������, ���������� ��� ����� ����� ���
      if(PB.noMoreElements()){
        this.sendToAll("SRV: Board is clear");
        StringBuilder strb = new StringBuilder();
        for(int i=0; i<users.size(); i++){
          strb.append("Player "+(i+1)+": "+this.users.get(i).points+" points\n");
        }
        this.sendToAll("SRV: Standings:\n"+strb.toString());
        this.sendToAll("SRV: BYE");
        break runloop;
      }      
      byte mistakes = 0;   // ���� ��������� ������
      
      // �� ��������� ���� � ������ ��� ������� ��������
      int fountMatch = -1;
      

      
      moveloop:while(true){
        // ��� �� ������� 3 ������, �� �� �������
        if(mistakes==3){
          sendToAll("SRV: Player "+users.get(playerOnTurn).number+
                    " is disconnected for too many wrong moves");
          this.removeUser(playerOnTurn);
          break moveloop;
        }
        try{
          // ����� ���������� �� �� ������� ���
          users.get(playerOnTurn).send("SRV: Please enter (i,j) and (n,m):");

          // ���������� �� ������ (i,j) � (n,m)
          int moveI = users.get(playerOnTurn).get();
          int moveJ = users.get(playerOnTurn).get();
          int moveN = users.get(playerOnTurn).get();
          int moveM = users.get(playerOnTurn).get();
          
          fountMatch = this.PB.doMove(moveI,moveJ,moveN,moveM);
          
          if(fountMatch!=-1){
            this.users.get(playerOnTurn).points++;
            this.sendToAll("SRV: Player "+users.get(playerOnTurn).number+" scores!");
            this.sendToAll("SRV: Updating board...");
            this.sendToAll(""+fountMatch);
            this.sendToAll(moveI+","+moveJ);
            this.sendToAll(moveN+","+moveM);
          }
          else{
            this.sendToAll("SRV: Player "+users.get(playerOnTurn).number+" misses!");
          }
        }
        // ��� get ������ �� User ����� ����������
        catch(IOException e){
          sendToAll("SRV: Player "+users.get(playerOnTurn).number+" has left the game");
        }
        // ��� doMove �� PB ����� ����������
        catch(Exception e2){
          mistakes++;
          continue moveloop;
        }
        // ��� ���� ����������, ����� ��� ����� ������� ���
        break moveloop;
      }
      // ����������� ������ ���� � ������� �����

      //this.sendToAll("SRV: Board status is:\n"+this.PB.toPrint());
    }
    // � ���� �� �������� ���������� ������ �����������
    for(int i=0; i<users.size(); i++){
      removeUser(i);
    }
    System.out.println("Game "+this.id+" ended");
  }
  
  // ����� �� ��������� �� ��������� �� ������
  private void sendToAll(String msg){
    for(int i=0; i<users.size(); i++){
      try{
        users.get(i).send(msg);
      }
      catch(IOException e){
        this.removeUser(i);
      } 
    }
  }
  
  // �� ��������� �� ����� �� ������
  private void removeUser(int i){
    // ���� � ��-����� �� �� ������� ���� �����
    // � ���� users. ��� ����� ���������� ������������
    try{
      if(users.get(i).in!=null) users.get(i).in.close();
      if(users.get(i).out!=null) users.get(i).out.close();
      if(users.get(i).s!=null) users.get(i).s.close();
    }
    catch(IOException e){}
    
    // ���������� ������
    this.users.remove(i);
    
    // ���� �� ����� ��������!
    // SendToAll ���� ������� removeUser :)
    this.sendToAll("SRV: Player "+
                   (i+1)+" has left the game");
  }
}