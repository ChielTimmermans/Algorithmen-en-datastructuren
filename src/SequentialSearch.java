import java.util.ArrayList;

public class SequentialSearch {
    public static boolean contains(ArrayList<Integer> a, Integer b){
        for (int i : a){
            if (i==b){
                return true;
            }
        }
        return false;
    }
}
