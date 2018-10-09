package ConstrRefDemo3;

class MyClass2 {
     String str ;
     
     MyClass2(String strv){
    	 str = strv;
     }
     MyClass2(){
    	 str = " No string as param" ;
     }
     
     String getVal(){
    	 return str;
     }
}
