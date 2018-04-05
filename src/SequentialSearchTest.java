import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SequentialSearchTest {

    protected ArrayList<Integer> list;
    protected String path;

    @BeforeEach
    void setUp() {
        path = "C:\\Users\\chiel\\Persoonlijk\\SCHOOL TI STENDEN\\Technische informatica jaar 2\\Periode 3\\Algorithmen en datastructuren\\Eindopdracht\\src\\legosets.csv";
        list = CSVreader.readCSV(path);
    }

    @Test
    void contains() {
        assertTrue(SequentialSearch.contains(list, 10246));
        assertFalse(SequentialSearch.contains(list, 104679));
    }
}