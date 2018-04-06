import java.util.*;

public class DoublyLinkedList<E> implements List<E>{

    private class Node {
        public E data;
        public Node next;
        public Node previous;

        public Node(E data) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }
        @SuppressWarnings("unused")
        public Node(E data, Node next, Node previous) {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }

        public String toString() {
            return "Node(" + data.toString() + ")";
        }
    }


    private int size;            // keeps track of the number of elements
    private Node head;           // reference to the first node
    private Node tail;

    /**
     *
     */
    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean add(E element) {
        if (head == null) {
            Node node = new Node(element);
            head = node;
            tail = node;
        } else {
            Node node = head;
            // loop until the last node
            for ( ; node.next != null; node = node.next) {}
            Node tempNode = new Node(element, null, node);
            node.next = tempNode;
            tail = tempNode;
        }
        size++;
        return true;
    }

    @Override
    public void add(int index, E element) {
        if (index == 0){
            head = new Node(element, head, null);
        } else if(index == size){
            Node node = tail;
            Node tempNode = new Node(element, null, node);
            node.next = tempNode;
            tail = tempNode;
        } else {
            Node node = getNode(index-1);
            node.next = new Node(element, node.next, node);
        }
        size++;
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        boolean flag = true;
        for (E element: collection) {
            flag &= add(element);
        }
        return flag;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> collection) {
        for(E element : collection){
            add(index++, element);
        }
        return true;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        ArrayList<E> c1 = QuickSort.quickSort(this);
        ArrayList<Object> c2 = (ArrayList<Object>) QuickSort.quickSort(collection);
        for (Object obj: c2) {
            if (BinarySearch.binarySearch(c1, obj) == -1) {
                return false;
            }
        }
        return true;
    }

    @Override
    public E get(int index) {
        Node node = getNode(index);
        return node.data;
    }

    /** Returns the node at the given index.
     * @param index
     * @return
     */
    private Node getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node node = head;
        for (int i=0; i<index; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public int indexOf(Object target) {
        for(int i = 0; i<size; i++){
            if (target == null ? get(i) == null : target.equals(get(i))) {
                return i;
            }
        }
        return -1;
    }

    /** Checks whether an element of the array is the target.
     *
     * Handles the special case that the target is null.
     *
     * @param target
     * @param element
     */
    private boolean equals(Object target, Object element) {
        if (target == null) {
            return element == null;
        } else {
            return target.equals(element);
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        E[] array = (E[]) toArray();
        return Arrays.asList(array).iterator();
    }

    @Override
    public int lastIndexOf(Object target) {
        Node node = tail;
        for (int i = size; i > 0; i--) {
            if (equals(target, node.data.toString())) {
                return i-1;
            }
            node = node.previous;
        }
        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        E[] array = (E[]) toArray();
        return Arrays.asList(array).listIterator();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        E[] array = (E[]) toArray();
        return Arrays.asList(array).listIterator(index);
    }

    @Override
    public boolean remove(Object obj) {
        int index = indexOf(obj);
        if (index == -1) {
            return false;
        }
        remove(index);
        return true;
    }

    @Override
    public E remove(int index) {
        E element = get(index);
        if (index == 0){
            head = head.next;
        }else {
            Node node = getNode(index - 1);
            node.next = node.next.next;
        }
        size--;
        return element;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean flag = true;
        for (Object obj: collection) {
            flag &= remove(obj);
        }
        return flag;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        Objects.requireNonNull(collection);
        return collection.stream().allMatch(this::contains);
    }

    @Override
    public E set(int index, E element) {
        Node node = getNode(index);
        E old = node.data;
        node.data = element;
        return old;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex >= size || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException();
        }

        int i = 0;
        LinkedList<E> list = new LinkedList<E>();
        for (Node node=head; node != null; node = node.next) {
            if (i >= fromIndex && i <= toIndex) {
                list.add(node.data);
            }
            i++;
        }
        return list;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int i = 0;
        for (Node node=head; node != null; node = node.next) {
            // System.out.println(node);
            array[i] = node.data;
            i++;
        }
        return array;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }

}
