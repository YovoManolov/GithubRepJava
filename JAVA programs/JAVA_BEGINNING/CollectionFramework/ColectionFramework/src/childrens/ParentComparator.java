package childrens;

import java.util.Comparator;

class ParentComparator implements Comparator<Children1> {
     public int compare(Children1 ch1 ,Children1 ch2){
    	 return ch1.Parent.compareTo(ch2.Parent);
     }
}
