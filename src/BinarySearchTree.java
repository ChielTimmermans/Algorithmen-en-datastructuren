import java.util.Collection;
import java.util.Comparator;

public class BinarySearchTree<E> {
	
	public class Node {
		E data;
        Node left, right, parent;

        Node(E data) {
            this.data = data;
            this.left = this.right = this.parent = null;
        }

        
        Node(E data, Node p){
        	this.data = data;
            this.left = this.right = null;
            this.parent = p;
        }

    }

    Node root;
    Node current;
    
    //hier wordt de COmparator gezet,
    //dit wordt gedaan op basis van de datatype van de items in de objecttype
    Comparator<E> com =new Comparator<E>() {
        @Override
        public int compare(E o1, E o2) {
        /*
         * checkt of o1 en o2 integers zijn,
         * als dit waar is dan returned hij de vergelijking tussen o1 en o2
         * de compareTo() functie returned -1, 0 of 1.
         * -1 als o1 kleiner is dan o2
         * 0 als o1 gelijk staat aan o2
         * 1 als o1 groter is dan o2
         *
         * Dit geld ook voor de tweede en derde else statement.
         * Alleen wordt bij de tweede gecheckt of de items Strings zijn,
         * zo ja dan wordt het op alfabetische volgorde gesort.
         *
         * Bij de derde statement wordt alles gezet wat geen Integer of String is
         * Hier wordt dan de toString functie over aangeroepen, dit wordt daarna vergeleken met elkaar
         * Er is voor deze methode gekozen omdat het algorithm generic is en daarom op elke datatype moet werken.
         * Daarnaast is hij ook makkelijk uitbreidbaar als je je eigen compare functie wil toevoegen
         */
        	if(o1 instanceof Integer && o2 instanceof Integer) {
            	Integer i1 = (Integer)o1;
            	Integer i2 = (Integer)o2;
            	return i1.compareTo(i2);
            } else if(o1 instanceof String && o2 instanceof String) {
            	String s1 = (String)o1;
            	String s2 = (String)o2;
            	return s1.compareTo(s2);
            } else {
            	return o1.toString().compareTo(o2.toString());
            }
        }
    };


    BinarySearchTree(){
        root = null;
        current = null;
    }

    public boolean insert(E key) {
    	if(root == null) {
    		root = new Node(key);
    		current = root;
    		return true;
    	} else {
    		Node temp = root;
    		while(true) {
    			if(com.compare(temp.data, key) >0) {
    				if(temp.left != null) {
    					temp = temp.left;
    				} else {
    					temp.left = new Node(key, temp);
    					return true;
    				}
    			} else {
    				if(temp.right != null) {
    					temp = temp.right;
    				} else {
    					temp.right = new Node(key, temp);
    					return true;
    				}
    			}
    		}
    	}
    }
    
    public void insertAll(Collection<E> col) {
        for (E element: col) {
            insert(element);
        }
    }
    
    public Node getRoot() {
    	return root;
    }
    
    public boolean search(E key) {
    	return search(key, root);
    }
    
    private boolean search(E key, Node n) {
    	if(key.equals(n.data)) {
    		return true;
    	} else if(n.left != null && com.compare(n.data, key) >0) {
    		return search(key, n.left);
    	} else if(n.right != null && com.compare(n.data, key) <0) {
    		return search(key, n.right);
    	} else {
    		return false;
    	}
    }
    
    public E getCurrent() {
    	return current.data;
    }
    
    public boolean hasLeft() {
    	if(current.left != null) {
    		return true;
    	}
    	return false;
    }
    
    public E getLeft() {
    	if(current.left != null) {
    		current = current.left;
    		return current.data;
    	}
    	return null;
    }
    
    public boolean hasRight() {
    	if(current.right != null) {
    		return true;
    	}
    	return false;
    }
    
    public E getRight() {
    	if(current.right != null) {
    		current = current.right;
    		return current.data;
    	}
    	return null;
    }
    
    public boolean hasPrevious() {
    	if(current.parent != null) {
    		return true;
    	}
    	return false;
    }
    
    public E getPrevious() {
    	if(current.parent != null) {
    		current = current.parent;
    		return current.data;
    	}
    	return null;
    }
    
    public void reset() {
    	current = root;
    }

}
