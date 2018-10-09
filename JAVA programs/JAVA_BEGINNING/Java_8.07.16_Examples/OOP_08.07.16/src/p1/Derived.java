package p1;


//Same package subclass => 
class Derived extends Protecion {
       Derived (){
    	   System.out.println("derived constructor");
    	   System.out.println("n = " + n); // defaut (no modifier)
      	    //    System.out.println("n_pri= " + n_pri);
      	   System.out.println("n_pro = " + n_pro); // protected
      	   System.out.println("n_pub = " + n_pub); //public
       }
}
