import java.util.Collection;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/**
* Dit is de Stack class,
* deze class is gebaseerd op het Last in First out principe
* When a stack is first created, it contains no items.
*/
public class Stack<E> {

    //De stack wordt opgeslagen in een linkedlist
    private LinkedList<E> stack;

    /**
     * Dit is de constructor voor de stack
     */
    public Stack(){
        stack = new LinkedList<>();
    }

    /**
    * Tests if this stack is empty.
    *
    * @return boolean true if and only if this stack contains no items; false otherwise.
    */
    public boolean empty() {
        return stack.isEmpty();
    }

    /**
     * Pushes an item onto the top of this stack.
     *
     * @param   E   item - the item to be pushed onto this stack
     * @return  E   the item argument.
     */
    public E push(E item){
        stack.add(0,item);
        return item;
    }

    /**
     * Removes the object at the top of this stack and returns that object as the value of this function.
     *
     * @return  E   The object at the top of this stack (the last item of the Vector object
     * @throws  EmptyStackException - if this stack is empty.
     */
    public E pop(){
        if(stack.isEmpty()){
            throw new EmptyStackException();
        }
        E temp = stack.get(0);
        stack.remove(0);
        return temp;
    }

    /**
     * Looks at the object at the top of this stack without removing it from the stack.
     *
     * @return  E   the object at the top of this stack
     * @throw   EmptyStackException - if this stack is empty.
     */
    public E peek(){
        if(stack.isEmpty()){
            throw new EmptyStackException();
        }
        E temp = stack.get(0);
        return temp;
    }

    /**
     * Returns the 1-based position where an object is on this stack.
     * If the object o occurs as an item in this stack, this method returns the distance from the top of the stack of the occurrence nearest the top of the stack; the topmost item on the stack is considered to be at distance 1.
     * The equals method is used to compare o to the items in this stack.
     *
     * @param  o    the desired object.
     * @return int  the 1-based position from the top of the stack where the object is located; the return value -1 indicates that the object is not on the stack.
     */
    public int search(Object o){
        int index = stack.indexOf(o);
        if(index == -1){
            return index;
        }
        return index + 1;
    }


    public void pushAll(Collection<? extends E> collection){
        for (E element: collection) {
            stack.add(0, element);
        }
    }

    /**
    * empties the stack
    *
    *
     */
    public void clear(){
        stack.clear();
    }

}
