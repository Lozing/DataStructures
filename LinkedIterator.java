import java.util.Iterator;

public class LinkedIterator<T> implements Iterator<T>{
    Node<T> current;

    public LinkedIterator(LinkedList<T> list){
        current = list.getHead();
    }
    @Override
    public boolean hasNext() {
        if(current != null){
            return true;
        }
        return false;
    }

    @Override
    public T next() {
        T data = current.value;
        current = current.getNext();
        return data;
    }
    
}
