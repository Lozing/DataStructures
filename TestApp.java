import LinkedListDataStructure.LinkedList;

public class TestApp {
    public static void main(String[] args){
        LinkedList<Integer> l = new LinkedList<>();
        l.insertBeginning(2);
        System.out.println(l);
        l.insertEnd(3);
        System.out.println(l);
        l.insertAt(1, 1);
        System.out.println(l);
        l.insertAt(0, 0);
        System.out.println(l);
        l.insertAt(4, 4);
        System.out.println(l);
        l.insertAt(5, 10);
        l.insertAt(5, 10);
        System.out.println(l);
        l.delete(10);
        System.out.println(l + " No 10");
        l.insertAt(5, 10);
        l.insertAt(5, 10);
        l.deleteAll(10);
        System.out.println(l);

        for(Integer i: l){
            System.out.println(i);
        }
        l.reverse();
        System.out.println(l);
        System.out.println(l.getHead().value);
    }
}
