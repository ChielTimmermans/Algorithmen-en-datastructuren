import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

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
    	assertFalse(tree.search(24));
    	tree.insert(24);
    	assertTrue(tree.search(24));
    	assertFalse(tree.search(Integer.MAX_VALUE));
    	tree.insert(Integer.MAX_VALUE);
    	assertTrue(tree.search(Integer.MAX_VALUE));
    }
    
    @Test
    void insertAll() {
    	ArrayList<Integer> a = new ArrayList<Integer>();
    	a.add(24);
    	a.add(Integer.MAX_VALUE);
    	tree.insertAll(a);
    	assertTrue(tree.search(24));
    	assertTrue(tree.search(Integer.MAX_VALUE));
    }
    
    @Test
    void getRoot() {
    	assertEquals(10246, tree.getRoot().data);
    }
    
    @Test
    void search() {
    	assertTrue(tree.search(10246));
    	assertTrue(tree.search(798));
    	assertFalse(tree.search(24));
    }
    
    @Test
    void getCurrent() {
    	assertEquals(10246, tree.getCurrent());
    	int i = (int) tree.getLeft();
    	assertEquals(i, tree.getCurrent());
    }
    
    @Test
    void hasLeft() {
    	BinarySearchTree<String> b = new BinarySearchTree<String>(); 
    	b.insert("b");
    	b.insert("a");
    	assertTrue(b.hasLeft());
    	b.getLeft();
    	assertFalse(b.hasLeft());
    }
    
    @Test
    void getLeft() {
    	BinarySearchTree<String> b = new BinarySearchTree<String>(); 
    	b.insert("b");
    	b.insert("a");
    	assertEquals("a", b.getLeft());
    	assertEquals(null, b.getLeft());
    }
    
    @Test
    void hasRight() {
    	BinarySearchTree<String> b = new BinarySearchTree<String>(); 
    	b.insert("a");
    	b.insert("b");
    	assertTrue(b.hasRight());
    	b.getRight();
    	assertFalse(b.hasRight());
    }
    
    @Test
    void getRight() {
    	BinarySearchTree<String> b = new BinarySearchTree<String>(); 
    	b.insert("a");
    	b.insert("b");
    	assertEquals("b", b.getRight());
    	assertEquals(null, b.getRight());
    }
    
    @Test
    void hasPrevious() {
    	assertFalse(tree.hasPrevious());
    	tree.getLeft();
    	assertTrue(tree.hasPrevious());
    }
    
    @Test
    void getPrevious() {
    	assertEquals(null, tree.getPrevious());
    	tree.getLeft();
    	assertEquals(10246, tree.getPrevious());
    }
    
    @Test
    void reset() {
    	assertEquals(tree.getCurrent(), tree.getRoot().data);
    	tree.getLeft();
    	tree.getRight();
    	assertNotEquals(tree.getCurrent(), tree.getRoot().data);
    	tree.reset();
    	assertEquals(tree.getCurrent(), tree.getRoot().data);
    }

}