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
public class PreferencedLetters extends Letters {
    private boolean preferenced;

    public boolean isPreferenced() {
        return preferenced;
    }

    public void setPreferenced(boolean preferenced) {
        this.preferenced = preferenced;
    }

    /**
     *
     * @param preferenced
     * @param text
     * @param sender
     * @param recipient
     * @param dateOfSending
     * @param recieved
     */
    public PreferencedLetters( boolean preferenced ,String text, String sender, String recipient, String dateOfSending, boolean recieved) {
        super(text, sender, recipient, dateOfSending, recieved);
        this.setPreferenced(preferenced);
    }
    
}
