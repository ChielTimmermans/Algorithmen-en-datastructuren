import java.util.ArrayList;

public class InsertionSort {
    public static ArrayList<Integer> insertionSort(ArrayList<Integer> arr) {
        int temp;
        for(int i = 1; i<arr.size(); i++) {
            temp = arr.get(i);
            while((i-1 >= 0) && (temp < arr.get(i-1))) {
                arr.set(i, arr.get(i-1));
                i--;
            }
            arr.set(i, temp);
        }
        return arr;
    }
}
