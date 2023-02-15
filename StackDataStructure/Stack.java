package StackDataStructure;

public class Stack<T> {
    private int head = -1;
    private int maxSize;
    private Object[] data;

    public Stack(int maxSize){
        this.maxSize = maxSize;
        this.data = new Object[maxSize];
    }

    public Stack(int maxSize, T[] data){
        if(data.length > maxSize){
            throw new IndexOutOfBoundsException("Length of initial array exceeds the max size for the stack");
        }
        
        this.maxSize = maxSize;
        this.data = new Object[maxSize];
        for(int i = 0; i < data.length; i++){
            this.data[i] = data[i];
        }
        head = data.length - 1;
    }

    @SuppressWarnings("unchecked")
    public T pop(){
        // Case 1: The stack is empty
        if(head < 0){
            throw new IndexOutOfBoundsException("Stack is empty");
        }

        // Case 2: The stack is not empty
        T toReturn = (T) data[head];
        data[head] = null;
        head--;
        return toReturn;
    }

    public void push(T value){
        // Case 1: The array is full
        if(head + 1 == maxSize){
            throw new IndexOutOfBoundsException("Stack is full");
        }
        // Case 2: The array is not full
        head++;
        data[head] = value;
    }

    @SuppressWarnings("unchecked")
    public T peek(){
        // Case 1: The stack is empty
        if(head < 0){
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        // Case 2: The stack is not empty
        return (T) data[head + 1];
    }

    @Override
    @SuppressWarnings("unchecked")
    public String toString(){
        String output = "";
        for(T value: (T[]) data){
            if(value == null){
                output += "null, ";
            }
            else{
                output += value.toString() + ", ";
            }
        }
        return "[" + output.substring(0, output.length() - 2) + "]";
    }
}
