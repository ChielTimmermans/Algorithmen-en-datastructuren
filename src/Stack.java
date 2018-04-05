import java.util.Collection;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class Stack<E> {

        private LinkedList<E> list;

        public Stack(){
            list = new LinkedList<>();
        }

        public boolean empty() {
            return list.isEmpty();
        }

        public E push(E item){
            list.add(0,item);
            return item;
        }

        public E pop(){
            if(list.isEmpty()){
                throw new EmptyStackException();
            }
            E temp = list.get(0);
            list.remove(0);
            return temp;
        }

        public E peek(){
            if(list.isEmpty()){
                throw new EmptyStackException();
            }
            E temp = list.get(0);
            return temp;
        }

        public int search(Object o){
            int index = list.indexOf(o);
            if(index == -1){
                return index;
            }
            return index + 1;
        }

}
