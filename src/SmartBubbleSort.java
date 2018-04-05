import java.util.ArrayList;
import java.util.Collections;

public class SmartBubbleSort {
    public static ArrayList<Integer> smartBubbleSort(ArrayList<Integer> arr){
        int n = arr.size();

        boolean swapped = false;
        for (int i=0; i < n; i++)
        {
            for (int j=1; j<(n-i); j++)
            {
                if (arr.get(j-1) > arr.get(j)){
                    Collections.swap(arr, j-1, j);
                    swapped = true;
                }
            }
            if(!swapped) {
                return arr;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        ArrayList<Integer> temp = CSVreader.readCSV("C:/Users/frank/Google Drive/AD - Eindopdracht/legosets.csv");
        temp = smartBubbleSort(temp);
        for(int i = 0; i < temp.size(); i++) {
            System.out.println(temp.get(i));
        }
    }
}
