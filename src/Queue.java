import java.util.Collection;
import java.util.NoSuchElementException;

public class Queue<E> {

    private LinkedList<E> list;

    public Queue(){
         list = new LinkedList<>();
    }


    public boolean add(E e){
        if(!list.add(e)){
            throw new IllegalStateException("Cannot add element to Queue");
        }
        return true;
    }

    public E element(){
        if (list.isEmpty()){
            throw new NoSuchElementException("Queue is empty");
        }
        return list.get(0);

    }

    public boolean offer(E e){
        return list.add(e);
    }

    public E peek(){
        if (list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    public E poll(){
        if (list.isEmpty()){
            return null;
        }
        E temp = list.get(0);
        list.remove(0);
        return temp;
    }

    public E remove(){
        if (list.isEmpty()){
            throw new NoSuchElementException("Queue is empty");
        }
        E temp = list.get(0);
        list.remove(0);
        return temp;
    }

    public boolean addAll(Collection<? extends E> collection) {
        boolean flag = true;
        for (E element: collection) {
            flag &= list.add(element);
        }
        return flag;
    }
}
