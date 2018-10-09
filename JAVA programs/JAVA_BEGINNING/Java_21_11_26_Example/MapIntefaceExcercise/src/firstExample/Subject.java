/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstExample;

import java.util.Objects;

/**
 *
 * @author yovo
 */
public class Subject {
    String name;
    Person proffesor;
    Subject(String name,Person proffesor){
        this.name = name;
        this.proffesor = proffesor;         
    }
    @Override
    public int hashCode(){
       int result = 17;
        result = result*37 + this.name.hashCode();
        result = this.proffesor.hashCode() + result*37;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Subject other = (Subject) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.proffesor, other.proffesor)) {
            return false;
        }
        return true;
    }
}
