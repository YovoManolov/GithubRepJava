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
public class Letters extends Shipment {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    public Letters(String text,String sender, String recipient, String dateOfSending, boolean recieved) {
        super(sender, recipient, dateOfSending, recieved);
        this.setText(text);
    }
    
    
    
}
