import java.util.ArrayList;
import java.util.Collection;

public class SequentialSearch {
    public static boolean sequentialSearch(Collection<?> col, Object key){
    	Object[] arr = col.toArray();
        for (int i = 0; i < arr.length; i++){
            if (arr[i].equals(key)){
                return true;
            }
        }
        return false;
    }
}
