import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 * Dit is de SmartBubbleSort class,
 * dit sorting algorithm is gebaseerd op BubbleSort,
 * Het verschil alleen is dat dit algorithm eerst checkt of het willekeurige object type al gesorteerd is,
 * voordat hij daadwerkelijk begint met het sorten van het object.
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
 * In de eerste iteration wordt er ook gekeken of het algorithm al gesorteerd is.
 * Zo ja dan returned hij het object meteen
 *
 * @author  Michael van Dijk, Henk van Maanen, Frank Tieck, Chiel Timmermans
 * @version 05042018
 */
public class SmartBubbleSort{

    public static <T extends Collection> T smartBubbleSort(Collection<?> col){
        //lengte van Willekeurige Object type
        int n = col.size();
        //willekeurige Object wordt omgezet naar een Array;
        Object[] arr = col.toArray();

        //hier wordt de COmparator gezet,
        //dit wordt gedaan op basis van de datatype van de items in de objecttype
        Comparator<Object> com = (o1, o2) -> {
            /**
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

        // Met deze boolean kan gekeken worden of er een swap heeft plaats gevonden
        // en dus controleren of het algorithem al gesort is.

        boolean swapped;
        // Dit is de geneste loop waar het algorithm door heen loopt om het object te sorteren
        // in de binneste loop kun je zien dat na elke iteration er 1 minder item wordt gecheckt.
        for (int i=0; i < n; i++)
        {
            // Na elke iteration wordt de boolean swapped weer op false gezet zodat deze iteration opnieuw gecheckt kan worden of hij al op volgorde is
            swapped = false;

        	for (int j=1; j<(n-i); j++)
            {
                // hier wordt de compare functie toegepast die hierboven staat uitgelegd
                if (com.compare(arr[j-1], arr[j]) > 0){

                    // hier vindt de swap plaats als item o1 groter is dan o2
                	Object temp = arr[j-1]; 
                	arr[j-1] = arr[j];
                	arr[j] = temp;

                	// als item o1 groter is dan o2 dan vindt er een swap plaats,
                    // Doordat deze boolean nu op true wordt gezet kan er later gekeken worden of het algortihm al gesort is.
                	swapped = true;
                }
            }
            // als er geen swap heeft plaatst gevonden, ofwel swapped = false,
            // dan betekend dat het object al gesort is en kan deze dus gereturned worden
            if(!swapped) {
            	return (T) new ArrayList<Object>(Arrays.asList(arr));
            }


        }
        //Als het object gesort is dan wordt hij gereturned als een ArrayList.
        return (T) new ArrayList<Object>(Arrays.asList(arr));
    }
}
