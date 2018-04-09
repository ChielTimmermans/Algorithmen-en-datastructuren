import java.util.*;

/**
 * Dit is de LinkedListTest class,
 * 
 *
 * @author  Michael van Dijk, Henk van Maanen, Frank Tieck, Chiel Timmermans
 * @version 05042018
 */

public class LinkedList<E> implements List<E> {

    private class Node {
        E data;
        Node next;

        Node(E data) {
            this.data = data;
            this.next = null;
        }
        @SuppressWarnings("unused")
        Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }
        public String toString() {
            return "Node(" + data.toString() + ")";
        }
    }

    private int size;            // keeps track of the number of elements
    private Node head;           // reference to the first node

    /**
     *
     */
    LinkedList() {
        head = null;
        size = 0;
    }

    /**
     * Appends the specified element to the end of this list
     *
     * @param   element     element to be appended to this list
     * @return  true
     */
    @Override
    public boolean add(E element) {
        if (head == null) {
            head = new Node(element);
        } else {
            Node node = head;
            // loop until the last node
            while (node.next != null)  node = node.next;

            node.next = new Node(element);
        }
        size++;
        return true;
    }

    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices).
     *
     * @param index     index at which the specified element is to be inserted
     * @param element   element to be inserted
     * @throw IndexOutOfBoundsException - if the index is out of range
     */
    @Override
    public void add(int index, E element) {
        if(index >= 0 || index <= size){
            if (index == 0){
                head = new Node(element, head);
            } else {
                Node node = getNode(index-1);
                node.next = new Node(element, node.next);
            }
            size++;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Appends all of the elements in the specified collection to the end of this list,
     * in the order that they are returned by the specified collection's iterator.
     * The behavior of this operation is undefined if the specified collection is modified
     * while the operation is in progress.
     *
     * @param   collection  collection containing elements to be added to this list
     * @return  true if this list changed as a result of the call
     * @throw   NullPointerException - if the specified collection is null
     */
    @Override
    public boolean addAll(Collection<? extends E> collection) {
        boolean flag = true;
        if(collection == null){
            throw new NullPointerException();
        }
        for (E element: collection) {
            flag &= add(element);
        }
        return flag;
    }

    /**
     * Inserts all of the elements in the specified collection into this list,
     * starting at the specified position. Shifts the element currently at that
     * position (if any) and any subsequent elements to the right (increases their indices).
     * The new elements will appear in the list in the order that they are returned by the
     * specified collection's iterator.
     *
     * @param   index       index at which to insert the first element from the specified collection.
     * @param   collection  collection containing elements to be added to this list.
     * @return  true if this list changed as a result of the call
     * @throw   IndexOutOfBoundsException - if the index is out of range
     *          NullPointerException - if the specified collection is null
     */
    @Override
    public boolean addAll(int index, Collection<? extends E> collection) {
        if(collection == null){
            throw new NullPointerException();
        }
        if(index < 0 || index > size()){
            throw new IndexOutOfBoundsException();
        }
        for(E element : collection){
            add(index++, element);
        }
        return true;
    }

    /**
     * Removes all of the elements from this list. The list will be empty after this call returns.
     */
    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    /**
     * Returns true if this list contains the specified element. More formally,
     * returns true if and only if this list contains at least one element e such that
     * @param   obj     element whose presence in this list is to be tested
     * @return  true if this list contains the specified element
     */
    @Override
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    /**
     * Returns true if this list contains all of the elements of the specified collection.
     *
     * @param collection    collection to be checked for containment in this list
     * @return true if this list contains all of the elements of the specified collection
     * @throw NullPointerException - if the specified collection contains one or more null elements and this list does not permit null elements (optional),
     *                               or if the specified collection is null
     */
    @Override
    public boolean containsAll(Collection<?> collection) {
        if(collection == null) {
            throw new NullPointerException();
        }
    	ArrayList<E> c1 = QuickSort.quickSort(this);
    	ArrayList<Object> c2 = (ArrayList<Object>) QuickSort.quickSort(collection);
        for (Object obj: c2) {
            if (BinarySearch.binarySearch(c1, obj) == -1) {
                return false;
            }
        }
        return true;
    }

    /** Checks whether an element of the array is the target.
     *
     * Handles the special case that the target is null.
     *
     * @param   target  target object
     * @param   element element object
     * @return  element return true if equals.
     */
    private boolean equals(Object target, Object element) {
        if (target == null) {
            return element == null;
        } else {
            return target.equals(element);
        }
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param   index    index of the element to return
     * @return  the element at the specified position in this list
     * @throw   IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public E get(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        Node node = getNode(index);
        return node.data;
    }

    /**
     * Returns the node at the given index.
     *
     * @param index index of the node to return
     * @return the element at the specified position in this list
     * @throw IndexOutOfBoundsException if the index is out of range
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

    /**
     * Returns the index of the first occurrence of the specified element in this list,
     * or -1 if this list does not contain the element. More formally,
     * returns the lowest index i such that
     * (o==null ? get(i)==null : o.equals(get(i))), or -1 if there is no such index.
     *
     * @param   target      element to search for
     * @return  the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element
     */
    @Override
    public int indexOf(Object target) {
        for(int i = 0; i<size; i++){
            if (target == null ? get(i) == null : target.equals(get(i))) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns true if this list contains no elements
     *
     * @return true if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns an iterator over the elements in this list in proper sequence.
     *
     * @return an iterator over the elements in this list in proper sequence
     */
    @Override
    public Iterator<E> iterator() {
        E[] array = (E[]) toArray();
        return Arrays.asList(array).iterator();
    }

    /**
     * Returns the index of the last occurrence of the specified element in this list,
     * or -1 if this list does not contain the element. More formally,
     * returns the highest index i such that
     * (o==null ? get(i)==null : o.equals(get(i))), or -1 if there is no such index.
     *
     * @param   target element to search for
     * @return  the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element
     */
    @Override
    public int lastIndexOf(Object target) {
        Node node = head;
        int index = -1;
        for (int i=0; i<size; i++) {
            if (equals(target, node.data.toString())) {
                index = i;
            }
            node = node.next;
        }
        return index;
    }


    @Override
    public ListIterator<E> listIterator() {
    	E[] array = (E[]) toArray();
        return Arrays.asList(array).listIterator();
    }

    /**
     * Returns a list-iterator of the elements in this list (in proper sequence),
     * starting at the specified position in the list.
     * Obeys the general contract of List.listIterator(int).
     *
     * @param index     index of the first element to be returned from the list-iterator (by a call to next)
     * @return a ListIterator of the elements in this list (in proper sequence), starting at the specified position in the list
     * @throw IndexOutOfBoundsException - if the index is out of range
     */
    @Override
    public ListIterator<E> listIterator(int index) {
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
    	E[] array = (E[]) toArray();
        return Arrays.asList(array).listIterator(index);
    }

    /**
     * Removes the element at the specified position in this list.
     * Shifts any subsequent elements to the left (subtracts one from their indices).
     * Returns the element that was removed from the list.
     *
     * @param   index   the index of the element to be removed
     * @return  the element previously at the specified position
     * @throw   IndexOutOfBoundsException - if the index is out of range
     */
    @Override
    public E remove(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
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

    /**
     * Removes the first occurrence of the specified element from this list, if it is present.
     * If this list does not contain the element, it is unchanged. More formally,
     * removes the element with the lowest index i such that
     * (o==null ? get(i)==null : o.equals(get(i))) (if such an element exists).
     *
     * Returns true if this list contained the specified element (or equivalently,
     * if this list changed as a result of the call).
     *
     * @param   obj     element to be removed from this list, if present
     * @return  true    if this list contained the specified element
     */
    @Override
    public boolean remove(Object obj) {
        int index = indexOf(obj);
        if (index == -1) {
            return false;
        }
        remove(index);
        return true;
    }

    /**
     * Removes from this list all of its elements that are contained in the specified collection (optional operation).
     *
     * @param   collection    collection containing elements to be removed from this list
     * @return  collection containing elements to be removed from this list
     * @throw   NullPointerException - if this list contains a null element and the specified collection does not permit null elements (optional),
     *                                  or if the specified collection is null
     */
    @Override
    public boolean removeAll(Collection<?> collection) {
        if(collection == null){
            throw new NullPointerException();
        }
        boolean flag = true;
        for (Object obj: collection) {
            flag &= remove(obj);
        }
        return flag;
    }

    /**
     * Retains only the elements in this list that are contained in the specified collection (optional operation).
     * In other words, removes from this list all of its elements that are not contained in the specified collection.
     *
     * @param   collection  collection containing elements to be retained in this list
     * @return  true if this list changed as a result of the call
     * @throw   NullPointerException - if this list contains a null element and the specified collection does not permit null elements (optional),
     *                                  or if the specified collection is null
     */
    @Override
    public boolean retainAll(Collection<?> collection) {
        if(collection == null){
            throw new NullPointerException();
        }
        Objects.requireNonNull(collection);
        return collection.stream().allMatch(this::contains);
    }

    /**
     * Replaces the element at the specified position in this list with the specified element.
     *
     * @param   index     index of the element to replace
     * @param   element   element to be stored at the specified position
     * @return  the element previously at the specified position
     * @throw   IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
     */
    @Override
    public E set(int index, E element) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        Node node = getNode(index);
        E old = node.data;
        node.data = element;
        return old;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns a view of the portion of this list between the specified fromIndex, inclusive, and toIndex, exclusive.
     * (If fromIndex and toIndex are equal, the returned list is empty.) The returned list is backed by this list,
     * so non-structural changes in the returned list are reflected in this list, and vice-versa.
     * The returned list supports all of the optional list operations supported by this list.
     *
     * @param   fromIndex   low endpoint (inclusive) of the subList
     * @param   toIndex     high endpoint (exclusive) of the subList
     * @return  a view of the specified range within this list
     * @throw   IndexOutOfBoundsException - for an illegal endpoint index value (fromIndex < 0 || toIndex > size || fromIndex > toIndex)
     */
    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex >= size || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException();
        }

        int i = 0;
        LinkedList<E> list = new LinkedList<>();
        for (Node node=head; node != null; node = node.next) {
            if (i >= fromIndex && i <= toIndex) {
                list.add(node.data);
            }
            i++;
        }
        return list;
    }

    /**
     * Returns an array containing all of the elements in this list in proper sequence (from first to last element).
     *
     * @return an array containing all of the elements in this list in proper sequence
     */
    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int i = 0;
        for (Node node=head; node != null; node = node.next) {
            array[i] = node.data;
            i++;
        }
        return array;
    }

    /**
     * Returns an array containing all of the elements in this list in proper sequence (from first to last element);
     * the runtime type of the returned array is that of the specified array. If the list fits in the specified array,
     * it is returned therein. Otherwise, a new array is allocated with the runtime type of the specified array and the size of this list.
     *
     * @param a     the array into which the elements of the list are to be stored, if it is big enough; otherwise, a new array of the same runtime type is allocated for this purpose.
     * @return      an array containing the elements of the list
     */
    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size)
            a = (T[])java.lang.reflect.Array.newInstance(
                    a.getClass().getComponentType(), size);
        int i = 0;
        Object[] result = a;
        for (Node node = head; node != null; node = node.next)
            result[i++] = node.data;

        if (a.length > size)
        a[size] = null;

        return a;
    }
}

