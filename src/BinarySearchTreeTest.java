import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class BinarySearchTreeTest {

    protected ArrayList<Integer> list;
    protected String path;
    protected BinarySearchTree tree;

    @BeforeEach
    void setUp() {
        path = "src/legosets.csv";

        list = CSVreader.readCSV(path);
        tree = new BinarySearchTree();
        tree.insertAll(list);
    }

    @Test
    void insert() {
    }

    @Test
    void insertAll(){
    }

    @Test
    void insertRec() {
    }

    @Test
    void inOrder() {

    }

    @Test
    void inorderRec() {
    }

    @Test
    void main() {
    }
}