import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test class QueueTest.
 *
 * @author  Michael van Dijk, Henk van Maanen, Frank Tieck, Chiel Timmermans
 * @version 05042018
 */
class QueueTest {

    /**
     * benodigde variabelen voor de test class
     * @param list = een stack gemaakt om de test over uit te voeren
     * @param path = een string met de path naar de csv, of wel onze dataset
     */
    private Queue<Integer> queue;
    private String path;

    /**
     * De setup wordt elke keer uitgevoerd voordat een testfunctie wordt aangeroepen
     * In deze setup wordt de data set opgehaald en wordt het omgezet naar een Stack
     *
     */
    @BeforeEach
    void setUp() {
        path = "src/legosets.csv";

        ArrayList<Integer> temp = CSVreader.readCSV(path);

        queue = new Queue<>();
        queue.addAll(temp);
    }

    /**
     * Deze test kijkt of de functie add goed functioneerd.
     * Eerst wordt een item geadd aan de queue, als een item op de queue wordt geadd dan returned de stack true.
     **/
    @Test
    void add() {
        assertTrue(queue.add(4));
    }

    /**
     * Deze test kijkt of de functie element goed functioneerd.
     *
     * Eerst vraagt de queue een element op met de functie element(),
     * dit returned het oudste element, maar verwijderd het element niet.
     * Daarna wordt de functie element nog een keer gecalled om te bewijzen dat de item niet verwijderd wordt
     * Tot slot wordt de queue geleegd en wordt opnieuw de functie element() uitgevoerd.
     * Nu moet de functie een NoSuchElementException Throwen
     */
    @Test
    void element() {
        assertEquals(10246, (int)queue.element());
        assertEquals(10246, (int)queue.element());
        queue.clear();

        assertThrows(NoSuchElementException.class, () -> queue.element());

    }

    /**
     * Deze test kijkt of de functie offer goed functioneerd.
     * Eerst wordt een item geoffered aan de queue, als een item op de queue wordt geofferd dan returned de stack true anders false.
     **/
    @Test
    void offer() {
        assertTrue(queue.offer(4));
    }

    /**
     * Deze test kijkt of de functie peek goed functioneerd.
     *
     * Eerst vraagt de queue een element op met de functie peek(),
     * dit returned het oudste element, maar verwijderd het element niet.
     * Daarna wordt de functie element nog een keer gecalled om te bewijzen dat de item niet verwijderd wordt
     * Tot slot wordt de queue geleegd en wordt opnieuw de functie peek() uitgevoerd.
     * Nu zal er een null gereturned moeten worden
     */
    @Test
    void peek() {
        assertEquals(10246, (int)queue.peek());
        assertEquals(10246, (int)queue.peek());

        queue.clear();

        assertNull(queue.peek());
    }

    /**
     * Deze test kijkt of de functie peek goed functioneerd.
     *
     * Eerst vraagt de queue een element op met de functie poll(),
     * dit returned het oudste element en verwijderd het element.
     * Daarna wordt de functie element nog een keer gecalled om te bewijzen dat de item verwijderd wordt
     * Tot slot wordt de queue geleegd en wordt opnieuw de functie poll() uitgevoerd.
     * Nu zal er een null gereturned moeten worden
     */
    @Test
    void poll() {
        assertEquals(10246, (int)queue.poll());
        assertNotEquals(10246, queue.poll());
        queue.clear();

        assertNull(queue.poll());
    }

    /**
     * Deze test kijkt of de functie remove goed functioneerd.
     *
     * Eerst vraagt de queue een element op met de functie remove(),
     * dit returned het oudste element en verwijderd het element.
     * Daarna wordt de functie element nog een keer gecalled om te bewijzen dat de item verwijderd wordt
     * Tot slot wordt de queue geleegd en wordt opnieuw de functie remove() uitgevoerd.
     * Nu zal er een null gereturned moeten worden
     */
    @Test
    void remove() {
        assertEquals(10246, (int)queue.remove());
        assertEquals(10246, (int)queue.remove());

        queue.clear();

        assertThrows(NoSuchElementException.class, () -> queue.remove());
    }

    /**
     * Deze test kijkt of de functie addAll goed functioneerd.
     *
     * Eerst haalt de functie een nieuwe dataset op,
     * daarna wordt deze dataset in de Queue, queue2, gezet met de functie addAll()
     * Dit moet een return sturen als alles is opgeslagen .
     *
     */
    @Test
    void addAll() {
        ArrayList<Integer> temp2 = CSVreader.readCSV(path);

        Queue<Integer> queue2 = new Queue<>();
        queue2.addAll(temp2);

        assertEquals(true, queue2.addAll(temp2));
    }
}