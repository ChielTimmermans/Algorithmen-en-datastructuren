import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {


    protected Stack<Integer> list;

    @BeforeEach
    void setUp() {
        list = new Stack<Integer>();
        ArrayList<Integer> temp = CSVreader.readCSV("C:\\Users\\chiel\\Persoonlijk\\SCHOOL TI STENDEN\\Technische informatica jaar 2\\Periode 3\\Algorithmen en datastructuren\\Eindopdracht\\src\\legosets.csv");
        list.pushAll(temp);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void empty() {
        assertFalse(list.empty());
    }

    @Test
    void push() {
        assertEquals(70000, (int)list.push(70000));
    }

    @Test
    void pop() {
        assertEquals(798, (int)list.pop());
        assertEquals(796, (int)list.pop());
    }

    @Test
    void peek() {
        assertEquals(798, (int)list.peek());
        assertEquals(798, (int)list.peek());
    }

    @Test
    void search() {
        assertEquals(1, list.search(798));
    }
}