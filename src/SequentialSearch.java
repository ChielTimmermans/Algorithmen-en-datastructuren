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
     * Wordt er een call gedaan naar sequentialSearch
     *
     * @param   arr     collection wat gecheckt moet worden of het object er in zit
     * @param   key     het desbetrevende object
     * @return  int     0 of hoger. Het item is gevonden en de return is de index van dat item.
     *          int     -1. Het item is niet gevonden.
     */
	public static int sequentialSearch(Collection<?> arr, Object key){
        return sequentialSearch(arr.toArray(), key);
    }
	
	/**
	 * Deze methode krijgt een array binnen en een object dat die moet zoeken.
	 * Dan loopt het over de array heen tot dat het object is gevonden.
	 * Als het object is gevonden returned het de index.
	 * Als het object niet wordt gevonden returned het -1
	 * 
	 * @param   arr     collection wat gecheckt moet worden of het object er in zit
     * @param   key     het desbetrevende object
     * @return  int     0 of hoger. Het item is gevonden en de return is de index van dat item.
     *          int     -1. Het item is niet gevonden.
	 */
    public static <T extends Object> int sequentialSearch(T[] arr, Object key){
        for (int i = 0; i < arr.length; i++){
            if (arr[i].equals(key)){
                return i;
            }
        }
        return -1;
    }
    
}
