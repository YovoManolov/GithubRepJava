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
public class Book extends Product {
    private String author;
    private String title;
    private final int procent ;
    
    /**
     *
     * @param inventoryNumber
     * @param price
     * @param quantity
     * @param p
     * @param author
     * @param title
     */
    public Book (int inventoryNumber ,double price ,int quantity 
                ,Provider p, String author ,String title){
        super(inventoryNumber, price, quantity ,p);
        this.setAuthor(author);
        this.setTitle(title);
        procent = 50;
    }
    
    /**
     *
     * @param author
     */
    public void setAuthor(String author){
        this.author = author;
    }

    /**
     *
     * @return
     */
    public String getAuthor(){
        return this.author;
    }

    /**
     *
     * @param title
     */
    public void setTitle(String title){
        this.title  = title;
    }

    /**
     *
     * @return
     */
    public String getTitle(){
        return this.title;
    }
        
     @Override
     double getPromotionalPrice(){ 
         double price = this.getPrice();
         price *= (procent/100);
      return price;
     }

     boolean  sellProduct(int piece) throws NoMoreProductsException{
        int inStock ;
        if(this.getQuantity() < piece || this.getQuantity() == 0) throw new NoMoreProductsException();
        else {
             inStock = this.getQuantity();
             inStock -= piece ;
             this.setQuantity(inStock);
             System.out.println( piece + " items were successful sold !!!");
             return true;
         }
    }
}