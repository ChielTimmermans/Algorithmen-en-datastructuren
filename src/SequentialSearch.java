import java.util.ArrayList;
import java.util.Collection;

/**
 * Dit is de SequentialSearch class,
 * deze class is gebaseerd op het Last in First out principe
 * When a stack is first created, it contains no items.
 *
 * @author  Michael van Dijk, Henk van Maanen, Frank Tieck, Chiel Timmermans
 * @version 05042018
 */

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
