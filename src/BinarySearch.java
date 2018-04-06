import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

public class BinarySearch {
	
	public static int binarySearch(Collection<?> arr, Object key) {
		return runBinarySearchRecursively(arr.toArray(), key, 0, arr.size()-1);
	}
	
	public static <T extends Object> int binarySearch(T[] arr, T key) {
		return runBinarySearchRecursively(arr, key, 0, arr.length-1);
	}
	
    public static <T extends Object> int runBinarySearchRecursively(T[] arr, T key, int low, int high){
        int middle = (low + high)/2;

        if (high < low) {
            return -1;
        }
        
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
        
        if (key.equals(arr[middle])){
            return middle;
        } else if (com.compare(key, arr[middle]) < 0){
            return runBinarySearchRecursively(arr, key, low, middle-1);
        } else{
            return runBinarySearchRecursively(arr, key, middle+1, high);
        }
    }

    public static int runBinarySearchIteratively(Object[] arr, Object key, int low, int high){
        int index = -1;
        
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

        while(low <= high){
            int mid = (low + high)/2;
            if (com.compare(arr[mid], key) <0){
                low = mid+1;
            } else if (com.compare(arr[mid], key) > 0){
                high = mid-1;
            }else if (com.compare(arr[mid], key) == 0){
                index = mid;
                break;
            }
        }
        return index;
    }
    
    public static void main(String[] args) {
    	String path = "src/legosets.csv";

    	ArrayList<Integer> list = CSVreader.readCSV(path);
    	list = QuickSort.quickSort(list);
    	for(int i = 0; i < list.size(); i++) {
    		System.out.println(list.get(i));
    	}
    	System.out.println(binarySearch(list, 10243));
    	
    }
}

