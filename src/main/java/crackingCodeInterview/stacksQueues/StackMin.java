package crackingCodeInterview.stacksQueues;

import java.util.*;

/**
 * How would you design a stack which, in addition to push and pop, has a function min which returns 
 * the minimum element? Push, pop and min should all operate in 0(1) time.
 */
public class StackMin <T extends Comparable<T>> {
    private ArrayList<T> data;
    private ArrayList<T> minStack;

    public StackMin() {
        data = new ArrayList<T>();
        minStack = new ArrayList<T>();
    }
    public void push(T item) {
        if (isEmpty() || min().compareTo(item) < 0) {
            minStack.add(item);
        } else {
            minStack.add(min());
        }
        data.add(item);
    }

    public T pop() {
        if (data.size() == 0) throw new EmptyStackException();
        minStack.remove(minStack.size()-1);
        return data.remove(data.size()-1);
    }
    
    public T peek() {
        if (data.size() == 0) throw new EmptyStackException();
        return data.get(data.size() - 1);
    }

    public boolean isEmpty() {
        return data.size() == 0;
    }

    public T min() {
        return minStack.get(0); 
    }
}
