import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * Dit is de Queue class,
 * deze class is gebaseerd op het First in First out principe
 * When a queue is first created, it contains no items.
 *
 * @author  Michael van Dijk, Henk van Maanen, Frank Tieck, Chiel Timmermans
 * @version 05042018
 */
public class Queue<E> {

    //De queue wordt opgeslagen in een linkedlist
    private LinkedList<E> queue;

    /**
     * Dit is de constructor voor de queue
     */
    Queue(){
        queue = new LinkedList<>();
    }

    /**
     * Inserts the specified element into this queue
     * if it is possible to do so immediately without violating capacity restrictions,
     * returning true upon success and throwing an IllegalStateException if no space is currently available.
     *
     * @param   e   the element to add
     * @return  true
     * @throw   IllegalStateException - if the element cannot be added at this time due to capacity restrictions
     *
     */
    public boolean add(E e){
        if(!queue.add(e)){
            throw new IllegalStateException("Cannot add element to Queue");
        }
        return true;
    }

    /**
     * Retrieves, but does not remove, the head of this queue.
     * This method differs from peek only in that it throws an exception if this queue is empty.
     *
     * @return  the head of this queue
     * @throw   NoSuchElementException - if this queue is empty
     */
    public E element(){
        if (queue.isEmpty()){
            throw new NoSuchElementException("Queue is empty");
        }
        return queue.get(0);

    }

    /**
     * Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions.
     * When using a capacity-restricted queue, this method is generally preferable to add(E),
     * which can fail to insert an element only by throwing an exception.
     *
     * @param   e   the element to add
     * @return  true if the element was added to this queue, else false
     * @throw   IllegalArgumentException - if some property of this element prevents it from being added to this queue
     */

    public boolean offer(E e){
        return queue.add(e);
    }

    /**
     * Retrieves, but does not remove, the head of this queue,
     * or returns null if this queue is empty.
     *
     * @return the head of this queue, or null if this queue is empty
     */
    public E peek(){
        if (queue.isEmpty()){
            return null;
        }
        return queue.get(0);
    }

    /**
     * Retrieves and removes the head of this queue, or returns null if this queue is empty.
     *
     * @return the head of this queue, or null if this queue is empty
     */
    public E poll(){
        if (queue.isEmpty()){
            return null;
        }
        E temp = queue.get(0);
        queue.remove(0);
        return temp;
    }

    /**
     * Retrieves, but does not remove, the head of this queue.
     * This method differs from peek only in that it throws an exception if this queue is empty.
     *
     * @return the head of this queue
     * @throw  NoSuchElementException - if this queue is empty
     */
    public E remove(){
        if (queue.isEmpty()){
            throw new NoSuchElementException("Queue is empty");
        }
        E temp = queue.get(0);
        queue.remove(0);
        return temp;
    }

    /**
     * Adds all objects from the collection to the queue using the add() function
     *
     * @param collection the collection that needs to be add to the queue
     * @return  true
     * @throw   IllegalStateException - if the element cannot be added at this time due to capacity restrictions
     */
    public boolean addAll(Collection<? extends E> collection) {
        boolean flag = true;
        for (E element: collection) {
            flag &= queue.add(element);
        }
        return flag;
    }

    /**
     * clears the queue from it's elements
     */
    public void clear(){
        queue.clear();
    }
}
