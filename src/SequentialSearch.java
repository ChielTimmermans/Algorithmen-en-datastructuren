import java.util.Collection;

/**
 * Dit is de SequentialSearch class,
 * Deze class controleert of een object voorkomt in een collectie
 *
 * @author  Michael van Dijk, Henk van Maanen, Frank Tieck, Chiel Timmermans
 * @version 05042018
 */

public class SequentialSearch {

    /**
     * De sequentialSearch krijgt een collectie binnen,
     * veranderd deze collectie naar een Object[] d.m.v. de toArray functie
     * Daarna wordt er over de collectie heen geloopt.
     * Op het moment dat het huidige obj gelijk staat aan de key dan wordt true gereturned
     *
     * @param   col     collection wat gecheckt moet worden of het object er in zit
     * @param   key     het desbetrevende object
     * @return  int     0 of hoger. Het item is gevonden en de return is de index van dat item.
     *          int     -1. Het item is niet gevonden.
     */
    public static int sequentialSearch(Collection<?> col, Object key){
    	Object[] arr = col.toArray();
        for (int i = 0; i < arr.length; i++){
            if (arr[i].equals(key)){
                return i;
            }
        }
        return -1;
    }
}
