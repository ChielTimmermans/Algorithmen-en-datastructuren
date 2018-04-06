import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

public class QuickSort {
	
	public static <E extends Object, T extends Collection<E>> T quickSort(Collection<E> arr) {
		Object[] temp = sort(arr.toArray(), 0, arr.size()-1);
		return (T) new ArrayList<Object>(Arrays.asList(temp));		
	}
	
	public static <T extends Object> T[] quickSort(T[] arr) {
		return sort(arr, 0, arr.length-1);		
	}
	
	private static <T extends Object> T[] sort(T[] arr, int links, int rechts) {
		int l = links;
		int r = rechts;
		T midden = arr[(links+rechts)/2];
		
		Comparator<T> com =new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
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
				T temp = arr[l];
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
	
	public static void main(String[] args) {
    	String path = "src/legosets.csv";
    	ArrayList<Integer> list1 = CSVreader.readCSV(path);
    	ArrayList<Integer> list2 = quickSort(list1);
    	Object[] list = quickSort(list1.toArray());
    	for(int i = 0; i<list.length;i++) {
    		System.out.println(list[i]);
    	}
    	
    }
}
