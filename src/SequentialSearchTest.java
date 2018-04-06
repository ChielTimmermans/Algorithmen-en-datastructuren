import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test class SequentialSearchTest.
 *
 * @author  Michael van Dijk, Henk van Maanen, Frank Tieck, Chiel Timmermans
 * @version 05042018
 */
class SequentialSearchTest {


    /**
     * benodigde variabelen voor de test class
     * @param list = een ArrayList<Integer> gemaakt om de test over uit te voeren
     * @param path = een string met de path naar de csv, of wel onze dataset
     */
    protected ArrayList<Integer> list;
    protected String path;

    /**
     * De setup wordt elke keer uitgevoerd voordat een testfunctie wordt aangeroepen
     * In deze setup wordt de data set opgehaald en wordt in de list gezet
     */
    @BeforeEach
    void setUp() {
        path = "src/legosets.csv";

        list = CSVreader.readCSV(path);
    }

    /**
     * Deze test kijkt of de functie contains goed functioneerd.
     * Eerst wordt een object gezocht die in de dataset zit, dit zal de index moeten returnen, wat 0 is.
     * Daarna wordt een object gezocht die ook in de dataset zit, dit zal de index returnen, maar zal niet gelijk zijn aangezien de index anders is.
     * Tot slot wordt een object gezocht die niet in bestaat. Dit zal -1 returnen.
     */
    @Test
    void sequentialSearch() {
        assertEquals(0, SequentialSearch.sequentialSearch(list, 10246));
        assertNotEquals(0, SequentialSearch.sequentialSearch(list, 10243));
        assertEquals(-1, SequentialSearch.sequentialSearch(list, "test"));
    }
}