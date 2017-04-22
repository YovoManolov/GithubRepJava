package PexesoServer;
import java.io.IOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.LinkedList;
import java.util.ArrayList;

public class PexesoServer{
  // Порт за връзка със сървъра
  static int port = 1234;
  static int usersPerGame = 3;
  public static void main(String [] args){
    // Стартираме сървъра
    ServerSocket servSock;
    try{
      servSock = new ServerSocket(port);
    }
    catch(IOException e){
      System.err.println("Can't start server");
      return;
    }
    System.out.println("Server started");
    
    // За удобство сме добавили id на различните игри
    int lastGameID = 1;
    
    // Ще записваме новодошли играчи
    LinkedList<User> usersQueue = new LinkedList<User>();
    // Предотвратява проблеми при изтриване на свързани,
    // но в последствие напуснали играчи
    synchronized(usersQueue){
      // Безкраен цикъл за приемане на нови играчи
      mainloop: while(true){
        // Тук ще запишем новодошлия
        User u = new User();
        try{
          // Приемаме нов клиент
          u.initSocket(servSock.accept());
          System.out.println("New user is connected");
          // Добавяме го в списъка
          usersQueue.add(u);
          // Казваме му да изчака
          u.send("SRV: Please wait for opponents");
        }
        catch(IOException e){
          // Ако има проблем - при връзката или при
          // изпращане на съобщението, - премахваме клиента
          System.out.println("Connection to user failed");
          usersQueue.remove(usersQueue.indexOf(u));
          continue mainloop;
        }
        
        // Ако вече има натрупани двама играчи
        if(usersQueue.size() == usersPerGame){
          // Изпращаме по едно съобщение на всеки.
          // Така се уверяваме, че всички са налични
          for(User tu: usersQueue){
            try{
              tu.send("SRV: Please wait a bit more...");
            }
            catch(IOException userIsGone){
              // Премахваме напуснал играч
              usersQueue.remove(usersQueue.indexOf(tu));
              // Тук можем да уведомим другия, че
              // не успяхме да пуснем тяхната игра и да го
              // помолим да изчакат още малко за нов играч
            }
          }
          
          // Ако са намаляли играчите, ще търсим нов
          if(usersQueue.size() != usersPerGame) continue mainloop;
          // Ако са налични, време е да пуснем игра!
          else{
            // Правим копие на списъка с играчите
            LinkedList<User> UQCopy = new LinkedList<User>();
            for(User i: usersQueue){
              UQCopy.add(i);
            }
            // Основната опашка я изпразваме
            usersQueue = new LinkedList<User>();
            // Стартираме играта с копието
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

// Чрез този клас ще комуникираме с отделни играчи
class User{
  Socket s;
  DataInputStream in;
  DataOutputStream out;
  int points;
  int number;
  
  // Всъщност не ни трябва конструктор
  public User(){
    this.points = 0;
    this.number = 0;
  }
  
  // Тук инициализираме връзката
  void initSocket(Socket s) throws IOException{
    this.s = s;
    in = new DataInputStream(s.getInputStream());
    out = new DataOutputStream(s.getOutputStream());
  }
  
  // за изпращане на съобщение до играч
  void send(String msg)  throws IOException{
    this.out.writeUTF(msg);
  }
  
  // за получаване на отговор от играч
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


// Самата игра се контролира от тук
class PexesoGame implements Runnable{
  int id;                 // номер на играта
  int activePlayers;      // колко активни играча има
  LinkedList<User> users; // списък с играчите
  int playerOnTurn;       // кой играч е на ход
  PexesoBoard PB;         // дъската с картинките
  
  // Конструктор
  public PexesoGame(int id, LinkedList<User> users){
    this.id = id;
    this.users = users;
    this.playerOnTurn = 0;
    this.sendToAll("SRV: Game started. "+
                   "Player 1 is choosing board size...");
  }
  
  // Играта започва
  public void run(){
    // В този блок взимаме размерите на дъската от играч 1
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
    
    // Вече сме готови да заиграем по същество
    this.sendToAll("SRV: We are ready to go. Player 2's turn");
    
    // Всяка итерация на този цикъл ще е ход на играч
    runloop: while(true){
      // Ако вече е играл последния играч, връщаме на първи
      if(playerOnTurn < PexesoServer.usersPerGame-1) playerOnTurn++;
      else playerOnTurn=0;
      
      // Ако имаме само един останал играч, той печели
      if(this.users.size()<2){
        this.sendToAll("SRV: All players left. You win");
        this.sendToAll("SRV: BYE");
        break runloop;
      }
      // Ако не са останали картинки на дъската, определяме кой колко точки има
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
      byte mistakes = 0;   // брой направени грешки
      
      // Ще записваме дали е уцелил две еднакви картинки
      int fountMatch = -1;
      

      
      moveloop:while(true){
        // Ако са станали 3 грешки, ще го изгоним
        if(mistakes==3){
          sendToAll("SRV: Player "+users.get(playerOnTurn).number+
                    " is disconnected for too many wrong moves");
          this.removeUser(playerOnTurn);
          break moveloop;
        }
        try{
          // Иначе подканваме го да направи ход
          users.get(playerOnTurn).send("SRV: Please enter (i,j) and (n,m):");

          // Координати за клетки (i,j) и (n,m)
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
        // Ако get метода на User върне изключение
        catch(IOException e){
          sendToAll("SRV: Player "+users.get(playerOnTurn).number+" has left the game");
        }
        // Ако doMove на PB върне изключение
        catch(Exception e2){
          mistakes++;
          continue moveloop;
        }
        // ако няма изключение, значи сме имали валиден ход
        break moveloop;
      }
      // Уведомяваме всички дали е получил точка

      //this.sendToAll("SRV: Board status is:\n"+this.PB.toPrint());
    }
    // В края на програма изхвърляме всички потребители
    for(int i=0; i<users.size(); i++){
      removeUser(i);
    }
    System.out.println("Game "+this.id+" ended");
  }
  
  // Метод за изпращане на съобщение до всички
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
  
  // За изтриване на играч от масива
  private void removeUser(int i){
    // Това е по-добре да се направи като метод
    // в клас users. Тук пряко нарушаваме капсулацията
    try{
      if(users.get(i).in!=null) users.get(i).in.close();
      if(users.get(i).out!=null) users.get(i).out.close();
      if(users.get(i).s!=null) users.get(i).s.close();
    }
    catch(IOException e){}
    
    // Премахваме играча
    this.users.remove(i);
    
    // Може да стане рекурсия!
    // SendToAll също извиква removeUser :)
    this.sendToAll("SRV: Player "+
                   (i+1)+" has left the game");
  }
}