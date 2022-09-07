package crackingCodeInterview.lists;

import org.checkerframework.checker.units.qual.A;

/**
 * 
Loop Detection: Given a circular linked list, implement an algorithm that 
returns the node at the beginning of the loop.
 */
public class LoopDetection {
    public static void main(String[] args) {
        var a = new Node(1);
        a.next = new Node(2);
        a.next.next = new Node(3);
        a.next.next.next = new Node(4);
        a.next.next.next.next = new Node(5);
        a.next.next.next.next.next = a.next.next.next;
        System.out.println(loop(a));
    }

    static Node loop(Node a) {
        var slow = a;
        var fast = a;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow==fast) {
                break;
            }
        }
        if (fast== null || fast.next== null) {
            return null;
        }

        /* Move slow to Head. Keep fast at Meeting Point. Each are k steps from the
        /* Loop Start. If they move at the same pace, they must meet at Loop Start. */
        slow = a;
        while (slow!= fast) {
            slow= slow.next;
            fast=fast.next;
        }
        /* Both now point to the start of the loop.*/
        return fast;
    }
}
