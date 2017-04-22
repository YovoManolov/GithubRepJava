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
public class Shoes {
    public int model ;
    public byte number;    
    public int deliveryPrice ;
    public int sellPrice;
    
    //cenata na dostavka trqbva vinagi da bude po niska ot cenat na prodajba
    public Shoes(int model, byte number, int deliveryPrice, int sellPrice) {
        if(1<=model && model >= 20){
            this.model = model;
        }else System.out.println("model out of range !!!");
        if(33<=model && model >= 50)
        this.number = number;
        
        if((20 <= deliveryPrice && deliveryPrice >= 200)
            &&(20<=sellPrice && sellPrice >= 200)){
            
        this.deliveryPrice = deliveryPrice;
        if(sellPrice > deliveryPrice ) this.sellPrice = sellPrice;
        
        }else System.out.println("prices out of range !!!");
    }
    
}
