import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

/**
 * Dit is de insertion sort class
 * 
 * Werking Algorithme:
 * Het begint aan het begin van de lijst bij het tweede object.
 * het vergelijkt het tweede object met het eerste object en controleerd 
 * of het object op de juiste plaats staat of naar voren moet worden geschoven.
 * Dan pakt het het derde object en vergelijkt die met de vorige
 * tot dat de vorige kleiner is dan het derde object en het derde object
 * dus op de goede plek staat. 
 * Dit process blijft zich herhalen totdat de hele lijst is gesorteerd.
 * 
 * @author  Michael van Dijk, Henk van Maanen, Frank Tieck, Chiel Timmermans
 * @version 05042018
 */
public class InsertionSort {
	
	/**
	 * methode die een insertionsort aanroept op een collectie
	 * @param 	arr		De collectie die moet worden gesorteerd
	 * @return 			Een gesorteerde collectie
	 */
	public static <E, T extends Collection<E>> T insertionSort(Collection<E> arr) {
		return (T) new ArrayList<>(Arrays.asList(insertionSort(arr.toArray())));
	}
	
	/**
	 * methode die een insertionsort uitvoert op een array
	 * @param 	arr 	De array die moet worden gesorteerd
	 * @return			Een gesorteerde array
	 */
    private static <T> T[] insertionSort(T[] arr) {
    	//het object dat op de juiste plek wordt gezet
        T temp;
        
        //hier wordt de Comparator gezet,
        //dit wordt gedaan op basis van de datatype van de items in de objecttype
        Comparator<T> com = (o1, o2) -> {
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
        };
        
        //Een loop die alle objecten in de array een keer bij langs gaat
        for(int i = 1; i<arr.length; i++) {
        	//het huidige object wordt tijdelijk opgeslagen
            temp = arr[i];
            //Tot dat de juiste plek is gevonden worden alle object die groter zijn dan het huidige object een plek opgeschoven.
            while((i-1 >= 0) && (com.compare(temp, arr[i-1]) < 0)) {
                arr[i] = arr[i-1];
                i--;
            }
          //Als de plek gevonden is wordt het object daat geplaatst
            arr[i] = temp;
        }
        
        //de gesorteerde array wordt terug gevonden
        return arr;
    }
}