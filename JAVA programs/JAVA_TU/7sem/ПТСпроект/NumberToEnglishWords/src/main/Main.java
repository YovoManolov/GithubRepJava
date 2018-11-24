package main;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/NumberToEnglishWords")
public class Main extends Application{
		
		private Set<Object> singletons = new HashSet<Object>();

		public Main() {
			singletons.add(new NumberToEnglishWords());
		}

		@Override
		public Set<Object> getSingletons() {
			return singletons;
		}
		
		/*NumberToEnglishWords numberToEnglishWords = new NumberToEnglishWords();
		
	    System.out.println("*** " + numberToEnglishWords.convert(0));
	    System.out.println("*** " + numberToEnglishWords.convert(1));
	    System.out.println("*** " + numberToEnglishWords.convert(16));
	    System.out.println("*** " + numberToEnglishWords.convert(100));
	    System.out.println("*** " + numberToEnglishWords.convert(118));
	    System.out.println("*** " + numberToEnglishWords.convert(200));
	    System.out.println("*** " + numberToEnglishWords.convert(219));
	    System.out.println("*** " + numberToEnglishWords.convert(800));
	    System.out.println("*** " + numberToEnglishWords.convert(801));
	    System.out.println("*** " + numberToEnglishWords.convert(1316));
	    System.out.println("*** " + numberToEnglishWords.convert(1000000));
	    System.out.println("*** " + numberToEnglishWords.convert(2000000));
	    System.out.println("*** " + numberToEnglishWords.convert(3000200));
	    System.out.println("*** " + numberToEnglishWords.convert(700000));
	    System.out.println("*** " + numberToEnglishWords.convert(9000000));
	    System.out.println("*** " + numberToEnglishWords.convert(9001000));
	    System.out.println("*** " + numberToEnglishWords.convert(123456789));
	    System.out.println("*** " + numberToEnglishWords.convert(2147483647));
	    System.out.println("*** " + numberToEnglishWords.convert(3000000010L));

	    
	     *** zero
	     *** one
	     *** sixteen
	     *** one hundred
	     *** one hundred eighteen
	     *** two hundred
	     *** two hundred nineteen
	     *** eight hundred
	     *** eight hundred one
	     *** one thousand three hundred sixteen
	     *** one million
	     *** two millions
	     *** three millions two hundred
	     *** seven hundred thousand
	     *** nine millions
	     *** nine millions one thousand
	     *** one hundred twenty three millions four hundred
	     **      fifty six thousand seven hundred eighty nine
	     *** two billion one hundred forty seven millions
	     **      four hundred eighty three thousand six hundred forty seven
	     *** three billion ten
	     **/
}
