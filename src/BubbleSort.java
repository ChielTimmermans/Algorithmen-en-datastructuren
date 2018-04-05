import java.util.ArrayList;
import java.util.Collections;

public class BubbleSort {
    public static ArrayList<Integer> bubbleSort(ArrayList<Integer> arr){
        int n = arr.size();
        
        for (int i=0; i < n; i++)
        {
            for (int j=1; j<(n-i); j++)
            {
                if (arr.get(j-1) > arr.get(j)){
                	Collections.swap(arr, j-1, j);
                }
            }
        }
        
        return arr;
    }
    
    public static void main(String[] args) {
    	ArrayList<Integer> temp = CSVreader.readCSV("C:/Users/frank/workspace/ADEindopdracht/src/legosets.csv");
    	temp = bubbleSort(temp);
    	for(int i = 0; i < temp.size(); i++) {
    		System.out.println(temp.get(i));
    	}
    }
}
