package crackingCodeInterview.stacksQueues;
import java.util.*;

/**
 * 
 * Imolement a datastructure Set Of Stacks that mimics this.set o-fstacks shouldbe composed of 
 * severa\ stacks and shou\d create a new stack once the prev·1ous one exceeds capacity.
Set0fStacks .push() and Set0fStacks. pop() should behave identically to a single stack 
(that is, pop () should return the same values as it would if there were just a single stack).
 */
public class StackPlates <T> {
    private ArrayList<ArrayList<T>> data;
    private int currentStack = -1;
    private int size;

    public StackPlates(int size) {
        data = new ArrayList<ArrayList<T>>();
        data.add(new ArrayList<T>(size));
        currentStack = 0;
        this.size=size;
    }

    public void push(T item) {
        var current = data.get(currentStack);
        // we've reached the limit of the current stack
        if (current.size() == size) {
            if (currentStack+1 < data.size()) {
                currentStack++;
            } else {
                data.add(new ArrayList<T>());
                currentStack++;
            }
        }
        data.get(currentStack).add(item);
    }

    public T pop() {
        if (isEmpty()) {throw new EmptyStackException();}
        var current = data.get(currentStack);
        if (current.size() == 1) {
            var ret = current.remove(0);
            currentStack--;
            return ret;
        } else {
            return current.remove(current.size() - 1);
        }
    }

    public T peek() {
        if (isEmpty()) {throw new EmptyStackException();}
        var current = data.get(currentStack);
        return current.get(current.size() - 1);
    }

    public boolean isEmpty() {
        return currentStack == 0 && data.get(currentStack).size() == 0;
    }

    public static void main(String[] args) {
        var s = new StackPlates<Integer>(2);
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println( s.pop());
        s.push(8);
        s.push(5);
        System.out.println( s.pop());
        System.out.println( s.pop());
    }
}
