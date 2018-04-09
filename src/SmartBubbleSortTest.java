import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test class SmartBubbleSortTest.
 *
 * @author  Michael van Dijk, Henk van Maanen, Frank Tieck, Chiel Timmermans
 * @version 05042018
 */
class SmartBubbleSortTest {

    /**
     * benodigde variabelen voor de test class
     * @param list = een ArrayList<Integer> gemaakt om de test over uit te voeren
     * @param path = een string met de path naar de csv, of wel onze dataset
     */
    protected ArrayList<Integer> list;
    protected String path;

    /**
     * De setup wordt elke keer uitgevoerd voordat een testfunctie wordt aangeroepen
     * de CSVreader.readCSV returned een Arraylist<Integer>,
     * deze arraylist wordt de nieuwe list.
     */
    @BeforeEach
    void setUp() {
        path = "src/legosets.csv";

        list = CSVreader.readCSV(path);
    }

    /**
    * Deze test kijkt of de functie smartBubbleSort goed functioneert voor een list met integers.
    * Eerst wordt getest of de lijst gesort is, door middel van de isSorted functie, dit is niet waar en zal daarom false returnen.
    * Daarna wordt de list gesorteerd en wordt de isSorted functie aangeroepen, deze zal true moeten returnen als de lijt gesort is.
    *
    * Daarna wordt dezelfde lijst nog een keer gesort,
    * dit gebeurt om te kijken of het algorithm daadwerkelijk checkt of de lijst al gesorteerd is en dus sneller klaar is.
     */
    @Test
    void smartBubbleSortInt() {
        assertFalse(isSorted(list.toArray()));

        list = SmartBubbleSort.smartBubbleSort(list);
        assertTrue(isSorted(list.toArray()));

        list = SmartBubbleSort.smartBubbleSort(list);
        assertTrue(isSorted(list.toArray()));
    }
    
    /**
     * Deze test kijkt of de functie smartBubbleSort goed functioneert voor een list met string.
     * Eerst wordt getest of de lijst gesort is, door middel van de isSorted functie, dit is niet waar en zal daarom false returnen.
     * Daarna wordt de list gesorteerd en wordt de isSorted functie aangeroepen, deze zal true moeten returnen als de lijst gesort is.
     *
     * Daarna wordt dezelfde lijst nog een keer gesort,
     * dit gebeurt om te kijken of het algorithm daadwerkelijk checkt of de lijst al gesorteerd is en dus sneller klaar is.
      */
    @Test
    void smartBubbleSortString() {
    	ArrayList<String> s = new ArrayList<String>();
    	s.add("test1");
    	s.add("test3");
    	s.add("test2");
    	
        assertFalse(isSorted(s.toArray()));

        s = SmartBubbleSort.smartBubbleSort(s);
        assertTrue(isSorted(s.toArray()));

        s = SmartBubbleSort.smartBubbleSort(s);
        assertTrue(isSorted(s.toArray()));
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