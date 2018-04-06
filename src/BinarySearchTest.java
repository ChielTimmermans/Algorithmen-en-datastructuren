import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

class BinarySearchTest {
	
	protected ArrayList<Integer> list;
    protected String path;
    
    @BeforeEach
    void setUp() {
        path = "src/legosets.csv";

        list = QuickSort.quickSort(CSVreader.readCSV(path));
    }
	
	@Test
    void runBinarySearch() {
	     assertEquals(4574, BinarySearch.binarySearch(list, 10243));
	     assertNotEquals(4574, BinarySearch.binarySearch(list, 10246));
	     assertEquals(-1, BinarySearch.binarySearch(list, "test"));
    }

    @Test
    void runBinarySearchRecursively() {
    	assertEquals(4574, BinarySearch.runBinarySearchRecursively(list.toArray(), 10243, 0, list.size()-1));
	    assertNotEquals(4574, BinarySearch.runBinarySearchRecursively(list.toArray(), 10246, 0, list.size()-1));
	    assertEquals(-1, BinarySearch.runBinarySearchRecursively(list.toArray(), "tets", 0, list.size()-1));
    }

    @Test
    void runBinarySearchIteratively() {
    	assertEquals(4574, BinarySearch.runBinarySearchIteratively(list.toArray(), 10243, 0, list.size()-1));
	    assertNotEquals(4574, BinarySearch.runBinarySearchIteratively(list.toArray(), 10246, 0, list.size()-1));
	    assertEquals(-1, BinarySearch.runBinarySearchIteratively(list.toArray(), "tets", 0, list.size()-1));
    }
}