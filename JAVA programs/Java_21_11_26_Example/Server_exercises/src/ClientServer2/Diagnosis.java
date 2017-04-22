/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientServer2;

/**
 *
 * @author yovo
 */
public enum Diagnosis {
    NOTSICK(10.0), LITTLESICK(20.0), SICK(50.0), VERYSICK(200.0);
    final double cureCost;
    Diagnosis(double cureCost){
        this.cureCost = cureCost;
    }
}
