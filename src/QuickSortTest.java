import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test class QuickSortTest.
 *
 * @author  Michael van Dijk, Henk van Maanen, Frank Tieck, Chiel Timmermans
 * @version 05042018
 */

class QuickSortTest {


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
     * Deze test kijkt of de functie QuickSortTest goed functioneerd.
     *
     * Eerst wordt de ongesorteerde list gecheckt of hij gesorteerd is. Dit moet False returnen
     * Daarna wordt de list gesorteerd met het quicksort algorithm
     * Tot slot wordt gecheckt of de list nu wel gesorteerd is. Dit moet True returnen.
     *
     */
    @Test
    void quickSort() {
        assertFalse(isSorted(list));

        list = QuickSort.quickSort(list);
        assertTrue(isSorted(list));
    }

    /**
     * Deze functie checkt of een ArrayList gesort is,
     * De boolean sorted word false gezet op het moment dat 2 items niet op volgorde zijn
     *
     *
     * @param list is een Arraylist die gesort moet worden
     * @return boolean return true als het object gesort is.
     */
    private boolean isSorted(ArrayList<Integer> list)
    {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i-1).compareTo(list.get(i)) > 0) return false;
        }

        return true;
    }
}