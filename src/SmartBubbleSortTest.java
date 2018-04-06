import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test class StackTest.
 *
 * @author  Michael van Dijk, Henk van Maanen, Frank Tieck, Chiel Timmermans
 * @version 05042018
 */
class SmartBubbleSortTest {

    /**
     * benodigde variabelen voor de test class
     * @param list = een stack gemaakt om de test over uit te voeren
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

    @Test
    /**
     * Deze test kijkt of de functie smartBubbleSort goed functioneerd.
     * Eerst wordt de list geso
     *
     */
    void smartBubbleSort() {
        list = SmartBubbleSort.smartBubbleSort(list);
        assertTrue(isSorted(list));

        list = SmartBubbleSort.smartBubbleSort(list);
        assertTrue(isSorted(list));
    }

    public boolean isSorted(ArrayList<Integer> list)
    {
        boolean sorted = true;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i-1).compareTo(list.get(i)) > 0) sorted = false;
        }

        return sorted;
    }
}