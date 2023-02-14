public class LinkedList<T>{
    Node<T> head;

    public LinkedList(){
        this.head = null;
    }

    public boolean isEmpty(){
        return head == null ? true:false;
    }

    public void insertBeginning(T value){
        Node<T> n = new Node<T>(value);
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
        // Case 1: The head is null
        if(head == null){
            head = n;
        }

        // Case 2: The head is not null
        Node<T> end = head;
        while(end != null || end.getNext() != null){
            end = end.getNext();
        }

        end.setNext(n);
    }

    public void insertAt(int index, T value){

    }

    public void delete(T value){

    }

    public void deleteAll(T value){

    }

    public void deleteAt(int index, T value){

    }

    public void reset(){

    }
}