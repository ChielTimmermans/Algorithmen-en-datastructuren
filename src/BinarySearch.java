import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

public class BinarySearch {
<<<<<<< HEAD
	
	public static int binarySearch(Collection<?> arr, Object key) {
		return runBinarySearchRecursively(arr.toArray(), key, 0, arr.size());
	}
	
    public static int runBinarySearchRecursively(Object[] arr, Object key, int low, int high){
        int middle = (low + high)/2;
=======
>>>>>>> 7076e6d6e03a9c860a480b6c056d127f5eef3018

    public static int binarySearch(ArrayList<Integer> arr, int key) {
        return runBinarySearchRecursively(arr, key, 0, arr.size());
    }

    public static int runBinarySearchRecursively(ArrayList<Integer> arr, int key, int low, int high) {
        //Get the middle number between low and high
        int middle = (low + high) / 2;

        //Search ends here, search key is not found
        if (high < low) {
            return -1;
        }
<<<<<<< HEAD
        
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
        
        if (key.equals(arr[middle])){
            return middle;
        } else if (com.compare(key, arr[middle]) < 0){
            return runBinarySearchRecursively(arr, key, low, middle-1);
        } else{
            return runBinarySearchRecursively(arr, key, middle+1, high);
=======

        if (key == arr.get(middle)) { //Check if the middle key is the search key
            return middle;
        } else if (key < arr.get(middle)) { //Check if the key is in the left side of the array
            //Recurse call this function with the left side of the array
            return runBinarySearchRecursively(arr, key, low, middle - 1);
        } else { //Key is in the right side of the array
            //Recurse call this function with the right side of the array
            return runBinarySearchRecursively(arr, key, middle + 1, high);
>>>>>>> 7076e6d6e03a9c860a480b6c056d127f5eef3018
        }
    }

    // public static int runBinarySearchIteratively(ArrayList<Integer> arr, int key, int low, int high) {
    //     int index = Integer.MAX_VALUE;

    //     while (low <= high) {
    //         int mid = (low + high) / 2;
    //         if (arr.get(mid) < key) {
    //             low = mid + 1;
    //         } else if (arr.get(mid) > key) {
    //             high = mid - 1;
    //         } else if (arr.get(mid) == key) {
    //             index = mid;
    //             break;
    //         }
    //     }
    //     return index;
    // }

    public static void main(String[] args) {
<<<<<<< HEAD
    	ArrayList<Integer> temp = CSVreader.readCSV("C:/Users/frank/workspace/ADEindopdracht/src/legosets.csv");
    	ArrayList<Object> test = QuickSort.quickSort(temp);
    	for(int i = 0; i < test.size(); i++) {
    		System.out.println(test.get(i));
    	}
    	System.out.println(binarySearch(test, (int) 10243));
    	System.out.println(test.get(5988));
    	
=======
        //Read CSV file
        ArrayList<Integer> temp = CSVreader.readCSV("C:/Users/frank/workspace/ADEindopdracht/src/legosets.csv");
        System.out.println(binarySearch(temp, (int) 6368));

>>>>>>> 7076e6d6e03a9c860a480b6c056d127f5eef3018
    }
}
