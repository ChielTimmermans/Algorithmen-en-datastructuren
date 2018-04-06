import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test class StackTest.
 *
 * @author  Michael van Dijk, Henk van Maanen, Frank Tieck, Chiel Timmermans
 * @version 05042018
 */
class StackTest {

    /**
     * benodigde variabelen voor de test class
     * @param list = een stack gemaakt om de test over uit te voeren
     * @param path = een string met de path naar de csv, of wel onze dataset
     */
    private Stack<Integer> stack;

    StackTest() {
        stack = new Stack<>();
    }

    /**
     * De setup wordt elke keer uitgevoerd voordat een testfunctie wordt aangeroepen
     * In deze setup wordt de data set opgehaald en wordt het omgezet naar een Stack
     *
     */
    @BeforeEach
    void setUp() {
        String path = "src/legosets.csv";

        ArrayList<Integer> temp = CSVreader.readCSV(path);
        stack.pushAll(temp);
    }

    /**
     * Deze test kijkt of de functie empty goed functioneerd.
     * Eerst wordt de empty() uitgevoerd over een stack die vol is met de dataset,
     * dit moet False returnen omdat er items in de stack zitten
     * Daarna wordt de stack compleet geleegd en wordt de functie empty() nog een keer uitgevoerd,
     * dit moet True returnen omdat er geen items meer in de stack zitten
     *
     * In deze test wordt tegelijkertijd ook getest of de functie clear wel goed functioneerd
     */
    @Test
    void empty() {
        assertFalse(stack.empty());

        stack.clear();

        assertTrue(stack.empty());
    }

    /**
     * Deze test kijkt of de functie push goed functioneerd.
     * Eerst wordt een item gepusth op de stack, als een item op de stack wordt gepusht dan returned de stack dat item.
     * Daarna wordt er een peek uitgevoerd op de stack om te kijken of het item daad werkelijk op de goede plek, index = 0, is beland.
     */
    @Test
    void push() {
        assertEquals(70000, (int)stack.push(70000));
        assertEquals(70000, (int)stack.peek());
    }

    /**
     * Deze test kijkt of de functie pop goed functioneerd.
     * pop returned de laatst toegevoegde item en verwijderd deze.
     * Deze functie wordt 2 keer getest om te testen of een item daad werkelijk wordt verwijderd.
     * Daarna wordt de stack gecleared om te check dat de stack ook een EmptyStackException geeft
     * op het moment als de functie pop wordt gecalled over een lege stack.
     */
    @Test
    void pop() {
        assertEquals(798, (int)stack.pop());
        assertEquals(796, (int)stack.pop());

        stack.clear();

        assertThrows(EmptyStackException.class, () -> stack.pop());
    }


    /**
     * Deze test kijkt of de functie peek goed functioneerd.
     * peek returned de laatst toegevoegde item maar verwijderd deze niet.
     * Deze functie wordt 2 keer getest om te testen of de item blijft bestaan.
     * Daarna wordt de stack gecleared om te check dat de stack ook een EmptyStackException geeft
     * op het moment als de functie peek wordt gecalled over een lege stack.
     */
    @Test
    void peek() {
        assertEquals(798, (int)stack.peek());
        assertEquals(798, (int)stack.peek());


        stack.clear();

        assertThrows(EmptyStackException.class, () -> stack.peek());
    }

    /**
     * Deze test kijkt of de functie search goed functioneerd.
     * search returned de index van een item geteld vanaf 1
     * Eerst wordt gezocht op item 798, in de dataset kun je zien dat dit item nummer 1 is, dit zal 1 moeten returnen.
     * daarna wordt gezocht op item "Object test", in de dataset is dit item niet te vinden, dit zal -1 moeten returnen.
     */
    @Test
    void search() {
        assertEquals(1, stack.search(798));
        assertEquals(-1, stack.search("Object test"));
    }
}