import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 * Dit is de SmartBubbleSort class,
 * dit sorting algorithm is gebaseerd op BubbleSort,
 * Het verschil alleen is dat dit algorithm eerst checkt of het willekeurige object type al gesorteerd is,
 * voordat hij daadwerkelijk het object gaat swappen
 */
public class SmartBubbleSort{

    public static <T extends Collection> T smartBubbleSort(Collection<?> col){
        int n = col.size();
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

        boolean swapped = false;
        for (int i=0; i < n; i++)
        {
        	for (int j=1; j<(n-i); j++)
            {
                if (com.compare(arr[j-1], arr[j]) > 0){
                	Object temp = arr[j-1]; 
                	arr[j-1] = arr[j];
                	arr[j] = temp;
                	swapped = true;
                }
            }
            if(!swapped) {
            	return (T) new ArrayList<Object>(Arrays.asList(arr));
            }
        }

        return (T) new ArrayList<Object>(Arrays.asList(arr));
    }
    
    public static void main(String[] args) {
    	String path = "src/legosets.csv";
    	ArrayList<Integer> list = CSVreader.readCSV(path);
    	list = smartBubbleSort(list);
    	for(int i = 0; i<list.size();i++) {
    		System.out.println(list.get(i));
    	}
    	
    }


}
