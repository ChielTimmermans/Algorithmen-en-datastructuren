import org.junit.jupiter.api.Assertions;
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
    void sequentialSearch() {
        assertEquals(0, SequentialSearch.sequentialSearch(list, 10246));
        assertNotEquals(0, SequentialSearch.sequentialSearch(list, 10243));
        assertEquals(-1, SequentialSearch.sequentialSearch(list, "test"));
    }
}