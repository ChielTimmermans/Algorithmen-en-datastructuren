import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class InsertionSort {
    public static <T extends Collection> T insertionSort(Collection<?> col) {
        Object temp;
        Object[] arr = col.toArray();
        
        Comparator<Object> com = (o1, o2) -> {
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
        };
        
        for(int i = 1; i<arr.length; i++) {
            temp = arr[i];
            while((i-1 >= 0) && (com.compare(temp, arr[i-1]) < 0)) {
                arr[i] = arr[i-1];
                i--;
            }
            arr[i] = temp;
        }
        return (T) new ArrayList<Object>(Arrays.asList(arr));
    }
}