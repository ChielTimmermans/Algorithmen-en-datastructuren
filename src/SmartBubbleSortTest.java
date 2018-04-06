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
     * Eerst wordt getest of de lijst gesort is, door middel van de isSorted functie, dit is niet waar en zal daarom false returnen.
     * Daarna wordt de list gesorteerd en wordt de isSorted functie aangeroepen, deze zal true moeten returnen als de lisjt gesort is.
     *
     * Daarna wordt dezelfde lijst nog een keer gesort,
     * dit gebeurt om te kijken of het algorithm daadwerkelijk checkt of de lijst al gesorteerd is en dus sneller klaar is.
     */
    void smartBubbleSort() {
        assertFalse(isSorted(list));

        list = SmartBubbleSort.smartBubbleSort(list);
        assertTrue(isSorted(list));

        list = SmartBubbleSort.smartBubbleSort(list);
        assertTrue(isSorted(list));
    }

    /**
     * Deze functie checkt of een ArrayList gesort is,
     * De boolean sorted word false gezet op het moment dat 2 items niet op volgorde zijn
     *
     *
     * @param list
     * @return boolean return true als het object gesort is.
     */
    public boolean isSorted(ArrayList<Integer> list)
    {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i-1).compareTo(list.get(i)) > 0) return false;
        }

        return true;
    }
}