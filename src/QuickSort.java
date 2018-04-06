import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

public class QuickSort {
	
	public static <T extends Collection> T quickSort(Collection<?> arr) {
		Object[] temp = sort(arr.toArray(), 0, arr.size()-1);
		return (T) new ArrayList<Object>(Arrays.asList(temp));		
	}
	
	private static Object[] sort(Object[] arr, int links, int rechts) {
		int l = links;
		int r = rechts;
		Object midden = arr[(links+rechts)/2];
		
		Comparator<Object> com = (o1, o2) -> {
            if(o1 instanceof Integer && o2 instanceof Integer) {
                Integer i1 = (Integer)o1;
                Integer i2 = (Integer)o2;
                return i1.compareTo(i2);
            } else if(o1 instanceof String && o2 instanceof String) {
                String s1 = (String)o1;
                String s2 = (String)o2;
                return s1.compareTo(s2);
            } else {
                return o1.toString().compareTo(o2.toString());
            }
        };
        
		while(l<=r) {
			
			while(com.compare(arr[l], midden) < 0) {
				l++;
			}
			while(com.compare(midden, arr[r]) < 0) {
				r--;
			}
			
			if(l<=r) {
				Object temp = arr[l];
				arr[l] = arr[r];
				arr[r] = temp;
				l++;
				r--;
			}
		}
		
		if(links < r) {
			arr = sort(arr, links, r);
		}
		if(l<rechts) {
			arr = sort(arr, l, rechts);
		}
		return arr;
	}
}
