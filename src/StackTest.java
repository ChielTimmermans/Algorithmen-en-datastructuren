import org.junit.jupiter.api.AfterEach;
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

    protected Stack<Integer> list;
    private String path;

    @BeforeEach
    void setUp() {
        path = "src/legosets.csv";

        list = new Stack<Integer>();
        ArrayList<Integer> temp = CSVreader.readCSV(path);
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

        list.clear();

        assertThrows(EmptyStackException.class, () -> {list.pop();});
    }



    @Test
    void peek() {
        assertEquals(798, (int)list.peek());
        assertEquals(798, (int)list.peek());


        list.clear();

        assertThrows(EmptyStackException.class, () -> {list.peek();});
    }

    @Test
    void search() {
        assertEquals(1, list.search(798));
        assertEquals(-1, list.search("Object test"));
    }
}