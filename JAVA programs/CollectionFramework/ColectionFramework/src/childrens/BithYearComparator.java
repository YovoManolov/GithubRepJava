package childrens;

import java.util.Comparator;

class BithYearComparator implements Comparator <Children1>  {
	public int compare(Children1 ch1 , Children1 ch2){ 
		   if(ch1.birthYear == ch2.birthYear) return 0;
		   else if(ch1.birthYear >ch2.birthYear) return 1;
		   else return -1;
	   }
}
