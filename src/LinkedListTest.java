import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    protected LinkedList<Integer> list;
    protected String path;
    @BeforeEach
    void setUp() {
        list = new LinkedList<Integer>();
        //path = "C:/Users/frank/workspace/ADEindopdracht/src/legosets.csv";
        path = "C:\\Users\\chiel\\Persoonlijk\\SCHOOL TI STENDEN\\Technische informatica jaar 2\\Periode 3\\Algorithmen en datastructuren\\Eindopdracht\\src\\legosets.csv";
        ArrayList<Integer> temp = CSVreader.readCSV(path);
        list.addAll(temp);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void add() {
        assertTrue(list.add(7));
        list.clear();
        assertTrue(list.add(7));
    }


    @Test
    void add1() {
        list.add(2, 7);
        assertEquals(7, (int)list.get(2));
        list.add(0, 8);
        assertEquals(8, (int)list.get(0));
    }

    @Test
    void addAll() {
        ArrayList<Integer> temp2 = CSVreader.readCSV(path);

        assertEquals(true, list.addAll(temp2));
    }

    @Test
    void addAll1() {
        ArrayList<Integer> temp2 = CSVreader.readCSV(path);

        assertEquals(true, list.addAll(4, temp2));
        assertEquals(10246, (int) list.get(4));
    }

    @Test
    void contains() {
        assertTrue(list.contains(75103));
    }

    @Test
    void containsAll() {
        ArrayList<Integer> temp2 = CSVreader.readCSV(path);

        assertTrue(list.containsAll(temp2));
    }

    @Test
    void get() {
        assertEquals(10246, (int) list.get(0));
    }

    @Test
    void indexOf() {
        assertEquals(53, list.indexOf(21022));
    }

    @Test
    void isEmpty() {
        assertFalse(list.isEmpty());
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    void iterator() {
        //assertEquals(, list.iterator());
    }

    @Test
    void lastIndexOf() {
        assertEquals(5, list.lastIndexOf("10246"));
    }

    @Test
    void listIterator() {
    }

    @Test
    void listIterator1() {
    }

    @Test
    void remove() {
    }

    @Test
    void remove1() {
    }

    @Test
    void removeAll() {
    }

    @Test
    void retainAll() {
    }

    @Test
    void set() {
    }

    @Test
    void size() {
    }

    @Test
    void subList() {
    }

    @Test
    void toArray() {
    }

    @Test
    void toArray1() {
    }
}