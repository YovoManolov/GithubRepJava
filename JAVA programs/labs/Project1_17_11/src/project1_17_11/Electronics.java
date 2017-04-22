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
public class Electronics extends Product {
   private final int procent ;
   private String manufacturer;

    /**
     *
     * @param inventoryNumber
     * @param price
     * @param quantity
     * @param p
     * @param manufacturer
     * @param model
     */
    public  Electronics (int inventoryNumber ,double price ,int quantity 
                ,Provider p, String manufacturer ,String model){
        super(inventoryNumber, price, quantity ,p);
        this.setManufacturer(manufacturer);
        this.setModel(model);
        procent = 10;
    }
   
    /**
     *
     * @return
     */
    public String getManufacturer(){
        return manufacturer;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
   private String model;
   
    /**
     *
     * @return
     */
   

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
   
   
    @Override
    double getPromotionalPrice(){     
       double price = this.getPrice();
         price *= (procent/100);
      return price;
     }

     boolean  sellProduct(int piece) throws NoMoreProductsException{
         int inStock ;
        if(this.getQuantity() < piece || this.getQuantity() == 0)
            throw new NoMoreProductsException();
        else {
             inStock = this.getQuantity();
             inStock -= piece ;
             this.setQuantity(inStock);
             System.out.println( piece + " items were successful sold !!!");
             return true;
         }
       
     }
     
     
}
