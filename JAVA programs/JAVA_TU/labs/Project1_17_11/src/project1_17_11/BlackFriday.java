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
public class BlackFriday {
    public static void main(String[] args){
    Product []p  = new Product [3]; 
  
    Provider prov  = new Provider("Ivan", "0895123432");   
    Book b = (Book) p[0] , b1 = (Book)p[2];
    b = new Book(4567, 123.324, 24, prov,"Dostoevski","War and peace");
    p[0] = b;
    Electronics e = (Electronics) p[1];
    e = new Electronics(98765, 400.324, 20, prov ,"LG","G500");
    p[1] = e;
    b1 = new Book(1234567, 123.324, 24, prov,"Dostoevski","War");
    p[2] = b1;
    
    ProductWriter.saveInFile(p);
    
   }

    
    /**
     *
     * @param p
     * @return
     */
   

}
