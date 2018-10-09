package childrens;
import java.util.*;

class AgeComparator implements Comparator <Children1> {
   public int compare(Children1 ch1 , Children1 ch2){
	   if(ch1.age == ch2.age) return 0;
	   else if(ch1.age > ch2.age) return 1;
	   else return -1;
   }
	
}
