/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientServer2;

import java.io.Serializable;

/**
 *
 * @author yovo
 */
public class Report implements Serializable{
    private static final long serialVersionUID = 5L;
    public String message;
    Patient p = null;
    public Report(String message) {
        this.message = message;
    }

    Report(Patient p) {
        this.p = p;
    }
    
}
