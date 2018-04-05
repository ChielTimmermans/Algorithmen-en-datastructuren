import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SmartBubbleSortTest {

    protected ArrayList<Integer> list;
    protected String path;

    @BeforeEach
    void setUp() {
        path = "C:\\Users\\chiel\\Persoonlijk\\SCHOOL TI STENDEN\\Technische informatica jaar 2\\Periode 3\\Algorithmen en datastructuren\\Eindopdracht\\src\\legosets.csv";
        list = CSVreader.readCSV(path);
    }

    @Test
    void smartBubbleSort() {
        list = SmartBubbleSort.smartBubbleSort(list);
        assertTrue(isSorted());

        list = SmartBubbleSort.smartBubbleSort(list);
        assertTrue(isSorted());
    }

    public boolean isSorted()
    {
        boolean sorted = true;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i-1).compareTo(list.get(i)) > 0) sorted = false;
        }

        return sorted;
    }
}