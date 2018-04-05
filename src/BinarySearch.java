import java.util.ArrayList;

public class BinarySearch {

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

        if (key == arr.get(middle)) { //Check if the middle key is the search key
            return middle;
        } else if (key < arr.get(middle)) { //Check if the key is in the left side of the array
            //Recurse call this function with the left side of the array
            return runBinarySearchRecursively(arr, key, low, middle - 1);
        } else { //Key is in the right side of the array
            //Recurse call this function with the right side of the array
            return runBinarySearchRecursively(arr, key, middle + 1, high);
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
        //Read CSV file
        ArrayList<Integer> temp = CSVreader.readCSV("C:/Users/frank/workspace/ADEindopdracht/src/legosets.csv");
        System.out.println(binarySearch(temp, (int) 6368));

    }
}
