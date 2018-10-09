/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam;

/**
 *
 * @author yovo
 */

public class NoMoreTicketsException extends Exception {
    private String nameOfEvent = null;
    
    public NoMoreTicketsException(String nameOfEvent){
      super();
      this.nameOfEvent = nameOfEvent;
    }
    @Override
    public String getMessage() {
      return("There are no more tickets for " + nameOfEvent);
    }
}
