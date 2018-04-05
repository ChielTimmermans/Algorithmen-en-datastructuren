import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

public class QuickSort {
	
	public static ArrayList<Object> quickSort(Collection<?> arr) {
		Object[] temp = sort(arr.toArray(), 0, arr.size()-1);
		arr.clear();
		return new ArrayList<Object>(Arrays.asList(temp));		
	}
	
	private static Object[] sort(Object[] arr, int links, int rechts) {
		int l = links;
		int r = rechts;
		Object midden = arr[(links+rechts)/2];
		
		Comparator<Object> com =new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
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

<<<<<<< HEAD
	public static void main(String[] args) {
		ArrayList<Integer> temp = CSVreader.readCSV("C:/Users/frank/workspace/ADEindopdracht/src/legosets.csv");
    	ArrayList<Object> test = quickSort(temp);
    	
    	for (int i = 0; i < test.size(); i++) {
    		  System.out.println(test.get(i));   
    	}
	}

=======
>>>>>>> 7076e6d6e03a9c860a480b6c056d127f5eef3018
}
