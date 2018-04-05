import java.util.ArrayList;

public class QuickSort {
	
	public static ArrayList<Integer> quickSort(ArrayList<Integer> arr) {
		return sort(arr, 0, arr.size()-1);
	}
	
	private static ArrayList<Integer> sort(ArrayList<Integer> arr, int links, int rechts) {
		int l = links;
		int r = rechts;
		int midden = arr.get((links+rechts)/2);
		
		while(l<=r) {
			
			while(arr.get(l)<midden) {
				l++;
			}
			while(midden < arr.get(r)) {
				r--;
			}
			
			if(l<=r) {
				int temp = arr.get(l);
				arr.set(l, arr.get(r));
				arr.set(r, temp);
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
		ArrayList<Integer> temp = CSVreader.readCSV("C:/Users/frank/Google Drive/AD - Eindopdracht/legosets.csv");
    	temp = quickSort(temp);
    	for(int i = 0; i < temp.size(); i++) {
    		System.out.println(temp.get(i));
    	}

	}

}
