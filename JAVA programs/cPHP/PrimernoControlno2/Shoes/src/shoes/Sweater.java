/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoes;

/**
 *
 * @author yovo
 */
public class Sweater {
    enum enumSize {S,M,L,XL,XXL}
    public int model ;
    enumSize size;    
    public int deliveryPrice ;
    public int sellPrice;

    /**
     *
     * @param model
     * @param size
     * @param deliveryPrice
     * @param sellPrice
     */
    public Sweater(int model, enumSize size, int deliveryPrice, int sellPrice) {
        if(1<=model && model >= 10){
            this.model = model;
        }else System.out.println("model out of range !!!");
        this.size = size;
        if((5<=deliveryPrice && deliveryPrice >= 40)
            &&(5<=sellPrice && sellPrice >= 40)){
        this.deliveryPrice = deliveryPrice;
        this.sellPrice = sellPrice;
        }else System.out.println("prices out of range !!!");
    }
}
