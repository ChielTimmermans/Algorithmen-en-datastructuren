import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test class LinkedListTest.
 *
 * @author  Michael van Dijk, Henk van Maanen, Frank Tieck, Chiel Timmermans
 * @version 05042018
 */
class LinkedListTest {

    /**
     * benodigde variabelen voor de test class
     * @param list = een LinkedList gemaakt om de test over uit te voeren
     * @param path = een string met de path naar de csv, of wel onze dataset
     */
    protected LinkedList<Integer> list;
    protected String path;

    /**
     * De setup wordt elke keer uitgevoerd voordat een testfunctie wordt aangeroepen
     * In deze setup wordt de data set opgehaald en in een LinkedList gezet.
     */
    @BeforeEach
    void setUp() {
        list = new LinkedList<>();
        path = "src/legosets.csv";

        ArrayList<Integer> temp = CSVreader.readCSV(path);
        list.addAll(temp);
    }

    /**
     * Deze test kijkt of de functie add(E element) goed functioneerd.
     * Eerst wordt een item geadd aan de LinkedList, als een item op de LinkedList wordt geadd dan returned de stack true.
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
     * Deze test kijkt of de functie add(int index, E element) goed functioneerd.
     * Eerst wordt een item geadd aan de LinkedList, als een item op de LinkedList wordt geadd dan returned de stack true.
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
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(list.size() + 5, 8));
    }

    /**
     * Deze test kijkt of de functie addAll(collection) goed functioneerd.
     * Eerst wordt een nieuwe dataset binnen gehaald.
     * Dit wordt daarna in de functie list.addall
     * Hierna wordt gecheckt of de dataset ook in de list zit met de functie containsAll
     **/
    @Test
    void addAll() {
        ArrayList<Integer> temp2 = CSVreader.readCSV(path);

        assertEquals(true, list.addAll(temp2));
        assertTrue(list.containsAll(temp2));
    }

    /**
     * Deze test kijkt of de functie addAll(index, collection) goed functioneerd.
     * Eerst wordt een nieuwe dataset binnen gehaald.
     * Dit wordt daarna in de functie list.addall
     * Hierna wordt gecheckt of de dataset ook in de list zit met de functie containsAll
     * En wordt er gecheckt of de dataset wel op de goede plek zit
     **/
    @Test
    void addAll1() {
        ArrayList<Integer> temp2 = CSVreader.readCSV(path);

        assertEquals(true, list.addAll(4, temp2));
        assertTrue(list.containsAll(temp2));
        assertEquals(10246, (int) list.get(4));
    }

    /**
     * Deze test kijkt of de functie contains(Object o) goed functioneerd.
     *
     * eerst wordt gezocht naar een bestaand Object, dit zou true moeten returnen
     * Daarna wordt er gezocht naar een niet bestaand Object, dit zou False moeten returnen
     */
    @Test
    void contains() {
        assertTrue(list.contains(75103));
        assertFalse(list.contains(232345234));
    }

    /**
     * Deze test kijkt of de functie containsAll(Collection c) goed functioneerd.
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

        temp2.add(2323);

        assertFalse(list.containsAll(temp2));
    }

    /**
     * Deze test kijkt of de functie get(Int index) goed functioneerd.
     *
     * get() vraagt het object op de locatie van index, dit zal in de dataset het eerste item zijn en dat is item 10246
     */
    @Test
    void get() {
        assertEquals(10246, (int) list.get(0));
        assertNotEquals(1024236, list.get(0));
    }

    /**
     *  Deze test kijkt of de functie indexOf(Object obj) goed functioneerd.
     *  de test haalt een item op en checkt of dat de goede item is
     *  en daarna test hij een andere item om te kijken of niet elke indexOf het zelfde returned
     */
    @Test
     void indexOf() {
        assertEquals(53, list.indexOf(21022));
        assertNotEquals(53, list.indexOf(10246));
    }

    /**
     * Deze test kijkt of de functie isEmpty() goed functioneerd.
     */
    @Test
    void isEmpty() {
        assertFalse(list.isEmpty());
        list.clear();
        assertTrue(list.isEmpty());
    }

    /**
     * Deze test kijkt of de functie indexOf(Object obj) goed functioneerd.
     */
    @Test
    void iterator() {
        //assertEquals(, list.iterator());
    }

    /**
     * Deze test kijkt of de functie indexOf(Object obj) goed functioneerd.
     */
    @Test
    void lastIndexOf() {
        assertEquals(0, list.lastIndexOf("10246"));
        assertEquals(-1, list.lastIndexOf(null));
    }

    /**
     * Deze test kijkt of de functie indexOf(Object obj) goed functioneerd.
     */
    @Test
    void listIterator() {
    }

    /**
     * Deze test kijkt of de functie indexOf(Object obj) goed functioneerd.
     */
    @Test
    void listIterator1() {
    }

    /**
     * Deze test kijkt of de functie indexOf(Object obj) goed functioneerd.
     */
    @Test
    void remove() {
        assertTrue(list.remove((Object) 10247));
        assertFalse(list.remove((Object) 10247));

        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
    }

    /**
     * Deze test kijkt of de functie indexOf(Object obj) goed functioneerd.
     */
    @Test
    void remove1() {
        assertEquals(10247, (int)list.remove(1));
        assertEquals(10246, (int)list.remove(0));
    }

    /**
     * Deze test kijkt of de functie indexOf(Object obj) goed functioneerd.
     */
    @Test
    void removeAll() {
        assertTrue(list.removeAll(list));
        assertEquals(0, list.size());
    }

    /**
     * Deze test kijkt of de functie indexOf(Object obj) goed functioneerd.
     */
    @Test
    void retainAll() {
    }

    /**
     * Deze test kijkt of de functie indexOf(Object obj) goed functioneerd.
     */
    @Test
    void set() {
        assertEquals(10582, (int)list.set(5, 12345));
        assertEquals(12345, (int)list.set(5, 12346));
    }

    /**
     * Deze test kijkt of de functie indexOf(Object obj) goed functioneerd.
     */
    @Test
    void size() {
        assertEquals(6035, list.size());
    }

    /**
     * Deze test kijkt of de functie indexOf(Object obj) goed functioneerd.
     */
    @Test
    void subList() {
        list.subList(0, 2);
        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(10246);
        list2.add(10247);
        list2.add(10248);
        for(int i = 0; i > list2.size(); i++){
            assertEquals(list2.get(i), list);
        }

        assertThrows(IndexOutOfBoundsException.class, () -> list.subList(5, 2));
    }

    /**
     * Deze test kijkt of de functie indexOf(Object obj) goed functioneerd.
     */
    @Test
    void toArray() {

    }

    /**
     * Deze test kijkt of de functie indexOf(Object obj) goed functioneerd.
     */
    @Test
    void toArray1() {
    }
}