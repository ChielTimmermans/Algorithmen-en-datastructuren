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
        //path = "C:\\Users\\chiel\\Persoonlijk\\SCHOOL TI STENDEN\\Technische informatica jaar 2\\Periode 3\\Algorithmen en datastructuren\\Eindopdracht\\src\\legosets.csv";
        path = "C:\\Users\\PChiel\\Desktop\\AD\\src\\legosets.csv";
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
        assertEquals(0, list.lastIndexOf("10246"));
    }

    @Test
    void listIterator() {
    }

    @Test
    void listIterator1() {
    }

    @Test
    void remove() {
        assertTrue(list.remove((Object) 10247));
        assertFalse(list.remove((Object) 10247));
    }

    @Test
    void remove1() {
        assertEquals(10247, (int)list.remove(1));
        assertEquals(10246, (int)list.remove(0));
    }

    @Test
    void removeAll() {
        assertTrue(list.removeAll(list));
        assertEquals(0, list.size());
    }

    @Test
    void retainAll() {
    }

    @Test
    void set() {
        assertEquals(10582, (int)list.set(5, 12345));
        assertEquals(12345, (int)list.set(5, 12346));
    }

    @Test
    void size() {
        assertEquals(6035, list.size());
    }

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
    }

    @Test
    void toArray() {

    }

    @Test
    void toArray1() {
    }
}