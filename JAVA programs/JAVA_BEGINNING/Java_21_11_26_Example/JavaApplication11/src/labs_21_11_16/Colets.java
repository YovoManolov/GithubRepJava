package labs_21_11_16;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yovo
 */
public class Colets extends Shipment {
   private int weight ;
   private  boolean breakable;

    public Colets(int weight, boolean breakable, String sender, String recipient, String dateOfSending, boolean recieved) {
        super(sender, recipient, dateOfSending, recieved);
        this.setBreakable(breakable);
        this.setWeight(weight);
    }
   
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) throws IllegalArgumentException {
        if(weight < 100){
            throw new IllegalArgumentException("invalid weight"); 
        }
        this.weight = weight;
    }

    public boolean isBreakable() {
        return breakable;
    }

    public void setBreakable(boolean breakable) {
        this.breakable = breakable;
    }

}
