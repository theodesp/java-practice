package hackerrank.weekprep1;

import java.util.*;


/**
 * A queue is an abstract data type that maintains the order in which elements were added to it, allowing the oldest elements to be removed from the front and new elements to be added to the rear. This is called a First-In-First-Out (FIFO) data structure because the first element added to the queue (i.e., the one that has been waiting the longest) is always the first one to be removed.

A basic queue has the following operations:

Enqueue: add a new element to the end of the queue.
Dequeue: remove the element from the front of the queue and return it.
In this challenge, you must first implement a queue using two stacks. Then process  queries, where each query is one of the following  types:

1 x: Enqueue element  into the end of the queue.
2: Dequeue the element at the front of the queue.
3: Print the element at the front of the queue.
 */
public class QueueUsingStacks {
    private static class StackQueue<T> {
        
        private Stack<T> stack = new Stack<>(), auxStack = new Stack<>();
        
        void enqueue(T elem) {
            stack.push(elem);
        }
        
        T dequeue() {
            if (auxStack.isEmpty()) {
                if (stack.isEmpty()) {
                    System.out.println("Queue underflow");
                    return null;
                }
                while (!stack.isEmpty()) {
                    auxStack.push(stack.pop());
                }
            }
            return auxStack.pop();
        }
        
        T peek() {
            if (auxStack.isEmpty()) {
                if (stack.isEmpty()) {
                    System.out.println("Queue underflow");
                    return null;
                }
                while (!stack.isEmpty()) {
                    auxStack.push(stack.pop());
                }
            }
            return auxStack.peek();
        }
        
    }

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        scan.nextLine();    // Gets rid of the newline char
        List<String> queries = new ArrayList<>(q);
        
        // Query gathering
        for (int i = 0; i < q; i++) {
            queries.add(scan.nextLine());
        }
        scan.close();
        
        // Query handling
        int type, val;
        StackQueue<Integer> queue = new StackQueue<>();
        
        for (String query : queries) {
            type = query.charAt(0);
            if (type == '1') {
                val = Integer.parseInt(query.substring(2));
                queue.enqueue(val);
            }
            else if (type == '2') {
                queue.dequeue();
            }
            else {
                System.out.println(queue.peek());
            }
        }
    }
}
