import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test class DoublyLinkedListTest.
 *
 * @author  Michael van Dijk, Henk van Maanen, Frank Tieck, Chiel Timmermans
 * @version 05042018
 */
class DoublyLinkedListTest {

    /**
     * benodigde variabelen voor de test class
     * @param list = een DoublyLinkedList gemaakt om de test over uit te voeren
     * @param path = een string met de path naar de csv, of wel onze dataset
     */
    protected DoublyLinkedList<Integer> list;
    protected String path;

    /**
     * De setup wordt elke keer uitgevoerd voordat een testfunctie wordt aangeroepen
     * In deze setup wordt de data set opgehaald en in een DoublyLinkedList gezet.
     */
    @BeforeEach
    void setUp() {
        list = new DoublyLinkedList<>();
        path = "src/legosets.csv";

        ArrayList<Integer> temp = CSVreader.readCSV(path);
        list.addAll(temp);
    }

    /**
     * Deze test kijkt of de functie add(E element) goed functioneert.
     * Eerst wordt een item geadd aan de DoublyLinkedList, als een item op de DoublyLinkedList wordt geadd dan returned de stack true.
     * Daarna wordt de list verwijderd en wordt er opnieuw een item in gezet.
     * Dit laatste wordt gedaan zodat we ook testen of de add() een head aan kan maken als dienog niet bestaat
     **/
    @Test
    void add() {
        assertTrue(list.add(7));
        list.clear();
        assertTrue(list.add(7));
    }

    /**
     * Deze test kijkt of de functie add(int index, E element) goed functioneert.
     * Eerst wordt een item geadd aan de DoublyLinkedList, als een item op de DoublyLinkedList wordt geadd dan returned de stack true.
     * Daarna wordt de list verwijderd en wordt er opnieuw een item in gezet.
     * Dit laatste wordt gedaan zodat er ook getest wordt of de add() een head aan kan maken als die nog niet bestaat.
     * Tot slot wordt er een item geadd op een index buiten de array,
     * Dit zal een IndexOutOfBoundsException moeten geven
     **/
    @Test
    void add1() {
        list.add(2, 7);
        assertEquals(7, (int)list.get(2));
        list.add(0, 8);
        assertEquals(8, (int)list.get(0));
        list.add(list.size(), list.get(2));
    }

    /**
     * Deze test kijkt of de functie addAll(collection) goed functioneert.
     * Eerst wordt een nieuwe dataset binnen gehaald.
     * Dit wordt daarna in de functie list.addall
     * Hierna wordt gecheckt of de dataset ook in de list zit met de functie containsAll
     **/
    @Test
    void addAll() {
        ArrayList<Integer> temp2 = CSVreader.readCSV(path);

        assertEquals(true, list.addAll(temp2));
    }

    /**
     * Deze test kijkt of de functie addAll(index, collection) goed functioneert.
     * Eerst wordt een nieuwe dataset binnen gehaald.
     * Dit wordt daarna in de functie list.addall
     * Hierna wordt gecheckt of de dataset ook in de list zit met de functie containsAll
     * En wordt er gecheckt of de dataset wel op de goede plek zit
     **/
    @Test
    void addAll1() {
        ArrayList<Integer> temp2 = CSVreader.readCSV(path);

        assertEquals(true, list.addAll(4, temp2));
        assertEquals(10246, (int) list.get(4));
    }

    /**
     * Deze test kijkt of de functie contains(Object o) goed functioneert.
     *
     * eerst wordt gezocht naar een bestaand Object, dit zou true moeten returnen
     * Daarna wordt er gezocht naar een niet bestaand Object, dit zou False moeten returnen
     */
    @Test
    void contains() {
        assertTrue(list.contains(75103));
    }

    /**
     * Deze test kijkt of de functie containsAll(Collection c) goed functioneert.
     *
     * Eerst wordt dezelfde dataset als list opgehaald en vergeleken met elkaar,
     * dit moet True returnen
     * Daarna wordt de het item 2323 toegevoegd aan de temp2,
     * nu wordt er nog een vergelijking gedaan tussen temp2 en de list.
     * Nu zal hij false moeten returnen aangezien item 2323 niet bestaat
     */
    @Test
    void containsAll() {
        ArrayList<Integer> temp2 = CSVreader.readCSV(path);

        assertTrue(list.containsAll(temp2));


        ArrayList<Integer> temp3 = CSVreader.readCSV(path);
        ArrayList<Integer> temp4 = CSVreader.readCSV(path);

        list.clear();
        list.addAll(temp3);

        temp4.add(2323);

        assertFalse(list.containsAll(temp4));
    }

    /**
     * Deze test kijkt of de functie get(Int index) goed functioneert.
     *
     * get() vraagt het object op de locatie van index, dit zal in de dataset het eerste item zijn en dat is item 10246
     */
    @Test
    void get() {
        assertEquals(10246, (int) list.get(0));

        assertEquals(10246, (int) list.get(0));


        assertThrows(IndexOutOfBoundsException.class, () -> list.get(list.size() + 1));
    }

    /**
     *  Deze test kijkt of de functie indexOf(Object obj) goed functioneert.
     *  de test haalt een item op en checkt of dat de goede item is
     *  en daarna test hij een andere item om te kijken of niet elke indexOf het zelfde returned
     */
    @Test
    void indexOf() {
        assertEquals(53, list.indexOf(21022));
        assertNotEquals(53, list.indexOf(10246));
    }

