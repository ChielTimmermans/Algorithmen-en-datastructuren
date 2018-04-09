import java.util.Collection;

public class BinarySearchTree {
    public class Node{
        int key;
        Node left, right;

        Node(int item){
            key = item;
            left = right = null;
        }
    }

    private Node root;

    BinarySearchTree(){
        root = null;
    }

    private void insert(int key){
        root = insertRec(root, key);
    }

    void insertAll(Collection<?> collection){
        for (Object element: collection) {
            insert((int)element);
        }
    }

    private Node insertRec(Node root, int key){
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key){
            root.left = insertRec(root.left, key);
        }else if (key > root.key){
            root.right = insertRec(root.right, key);
        }

        return root;
    }

    void inOrder(){
        inorderRec(root);
    }

    private void inorderRec(Node root){
        if (root != null){
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }
}
