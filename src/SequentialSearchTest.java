import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SequentialSearchTest {

    protected ArrayList<Integer> list;
    protected String path;

    @BeforeEach
    void setUp() {
        path = "src/legosets.csv";

        list = CSVreader.readCSV(path);
    }

    @Test
    void contains() {
        assertTrue(SequentialSearch.sequentialSearch(list, 10246));
        assertFalse(SequentialSearch.sequentialSearch(list, 104679));
    }
}