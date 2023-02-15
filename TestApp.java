import StackDataStructure.*;;

public class TestApp {
    public static void main(String[] args){
        Stack<Integer> s = new Stack<>(5, new Integer[] {2, 4});
        System.out.println(s);
        s.push(3);
        System.out.println(s);
        s.push(3);
        System.out.println(s);
        s.push(3);
        System.out.println(s);
        System.out.println(s.pop());
        System.out.println(s);
    }
}
