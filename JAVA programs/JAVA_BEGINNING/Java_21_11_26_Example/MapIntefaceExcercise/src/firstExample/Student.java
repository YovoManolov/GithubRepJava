/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstExample;

import java.util.HashMap;
import java.util.Objects;

/**
 *
 * @author yovo
 */
public class Student extends Person{

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (!Objects.equals(this.facultyNumber, other.facultyNumber)) {
            return false;
        }
        if (!Objects.equals(this.grades, other.grades)) {
            return false;
        }
        return true;
    }
   String facultyNumber;
   private HashMap<Subject, StandartGrade> grades;

    /**
     *
     * @param name
     * @param age
     * @param faculityNumber
     */
    public Student(String name, int age,String faculityNumber) {
        super(name, age);
        this.facultyNumber = faculityNumber;
        this.grades = new HashMap <Subject,StandartGrade>(10);
    }
    int getGrade(Subject subject){
        StandartGrade result = this.grades.get(subject);
        if(result!= null)return result.toInt();
        else return StandartGrade.SLAB.toInt();
    }
        
    void setGrade(Subject subject ,StandartGrade grade){
       this.grades.put(subject,grade);
    }
    
    void printGrade(Subject subject){
        System.out.println(this.name + " има " + this.getGrade(subject)+
                       " по предмета " + subject.name);
    }
}
