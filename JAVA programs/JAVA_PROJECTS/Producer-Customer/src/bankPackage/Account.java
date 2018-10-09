package bankPackage;

public class Account {
    private double createAmount = 0 ;

    public synchronized void setAmount(double amount){
        this.createAmount = createAmount + amount;
    }

    double getAmount(){
        return createAmount;
    }
}
