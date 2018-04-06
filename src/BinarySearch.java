import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

/**
 * Dit is de BinarySearch class.
 * Deze class bevat functies die controleren of een object voor komt in en collectie,
 * en als dit object voorkomt teruggeeft op welke plek het staat.
 * 
 * Werking Agorithme:
 * Het pakt het middenste object in de collectie,
 * en controleerd dan of het object dat je groter of kleiner is dan dat object 
 * of dat de middelste dat object is.
 * Dit blijft zich herhalen totdat het object is gevonden
 * of als er geen middelste element meer is, in dit geval zit het object niet in de collectie.
 * 
 * @author Michael van Dijk, Henk van Maanen, Frank Tieck, Chiel Timmermans
 * @version 05042018
 *
 */
public class BinarySearch {
	
	/**
	 * Deze methode krijgt een collectie en een willekeurig object.
	 * Dan maakt hij een call naar de recursieve methode runBinarySearchRecursively.
	 * Die methode krijgt de collectie als array en het te vinden object mee.
	 * Ook krijgt hij de parameters mee van welk gedeelte nog gecontroleerd moet worden,
	 * De eerste keer is dit de gehele lijst, dus van 0 to de lengte van de collectie. 
	 * 
	 * @param 	arr	 	De collectie waarin gezocht moet worden
	 * @param 	key 	Het te vinden object
	 * @return 	int     0 of hoger. Het item is gevonden en de return is de index van dat item.
     *          int     -1. Het item is niet gevonden.	
	 */
	public static <T extends Object> int binarySearch(Collection<?> arr, T key) {
		return runBinarySearchIteratively(arr.toArray(), key);
	}
	
	/**
	 * Deze methode krijgt een array en een willekeurig object.
	 * Dan maakt hij een call naar de recursieve methode runBinarySearchRecursively.
	 * Die methode krijgt de array en het te vinden object mee.
	 * Ook krijgt hij de parameters mee van welk gedeelte nog gecontroleerd moet worden,
	 * De eerste keer is dit de gehele lijst, dus van 0 to de lengte van de collectie. 
	 * 
	 * @param 	arr	 	De array waarin gezocht moet worden
	 * @param 	key 	Het te vinden object
	 * @return 	int     0 of hoger. Het item is gevonden en de return is de index van dat item.
     *          int     -1. Het item is niet gevonden.	
	 */
	public static <T extends Object> int binarySearch(T[] arr, T key) {
		return runBinarySearchIteratively(arr, key);
	}
	