    /**
     * Deze test kijkt of de functie isEmpty() goed functioneert.
     *
     * Eerst wordt er gekeken of een volle list leeg is, dit zou False moeten returnen,
     * daarna wordt de list leeg gemaakt en wordt er nog een keer gekeken of de list leeg is, dit zou True moeten returnen.
     */
    @Test
    void isEmpty() {
        assertFalse(list.isEmpty());
        list.clear();
        assertTrue(list.isEmpty());
    }

    /**
     * Deze test kijkt of de functie iterator() goed functioneert.
     */
    @Test
    void iterator() {
        //assertEquals(, list.iterator());
    }

    /**
     * Deze test kijkt of de functie lastIndexOf(Object obj) goed functioneert.
     *
     * Eerst wordt gekeken op welke index Object 10246 voor het laatst staat, dit zou 0 moeten zijn.
     * Daarna wordt gekeken op welke index Object null staat, dit zou -1 moeten zijn omdat null geen object mag zijn.
     */
    @Test
    void lastIndexOf() {
        assertEquals(0, list.lastIndexOf("10246"));
        assertEquals(-1, list.lastIndexOf(null));
    }

    /**
     * Deze test kijkt of de functie listIterator goed functioneert.
     */
    @Test
    void listIterator() {
    }

    /**
     * Deze test kijkt of de functie listIterator1() goed functioneert.
     */
    @Test
    void listIterator1() {
    }

    /**
     * Deze test kijkt of de functie remove(Object obj) goed functioneert.
     *
     * Eerst wordt Object 10247 verwijderd. dit zou true moeten returnen.
     * Daarna wordt Object 10247 nog een keer verwijderd. dit zou dan false moeten returnen omdat Object 10247 niet meer bestaat.
     *
     */
    @Test
    void remove() {
        assertTrue(list.remove((Object) 10247));
        assertFalse(list.remove((Object) 10247));
    }

    /**
     * Deze test kijkt of de functie remove(int index) goed functioneert.
     *
     * Eerst wordt het object op de index van 0 verwijdert, dit returned het object terug wat 10246 zou moeten zijn.
     * Daarna verwijderen we index 0 nog een keer om te kijken of hij daadwerkelijk verwijderd is, dit zou 10247 moeten returnen, dit komt omdat 10247 het volgende object is in de lijst.
     *
     * Tot slot wordt gekeken naar de Exception die de functie moet geven.
     * Eerst wordt getest of de index boven het limit is van de list en daarna als er een index van -1 of lager wordt gegeven.
     * Deze 2 testen zouden allebei een IndexOutOfBoundsException moetten geven.
     */
    @Test
    void remove1() {
        assertEquals(10247, (int)list.remove(1));
        assertEquals(10246, (int)list.remove(0));
    }

    /**
     * Deze test kijkt of de functie removeAll(list) goed functioneert.
     *
     * Eerst wordt de lijst verwijderd met de functie removeAll.
     * Daarna wordt er gekeken of er nog items over zijn.
     * Omdat de lijst waarin de items staan die verwijderd moeten worden gelijk staat aan de lijst zelf zullen alle items verwijderd worden.
     * Daarna wordt gekeken of de lijst daadwerkelijk leeg is door zijn size te checken.
     */
    @Test
    void removeAll() {
        assertTrue(list.removeAll(list));
        assertEquals(0, list.size());
    }

    /**
     * Deze test kijkt of de functie retainAll() goed functioneert.
     */
    @Test
    void retainAll() {
        assertThrows(NullPointerException.class, () -> list.retainAll(null));
    }

    /**
     * Deze test kijkt of de functie set(int index, Object obj) goed functioneert.
     *
     * Eerst wordt het object 12345 geplaatst op index 5, dit returned de oude waarde van index 5 en dat zou 10582 moeten zijn.
     * Daarna wordt het object 12346 geplaatst op index 5, dit zou nu de vorige object waarde moeten returnen en dat was 12345.
     */
    @Test
    void set() {
        assertEquals(10582, (int)list.set(5, 12345));
        assertEquals(12345, (int)list.set(5, 12346));
    }

    /**
     * Deze test kijkt of de functie size() goed functioneert.
     *
     * de lijst wordt gecheckt op zijn lengte, dit zou 6035 moeten zijn.
     */
    @Test
    void size() {
        assertEquals(6035, list.size());
    }

    /**
     * Deze test kijkt of de functie subList() goed functioneert.
     *
     * eerst wordt er een sublist gemaakt van de list van index 1 tot 3,
     * daarna wordt er een list gemaakt om dit te vergelijken.
     *
     * Tot slot wordt er gekeken of er een IndexOutOfBoundsException gegooid wordt als het minimum hoger is dan het maximum
     */
    @Test
    void subList() {
        list.subList(0, 2);
        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(10246);
        list2.add(10247);
        list2.add(10248);
        for(int i = 0; i < list2.size(); i++){
            assertEquals(list2.get(i), list.get(i));
        }

        assertThrows(IndexOutOfBoundsException.class, () -> list.subList(5, 2));


    }

    /**
     * Deze test kijkt of de functie toArray() goed functioneert.
     *
     *
     */
    @Test
    void toArray() {

    }

    /**
     * Deze test kijkt of de functie toArray(T[] a) goed functioneert.
     *
     * Eerst wordt de list omgezet naar een array, de array is een Integer array die 6 lang is
     * Daarna wordt gekeken of elke value klopt.
     *
     */
    @Test
    void toArray1() {
        Integer array[] = list.toArray(new Integer[6]);
        assertEquals(10246, (int)array[0]);
        assertEquals(10247, (int)array[1]);
        assertEquals(10248, (int)array[2]);
        assertEquals(10249, (int)array[3]);
        assertEquals(10581, (int)array[4]);
        assertEquals(10582, (int)array[5]);
    }
}