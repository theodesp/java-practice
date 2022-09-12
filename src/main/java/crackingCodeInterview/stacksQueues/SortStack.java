package crackingCodeInterview.stacksQueues;

import java.util.*;
/**
 * Write a program to sort a stack such that the smallest items are on the top. 
 * You can use an additional temporary stack, 
 * but you may not copy the elements into any other data structure (such as an array).
 */
public class SortStack  <T extends Comparable<T>>{
    private ArrayList<T> data;
    private ArrayList<T> temp;

    public SortStack() {
        data = new ArrayList<T>();
        temp = new ArrayList<T>();
    }

    public static void main(String[] args) {
        var s = new SortStack<Integer>();
        s.push(3);
        s.push(2);
        s.push(1);
        s.push(-2);
        s.push(4);
        System.out.println(s.pop());
    }

    public void push(T item) {
        if (data.size() == 0) {
            data.add(item);
        } else {
            // New item is smaller that top
            if (data.get(data.size() - 1).compareTo(item) > 0) {
                data.add(item);
            }
            // New item is larger that top. Need to push to right position using temp stack.
            else {
                while(data.size() > 0) {
                    var top = data.remove(data.size() - 1);
                    if (top.compareTo(item) > 0) {// 2 < 4
                        data.add(item);
                    } else {
                        temp.add(top);
                    }
                    if (data.size() == 0) {
                        data.add(item);
                        break;
                    }
                }
                // restore order
                while(temp.size() > 0) {
                    data.add(temp.remove(temp.size()-1));
                }
            }
        }
    }

    public T pop() {
        if (data.size() == 0) throw new EmptyStackException();
    
        return data.remove(data.size()-1);
    }
    
    public T peek() {
        if (data.size() == 0) throw new EmptyStackException();
        return data.get(data.size() - 1);
    }

    public boolean isEmpty() {
        return data.size() == 0;
    }
}
