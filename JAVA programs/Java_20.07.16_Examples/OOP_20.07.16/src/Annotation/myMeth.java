package Annotation;

import java.lang.annotation.*;
import java.lang.reflect.*;

// A single-member annotation.

@Retention(RetentionPolicy.RUNTIME)
@interface MySingle {
// this variable name must be value
String str();
boolean bool();
}


class myMeth {
// Annotate a method using a single-member annotation.
		@MySingle(str = "yovo" , bool =  true )
		
		public static void myMeth1() {
				myMeth ob = new myMeth();
				try {
					Method m = ob.getClass().getMethod("myMeth1");
					MySingle anno = m.getAnnotation(MySingle.class);
					System.out.println(anno.str() + "  ");
					System.out.println(anno.bool() + "  ");
				} catch (NoSuchMethodException exc) {
				   System.out.println("Method Not Found.");
				}
		}
		
		public static void main(String args[]) {
		   myMeth1();
		}
}