public class Node<T> {
    T value;
    Node<T> next;

    public Node(T value){
        this.value = value;
        this.next = null;
    }

    public void setNext(Node<T> next){
        this.next = next;
    }
}
