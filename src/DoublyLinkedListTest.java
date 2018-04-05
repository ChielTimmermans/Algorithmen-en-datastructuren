import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest extends LinkedListTest {

    @BeforeEach
    void setUp() {
        list = new LinkedList<Integer>();
        //path = "C:/Users/frank/workspace/ADEindopdracht/src/legosets.csv";
        path = "C:\\Users\\chiel\\Persoonlijk\\SCHOOL TI STENDEN\\Technische informatica jaar 2\\Periode 3\\Algorithmen en datastructuren\\Eindopdracht\\src\\legosets.csv";
        ArrayList<Integer> temp = CSVreader.readCSV(path);
        list.addAll(temp);
    }
}