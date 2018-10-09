package p1;

class SamePackage { //Same package non subclass
      
     SamePackage(){	
	     Protecion p = new Protecion();
       
    	 System.out.println("SamePackage constructor");
      	 System.out.println("n = " + p.n); 
      	// System.out.println("n_pri= " + p.n_pri);
      	 System.out.println("n_pro = " + p.n_pro);
      	 System.out.println("n_pub = " +p.n_pub);
       }
}
