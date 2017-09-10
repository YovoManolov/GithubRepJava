package bankPackage;

public class Bank {
    public static void main(String[] args) throws
        InterruptedException {
        for(int i =1 ; i<1000 ; i++){
            Account ob = new Account();
            ClientThread obj1 = new ClientThread(ob,100);
            ClientThread obj2 = new ClientThread(ob,200);
            ClientThread obj3 = new ClientThread(ob,300);
            ClientThread obj4 = new ClientThread(ob,400);
            ClientThread obj5= new ClientThread(ob,500);

            Thread T1 = new Thread(obj1);
            Thread T2 = new Thread(obj2);
            Thread T3 = new Thread(obj3);
            Thread T4 = new Thread(obj4);
            Thread T5 = new Thread(obj5);
            Thread T6 = new Thread(obj5);
            Thread T7 = new Thread(obj2);
            Thread T8 = new Thread(obj3);
            Thread T9 = new Thread(obj5);
            Thread T10 = new Thread(obj2);

            T1.start();
            T2.start();
            T3.start();
            T4.start();
            T5.start();
            T6.start();
            T7.start();
            T8.start();
            T9.start();
           // T10.start();

            Thread.sleep(100);
            if(ob.getAmount() != 3000)
                    System.out.println(ob.getAmount());
        }
    }
}
