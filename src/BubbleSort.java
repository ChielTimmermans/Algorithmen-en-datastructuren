import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 * Dit is de BubbleSort class,
 *
 * Werking Algorithme:
 * Start bij het begin van de lijst,
 * vergelijk nummer 1 en 2,
 * Als deze niet op volgorde zijn worden ze omgedraait,
 * Daarna verglijkt hij nummer 2 en 3.
 * enz. Totdat hij aan het eind van de lijst is.
 * Daarna begint hij weer helemaal van voren,
 * na elke iteration hoeft er 1 element minder te worden vergeleken.
 *
 * @author  Michael van Dijk, Henk van Maanen, Frank Tieck, Chiel Timmermans
 * @version 05042018
 */

public class BubbleSort {
	
	/**
	 * methode die een smart bubblesort aanroept op een collectie
	 * @param 	arr		De collectie die moet worden gesorteerd
	 * @return 			Een gesorteerde collectie
	 */
	public static <E extends Object, T extends Collection<E>> T bubbleSort(Collection<E> arr) {
		return (T) new ArrayList<Object>(Arrays.asList(bubbleSort(arr.toArray())));
	}
	
	/**
	 * methode die een smart Bubblesort uitvoert op een array
	 * @param 	arr 	De array die moet worden gesorteerd
	 * @return			Een gesorteerde array
	 */
    public static <T extends Object> T[] bubbleSort(T[] arr){
    	 //lengte van Willekeurige Object type
        int n = arr.length;
        
        //hier wordt de Comparator gezet,
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
        
        // Dit is de geneste loop waar het algorithm door heen loopt om het object te sorteren
        // in de binneste loop kun je zien dat na elke iteration er 1 minder item wordt gecheckt.
        for (int i=0; i < n; i++)
        {
            for (int j=1; j<(n-i); j++)
            {
            	// hier wordt de compare functie toegepast die hierboven staat uitgelegd
                if (com.compare(arr[j-1], arr[j]) > 0){
                	 // hier vindt de swap plaats als item o1 groter is dan o2
                	T temp = arr[j-1]; 
                	arr[j-1] = arr[j];
                	arr[j] = temp;
                }
            }
        }
        
      //Als het object gesort is dan wordt hij gereturned als een ArrayList.
        return arr;
    }    
    
}
