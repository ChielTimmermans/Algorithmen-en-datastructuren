import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class InsertionSortTest {

    protected ArrayList<Integer> list;
    protected String path;

    @BeforeEach
    void setUp() {
        path = "src/legosets.csv";

        list = CSVreader.readCSV(path);
    }

    @Test
    void insertionSort() {
        list = InsertionSort.insertionSort(list);
        assertTrue(isSorted());
    }

    private boolean isSorted()
    {
        boolean sorted = true;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i-1).compareTo(list.get(i)) > 0) sorted = false;
        }

        return sorted;
    }
}