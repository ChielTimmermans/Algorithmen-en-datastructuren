import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

/**
 * Dit is de QuickSort class,
 *
 * Werking Algorithm:
 * Er wordt een willekeurig element in de rij gekozen, de spil.
 * De rij wordt zo gesorteerd zodat alles wat kleiner is links van de spil staat,
 * en alles wat groter is dan de spil links van de spil staat. Dit wordt partitioneren genoemd.
 * Hierna wordt op dezelfde manier links en rechts gesorteerd, dit wordt netzolang herhaalt totdat de reeks gesorteerd is
 *
 *
 * @author  Michael van Dijk, Henk van Maanen, Frank Tieck, Chiel Timmermans
 * @version 05042018
 */

public class QuickSort {
	
	public static <T extends Collection> T quickSort(Collection<?> arr) {
		Object[] temp = sort(arr.toArray(), 0, arr.size()-1);
		return (T) new ArrayList<>(Arrays.asList(temp));
	}
	
	private static Object[] sort(Object[] arr, int links, int rechts) {
		int l = links;
		int r = rechts;
		Object midden = arr[(links+rechts)/2];

        //hier wordt de Comparator gezet,
        //dit wordt gedaan op basis van de datatype van de items in de objecttype
		Comparator<Object> com = (o1, o2) -> {
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
        
		while(l<=r) {
			
			while(com.compare(arr[l], midden) < 0) {
				l++;
			}
			while(com.compare(midden, arr[r]) < 0) {
				r--;
			}
			
			if(l<=r) {
				Object temp = arr[l];
				arr[l] = arr[r];
				arr[r] = temp;
				l++;
				r--;
			}
		}
		
		if(links < r) {
			arr = sort(arr, links, r);
		}
		if(l<rechts) {
			arr = sort(arr, l, rechts);
		}
		return arr;
	}
}
