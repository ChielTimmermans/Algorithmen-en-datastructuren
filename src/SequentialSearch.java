import java.util.Collection;

/**
 * Dit is de SequentialSearch class,
 * Deze class controleert of een object voor komt in een collectie
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
     * @param col collection wat gecheckt moet worden of het object er in zit
     * @param key het desbetrevende object
     * @return  true als het item in de list bestaat,
     *          false als het item niet in de list bestaat
     */
    public static boolean sequentialSearch(Collection<?> col, Object key){
    	Object[] arr = col.toArray();
        for(Object object: arr){
            if(object.equals(key)) return true;
        }
        return false;
    }
}
