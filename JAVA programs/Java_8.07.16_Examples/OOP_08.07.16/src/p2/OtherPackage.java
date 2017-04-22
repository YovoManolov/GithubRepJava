package p2;

class OtherPackage { //diff package non subclass (just public)
     p1.Protecion ob = new p1.Protecion();
     
     Protecion (){
    	 System.out.println("OtherPackage constructor");
    	// System.out.println("n = " + ob.n); 
    	 //System.out.println("n_pri= " + ob.n_pri);
    	// System.out.println("n_pro = " + ob.n_pro);
    	 System.out.println("n_pub = " + ob.n_pub);
     }
}
