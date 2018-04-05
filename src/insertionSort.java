import java.util.ArrayList;

public class insertionSort {
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

	
	public static void main(String[] args) {
		ArrayList<Integer> temp = CSVreader.readCSV("C:/Users/frank/Google Drive/AD - Eindopdracht/legosets.csv");
    	temp = insertionSort(temp);
    	for(int i = 0; i < temp.size(); i++) {
    		System.out.println(temp.get(i));
    	}

	}

}
