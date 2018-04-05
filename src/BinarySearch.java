import java.util.ArrayList;

public class BinarySearch {
    public int runBinarySearchRecursively(ArrayList<Integer> arr, int key, int low, int high){
        int middle = (low + high)/2;

        if (high < low) {
            return -1;
        }

        if (key == arr.get(middle)){
            return middle;
        } else if (key < arr.get(middle)){
            return runBinarySearchRecursively(arr, key, low, middle-1);
        } else{
            return runBinarySearchRecursively(arr, key, middle+1, high);
        }
    }

    public int runBinarySearchIteratively(ArrayList<Integer> arr, int key, int low, int high){
        int index = Integer.MAX_VALUE;

        while(low <= high){
            int mid = (low + high)/2;
            if (arr.get(mid) < key){
                low = mid+1;
            } else if (arr.get(mid) > key){
                high = mid-1;
            }else if (arr.get(mid) == key){
                index = mid;
                break;
            }
        }
        return index;
    }
}
