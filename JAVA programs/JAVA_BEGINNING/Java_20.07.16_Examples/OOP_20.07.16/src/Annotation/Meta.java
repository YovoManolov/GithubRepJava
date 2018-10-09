package Annotation;
import java.lang.annotation.*;
import java.lang.reflect.*;

//RUNTIME , CLASS , SOURCE - annotation retention policies
//@Retention(retention-policy)   // retention -  задържане , спиране
@Retention(RetentionPolicy.RUNTIME)
 
@interface MyAnno {
    String str ();
    int val();
    }

class Meta {
	
	@MyAnno(str = "Annotation Example" , val = 100)
	
	public static void MyMeth(){
		Meta ob = new Meta();
				
	try{  
		/*
		 final Class<?> getClass( )
			It returns the Class object that represents the invoking object.
			*/
		//" c "  represents the invoking object.
		   Class<?> c = ob.getClass();
		   
		   Method m = c.getMethod("MyMeth"); 	
		   
		   //<A extends Annotation> getAnnotation(Class<A> annoType)
		   MyAnno anno = m.getAnnotation(MyAnno.class);
		   
		   
		    System.out.println(anno.str() +  " "+ anno.val());
		    
		 }catch(NoSuchMethodException e){
			System.out.println("Method not found !!!");
		}
							
	}
	
	public static void main(String[] args){
		MyMeth();
	}
	
}
