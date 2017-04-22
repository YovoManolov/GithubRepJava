/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Student;

import java.io.Serializable;

/**
 *
 * @author yovo
 */
public class Document implements Serializable{
    
    private static final long serialVersionUID = 2L;
      
    public String name ;
    public double success;
    public double incomPerPerson;
    public String faculty;
    
    /**
     *
     * @param name
     * @param success
     * @param incomPerPerson
     * @param faculty
     */
    public Document( String name,double success, double incomPerPerson, String faculty) {
        this.name = name;
        this.success = success;
        this.incomPerPerson = incomPerPerson;
        this.faculty = faculty;
    }
}
