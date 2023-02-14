import java.util.Iterator;

public class LinkedList<T> implements Iterable<T>{
    private Node<T> head;
    int count = 0;

    public LinkedList(){
        this.head = null;
    }

    public boolean isEmpty(){
        return count == 0 ? true:false;
    }

    public T get(int index){
        // Check that the index to return is in range
        if(index >= count){
            throw new ArrayIndexOutOfBoundsException();
        }

        // Case 1: The index points to the head
        if(index == 0){
            return head.value;
        }

        // Case 2: The index does not point to the head
        Node<T> pos = head;
        for(int i = 0; i < index; i++){
            pos = pos.getNext();
        }

        return pos.value;
    }

    public Node<T> getHead(){
        return this.head;
    }

    public void insertBeginning(T value){
        Node<T> n = new Node<T>(value);
        count++;

        // Case 1: The head is null
        if(head == null){
            head = n;
            return;
        }
        
        // Case 2: The head is not null
        n.setNext(head);
        head = n;
    }

    public void insertEnd(T value){
        Node<T> n = new Node<T>(value);
        count++;

        // Case 1: The head is null
        if(head == null){
            head = n;
        }

        // Case 2: The head is not null
        Node<T> end = head;
        while(end.getNext() != null){
            end = end.getNext();
        }

        end.setNext(n);
    }

    public void insertAt(int index, T value) throws ArrayIndexOutOfBoundsException {
        // Check that the index to insert into is valid
        if(index > count){
            throw new ArrayIndexOutOfBoundsException();
        }

        // Increment the count and create the new node
        count++;
        Node<T> n = new Node<T>(value);

        // Case 1: head is null
        if(head == null){
            head = n;
            return;
        }
        // Case 2: head is not null but index is 0
        else if(index == 0){
            n.setNext(head);
            head = n;
            return;
        }

        // Case 3: head is not null and index is not 0
        Node<T> pos = head;
        for(int i = 0; i < index - 1; i++){
            pos = pos.getNext();
        }

        Node<T> ahead = pos.getNext();
        pos.setNext(n);
        n.setNext(ahead);
    }

    public void delete(T value){
        // Case 1: There are no elements
        if(count == 0){
            return;
        }

        Node<T> end = head;

        // Case 2: The head is the only element and is the value
        if(head.value == value && count == 1){
            head = null;
            return;
        }
        // Case 3: The head is not the only element and is the value
        else if(head.value == value){
            head = head.getNext();
        }

        // Case 4: The head is not the only element and is not the value
        while(end.getNext() != null){
            if(end.getNext().value == value){
                end.setNext(end.getNext().getNext());
                count--;
                break;
            }
            end = end.getNext();
        }
    }

    public void deleteAll(T value){
        for(int i = 0; i < count; i++){
            this.delete(value);
        }
    }

    public void deleteAt(int index){
        // Check that the index to delete is valid
        if(index >= count){
            throw new ArrayIndexOutOfBoundsException();
        }

        // Case 1: The length is 1 and the head is being deleted
        if(count == 1 && index == 0){
            head = null;
            return;
        }
        // Case 2: The length is not 1 and the head is being deleted
        else if(index == 0){
            head = head.getNext();
            return;
        }
        
        Node<T> pos = head;
        for(int i = 0; i < index - 1; i++){
            pos = pos.getNext();
        }
        // Case 3: The length is not 1 and the last element is being deleted
        if(index + 1 == count){
            pos.setNext(null);
        }
        // Case 4: The length is not 1 and the last element is not the one being deleted
        else{
            pos.setNext(pos.getNext().getNext());
        }

    }

    public void reset(){
        head = null;
    }

    public String toString(){
        String output = "[";
        Node<T> end = head;
        while(end != null){
            if(head != end){
                output += ", ";
            }
            output += end.value.toString();
            end = end.getNext();
        }
        output += "]";
        return output;
    }

    public void reverse(){
        Node<T> prev = null;
        Node<T> current = head;
        Node<T> next = null;

        while(current != null){
            // Store the next value
            next = current.getNext();
            // Set the next value of the current node to the previous one
            current.setNext(prev);
            // Move forward a node
            prev = current;
            current = next;
        }

        // Update the head
        head = prev;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedIterator<>(this);
    }
}