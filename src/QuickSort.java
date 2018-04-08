import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

/**
 * Dit is de QuickSort class,
 *
 * Werking Algorithm:
 * Het pakt een willekeurig object (in ons geval de middelste).
 * En vergelijkt het object met alle andere objecten in de lijst zodat
 * uiteindelijk alle objecten kleiner dan het object links staan 
 * en alle objecten groten dan het object rechts.
 * En dan wordt het opnieuw uitgevoerd voor het linkse en het rechtse gedeelte 
 * tot dat de hele lijst gesorteerd is.
 *
 *
 * @author  Michael van Dijk, Henk van Maanen, Frank Tieck, Chiel Timmermans
 * @version 05042018
 */

public class QuickSort {
	
	/**
	 * methode die een quicksort aanroept op een collectie
	 * @param 	arr		De collectie die moet worden gesorteerd
	 * @return 			Een gesorteerde collectie
	 */
	public static <E extends Object, T extends Collection<E>> T quickSort(Collection<E> arr) {
		Object[] temp = sort(arr.toArray(), 0, arr.size()-1);
		return (T) new ArrayList<>(Arrays.asList(temp));
	}
	
	/**
	 * methode die een quicksort uitvoert op een array.
	 * Deze methode maakt een call naar de recursive methode sort
	 * @param 	arr 	De array die moet worden gesorteerd
	 * @return			Een gesorteerde array
	 */
	public static <T extends Object> T[] quickSort(T[] arr) {
		return sort(arr, 0, arr.length-1);		
	}
	
	/**
	 * methode die op een recursive manier een quicksort uitvoerd op een array.
	 * 
	 * @param arr 		De array die moet worden gesorteerd
	 * @param links		Het meest linkse object van het gedeelte van de array die moet worden gesorteerd
	 * @param rechts	Het meest rechtse object van het gedeelte van de array die moet worden gesorteerd
	 * @return			Een gesorteerde array
	 */
	private static <T extends Object> T[] sort(T[] arr, int links, int rechts) {
		//de index van het meest linkse en het meest rechtse object dat moet worden gesorteerd
		int l = links;
		int r = rechts;
		
		//De inhoud van het middenste object
		T midden = arr[(links+rechts)/2];

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
        
        //Een while loop dat alle objecten tussen links en rechts bij langs gaat
		while(l<=r) {
			
			//Een while loop dat een index zoekt van een object dat links van midden staat maar wel groter is
			while(com.compare(arr[l], midden) < 0) {
				l++;
			}
			//Een while loop dat een index zoekt van een object dat rechts van midden staat maar wel kleiner is
			while(com.compare(midden, arr[r]) < 0) {
				r--;
			}
			
			//als links nog links staat van rechts moeten de twee objecten op l en r worden gewisseld
			if(l<=r) {
				T temp = arr[l];
				arr[l] = arr[r];
				arr[r] = temp;
				l++;
				r--;
			}
		}
		
		//zolang de orginele links kleiner is dan de nieuwe rechts moet de sort opnieuw worden uitgevoerd voor de linker kant
		if(links < r) {
			arr = sort(arr, links, r);
		}
		//zolang de orginele rechts groter is dan de nieuwe links moet de sort opnieuw worden uitgevoerd voor de rechter kant
		if(l<rechts) {
			arr = sort(arr, l, rechts);
		}
		
		//een gesorteerde array word gereturned.
		return arr;
	}
}
