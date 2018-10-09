/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1_17_11;

/**
 *
 * @author yovo
 */
public abstract class Product {
    
    private int inventoryNumber ;
    private double price;
    private int quantity;
    private Provider p ;
    
    
    public Product( int inventoryNumber ,double price ,int quantity, Provider p ){
        this.setInventoryNumber(inventoryNumber);
        this.setPrice(price);
        this.setQuantity(quantity); 
        this.setProvider(p);      
    }
            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public int getQuantity() {
                return quantity;
            }

            public void setQuantity(int quantity) {
                this.quantity = quantity;
            }

            public Provider getProvider() {
                return p;
            }

            public void setProvider(Provider provider) {
                this.p = provider;
            }

            void setInventoryNumber(int inventoryNumber){
                this.inventoryNumber = inventoryNumber;
            }

            int getInventNumb (){
                return this.inventoryNumber;
            }


     abstract double getPromotionalPrice();
  
}
