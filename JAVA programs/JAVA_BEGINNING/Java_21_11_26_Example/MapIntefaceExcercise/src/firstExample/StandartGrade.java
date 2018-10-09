/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstExample;

/**
 *
 * @author yovo
 */
public enum StandartGrade {
    SLAB(2),SREDEN(3),DOBYR(4),MNOGO_DOBYR(5),OTLICHEN(6);
    private int grade;
    
    private StandartGrade(int grade){
        this.grade = grade;
    }
   
    int toInt(){
        return this.grade;
    }
};
