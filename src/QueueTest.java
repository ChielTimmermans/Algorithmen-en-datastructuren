import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    protected Queue<Integer> queue, queue2;
    protected String path;
    @BeforeEach
    void setUp() {
        path = "C:\\Users\\chiel\\Persoonlijk\\SCHOOL TI STENDEN\\Technische informatica jaar 2\\Periode 3\\Algorithmen en datastructuren\\Eindopdracht\\src\\legosets.csv";
        ArrayList<Integer> temp = CSVreader.readCSV(path);

        queue = new Queue<Integer>();
        queue.addAll(temp);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void add() {
        assertTrue(queue.add(4));
    }

    @Test
    void element() {
        assertEquals(10246, (int)queue.element());
        queue.clear();

        assertThrows(NoSuchElementException.class, () -> {queue.element();});

    }

    @Test
    void offer() {
        assertTrue(queue.add(4));
    }

    @Test
    void peek() {
        assertEquals(10246, (int)queue.peek());
        queue.clear();

        assertNull(queue.peek());
    }

    @Test
    void poll() {
        assertEquals(10246, (int)queue.poll());
        queue.clear();

        assertNull(queue.poll());
    }

    @Test
    void remove() {
        assertEquals(10246, (int)queue.remove());

        queue.clear();

        assertThrows(NoSuchElementException.class, () -> {queue.remove();});
    }

    @Test
    void addAll() {
        ArrayList<Integer> temp2 = CSVreader.readCSV(path);

        queue2 = new Queue<Integer>();
        queue2.addAll(temp2);

        assertEquals(true, queue2.addAll(temp2));
    }
}