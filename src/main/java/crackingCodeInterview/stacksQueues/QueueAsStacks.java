package crackingCodeInterview.stacksQueues;
import java.util.*;
/**
 * Implement a MyQueue class which implements a queue using two stacks.
 */
public class QueueAsStacks <T extends Comparable<T>> {
    private ArrayList<T> frontStack;
    private ArrayList<T> backStack;
    public static void main(String[] args) {
        var q  = new QueueAsStacks<Integer>();
        System.out.println(q.isEmpty());
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        System.out.println(q.isEmpty());
        System.out.println(q.peek());
        System.out.println(q.remove());
        System.out.println(q.peek());
    }

    public QueueAsStacks() {
        frontStack = new ArrayList<T>();
        backStack = new ArrayList<T>();
    }

    public void add(T item) {
        frontStack.add(item);
    }

    public T remove() {
        if (frontStack.size() == 0) {
            throw new EmptyStackException();
        }
        while (frontStack.size() > 0) {
            backStack.add(frontStack.remove(frontStack.size() - 1));
        }

        var result = backStack.remove(backStack.size() - 1);
        while (backStack.size() > 0) {
            frontStack.add(backStack.remove(backStack.size() - 1));
        }

        return result;
    }

    public T peek() {
        if (frontStack.size() == 0) {
            throw new EmptyStackException();
        }
        return frontStack.get(0);
    }

    public boolean isEmpty() {
        return frontStack.size() == 0 && backStack.size() == 0;
    }
   
}