	/**
	 * Deze methode krijgt een array en een willekeurig object en twee indexen waartussen hij moet zoeken.
	 * Dit object moet het vinden in de array. 
	 * Het controlleerd eerst of de array is gesorteerd, zo niet sorteerd hij de array.
	 * Dan zoekt hij het middelste object.
	 * Vergelijkt dat object met de key. 
	 * Als de middelste de key is returned het die.
	 * Als de key groter is als de middelste maakt het een call naar zichzelf met als laagste index de index onder de middelste.
	 * Als de key kleiner is als de middelste maakt het een call naar zichzelf met als hoogste index de index boven de middelste.
	 * Als het element niet in de lijst zit returned het -1; 
	 * 
	 * @param 	arr		De array waarin gezocht moet worden
	 * @param 	key		Het te vinden object
	 * @param 	low		De laagste index waar de key zich nog kan bevinden
	 * @param 	high	De hoogste index waar de key zich nog kan bevinden
	 * @return	int     0 of hoger. Het item is gevonden en de return is de index van dat item.
     *          int     -1. Het item is niet gevonden.
	 */
    public static <T extends Object> int runBinarySearchRecursively(T[] arr, T key, int low, int high){
    	//controleerd of de array gesorteerd is zo niet sorteerd het de array
    	if(!isSorted(arr)) {
    		arr = QuickSort.quickSort(arr);
    	}
    	
    	//De index van het middelste object
        int middle = (low + high)/2;

        //Als de laagste index hoger is dan de hoogste index zit het object niet in de array en returned de methode -1
        if (high < low) {
            return -1;
        }
        
        //hier wordt de COmparator gezet,
        //dit wordt gedaan op basis van de datatype van de items in de objecttype
        Comparator<T> com =new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
            /*
             * checkt of o1 en o2 integers zijn,
             * als dit waar is dan returned hij de vergelijking tussen o1 en o2
             * de compareTo() functie returned -1, 0 of 1.
             * -1 als o1 kleiner is dan o2
             * 0 als o1 gelijk staat aan o2
             * 1 als o1 groter is dan o2
             *
             * Dit geld ook voor de tweede en derde else statement.
             * Alleen wordt bij de tweede gecheckt of de items Strings zijn,
             * zo ja dan wordt het op alfabetische volgorde gesort.
             *
             * Bij de derde statement wordt alles gezet wat geen Integer of String is
             * Hier wordt dan de toString functie over aangeroepen, dit wordt daarna vergeleken met elkaar
             * Er is voor deze methode gekozen omdat het algorithm generic is en daarom op elke datatype moet werken.
             * Daarnaast is hij ook makkelijk uitbreidbaar als je je eigen compare functie wil toevoegen
             */
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
            }
        };
        
        //Als de key gelijk is aan het middelste object returned het de middelste index
        if (key.equals(arr[middle])){
            return middle;
        } 
        //Als de key kleiner is dan het middelste object wordt de methode opnieuw gecontroleerd met dezelfde laagste index
        //en als grootste index de index onder de middelste.
        else if (com.compare(key, arr[middle]) < 0){
            return runBinarySearchRecursively(arr, key, low, middle-1);
        }
        //Als de key groter is dan het middelste object wordt de methode opnieuw gecontroleerd met dezelfde hoogste index
        //en als laagste index de index boven de middelste.
        else{
            return runBinarySearchRecursively(arr, key, middle+1, high);
        }
    }

    /**
     * Deze methode krijgt een array en een willekeurig object.
	 * Dit object moet het vinden in de array. 
	 * Het controlleerd eerst of de array is gesorteerd, zo niet sorteerd hij de array.
	 * Dan gaat het opzoek naar het object tussen de high en low.
	 * Dan zoekt het het middelste object, en controleerd of dit object gelijk is aan de key.
	 * Indien dit gelijk is returned het de index van het middelste object.
	 * Als de key groter is dan de middelste zet het de low naar de middelste index +1.
	 * Als de key kleiner is dan de middelste zet het de high naar de middelste index -1.
	 * Als de key niet wordt gevonden returned het -1.
	 * 
     * @param 	arr		De array waarin gezocht moet worden
	 * @param 	key		Het te vinden object
     * @return	int     0 of hoger. Het item is gevonden en de return is de index van dat item.
     *          int     -1. Het item is niet gevonden.
     */
    public static <T extends Object> int runBinarySearchIteratively(T[] arr, T key){
    	//controleerd of de array gesorteerd is zo niet sorteerd het de array
    	if(!isSorted(arr)) {
    		arr = QuickSort.quickSort(arr);
    	}
    	
    	//De laagste index, de hoogste index worden voor de eerste keer gezet.
    	//De eerste keer moet alles nog worden gecontrolleerd en dus is de laagste index 0 en de hoogste index de lengte van de array
    	int low = 0;
    	int high = arr.length-1;
    	//De index die wordt gereturned wordt gezet op -1. Als de key niet wordt gevonden wordt deze niet veranderd.
        int index = -1;
        
        //hier wordt de COmparator gezet,
        //dit wordt gedaan op basis van de datatype van de items in de objecttype
        Comparator<T> com =new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
            /*
             * checkt of o1 en o2 integers zijn,
             * als dit waar is dan returned hij de vergelijking tussen o1 en o2
             * de compareTo() functie returned -1, 0 of 1.
             * -1 als o1 kleiner is dan o2
             * 0 als o1 gelijk staat aan o2
             * 1 als o1 groter is dan o2
             *
             * Dit geld ook voor de tweede en derde else statement.
             * Alleen wordt bij de tweede gecheckt of de items Strings zijn,
             * zo ja dan wordt het op alfabetische volgorde gesort.
             *
             * Bij de derde statement wordt alles gezet wat geen Integer of String is
             * Hier wordt dan de toString functie over aangeroepen, dit wordt daarna vergeleken met elkaar
             * Er is voor deze methode gekozen omdat het algorithm generic is en daarom op elke datatype moet werken.
             * Daarnaast is hij ook makkelijk uitbreidbaar als je je eigen compare functie wil toevoegen
             */
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
            }
        };
        
        //Een loop die doorloopt totdat de hoogste index lager is dan de laagste index wat aangeeft dat het object niet gevonden is
        while(low <= high){
        	//Het middelste index wordt iedere loop weer gezet
            int mid = (low + high)/2;
            //Als de middelste kleiner is dan de key wordt de laagste index gezet op de middelste+1
            if (com.compare(arr[mid], key) <0){
                low = mid+1;
            } 
            //Als de middelste groter is dan de key wordt de hoogste index gezet op de middelste-1
            else if (com.compare(arr[mid], key) > 0){
                high = mid-1;
            }
            //Als de middelste de key is wordt de index gezet op die van de middelste en wordt de loop gestopt
            else if (com.compare(arr[mid], key) == 0){
                index = mid;
                break;
            }
        }
        //Het returned de index dat op dit moment de index van de key is of -1
        return index;
    }
    
    /**
     * Deze functie checked of een array gesorteerd.
     * 
     * @param 	arr		De array die gecontroleerd moet worden.
     * @return	boolean	True als de array gesorteerd is en False als de array niet gesorteerd is.	
     */
    public static <T extends Object> boolean isSorted(T[] arr)
    {
    	//hier wordt de COmparator gezet,
        //dit wordt gedaan op basis van de datatype van de items in de objecttype
        Comparator<T> com =new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
            /*
             * checkt of o1 en o2 integers zijn,
             * als dit waar is dan returned hij de vergelijking tussen o1 en o2
             * de compareTo() functie returned -1, 0 of 1.
             * -1 als o1 kleiner is dan o2
             * 0 als o1 gelijk staat aan o2
             * 1 als o1 groter is dan o2
             *
             * Dit geld ook voor de tweede en derde else statement.
             * Alleen wordt bij de tweede gecheckt of de items Strings zijn,
             * zo ja dan wordt het op alfabetische volgorde gesort.
             *
             * Bij de derde statement wordt alles gezet wat geen Integer of String is
             * Hier wordt dan de toString functie over aangeroepen, dit wordt daarna vergeleken met elkaar
             * Er is voor deze methode gekozen omdat het algorithm generic is en daarom op elke datatype moet werken.
             * Daarnaast is hij ook makkelijk uitbreidbaar als je je eigen compare functie wil toevoegen
             */
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
            }
        };
        
        //Een for loop één keer over de hele array loopt 
        for (int i = 1; i < arr.length; i++) {
        	//als het één keer voor komt dat het vorige object groter is dan het huidige object
        	//is de lijst niet gesorteerd en returned de methode false
            if (com.compare(arr[i-1], arr[i]) > 0) return false;
        }
        //als de loop volledig door de array is gegaan is de array gesorteerd en wordt true gereturned
        return true;
    }
}

