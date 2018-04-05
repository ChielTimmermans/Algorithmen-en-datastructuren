import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    protected List<Integer> list;

    @BeforeEach
    void setUp() {
        list = new ArrayList<Integer>();
        ArrayList<Integer> temp = CSVreader.readCSV("C:\\Users\\chiel\\Persoonlijk\\SCHOOL TI STENDEN\\Technische informatica jaar 2\\Periode 3\\Algorithmen en datastructuren\\Eindopdracht\\src\\legosets.csv");
        list.addAll(temp);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void add() {
        list.add(7);
        assertEquals(7, (int)list.get(list.size() - 1));
    }

    @Test
    void addAll() {
        assertEquals(6035, list.size());
    }

    @Test
    void contains() {
        assertTrue(list.contains(75103));
    }

    @Test
    void containsAll() {
        ArrayList<Integer> temp2 = CSVreader.readCSV("C:\\Users\\chiel\\Persoonlijk\\SCHOOL TI STENDEN\\Technische informatica jaar 2\\Periode 3\\Algorithmen en datastructuren\\Eindopdracht\\src\\legosets.csv");

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
        list.clear();
        assertTrue(list.isEmpty());
    }
}