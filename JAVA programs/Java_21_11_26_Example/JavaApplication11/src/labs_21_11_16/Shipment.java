/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs_21_11_16;

/**
 *
 * @author yovo
 */
public class Shipment {
   private String  sender;
   private  String  recipient;
   private  String dateOfSending;
   private boolean recieved;

    public Shipment(String sender, String recipient, String dateOfSending, boolean recieved) {
        this.setSender(sender);
        this.setDateOfSending(dateOfSending);
        this.setRecipient(recipient);
        this.setRecieved(recieved);
    }
    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    /**
     *
     * @return
     */
    public String getDateOfSending() {
        return dateOfSending;
    }

    public void setDateOfSending(String dateOfSending) {
        this.dateOfSending = dateOfSending;
    }

    public boolean isRecieved() {
        return recieved;
    }

    public void setRecieved(boolean recieved) {
        this.recieved = recieved;
    }
  
}
