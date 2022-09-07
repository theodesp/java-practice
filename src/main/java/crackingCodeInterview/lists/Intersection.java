package crackingCodeInterview.lists;

import java.util.HashSet;

/**
 * Given two (singly) linked lists, determine if the two lists intersect. 
 * Return the inter- secting node. Note that the intersection is defined based on reference, 
 * not value. That is, if the kth node of the first linked list is the exact same node (by reference) 
 * as the jth node of the second linked list, then they are intersecting.
 */
public class Intersection {
    public static void main(String[] args) {
        var a = new Node(1);
        a.next = new Node(2);
        a.next.next = new Node(3);
        a.next.next.next = new Node(4);
        a.next.next.next.next = new Node(5);
        var b = new Node(10);
        b.next = new Node(9);
        b.next.next = new Node(8);
        b.next.next.next = new Node(5);
        b.next.next.next.next = a.next.next.next;
        System.out.println(intersect(a, b));
        System.out.println(intersectTwoPointers(a, b));
    }

    public static boolean intersect(Node a, Node b) {
        var seen = new HashSet<Node>();
        var curr = a;
        while (curr.next != null) {
            seen.add(curr);
            curr = curr.next;
        }
        curr = b;
        while (curr.next != null) {
            if (seen.contains(curr)) {
                return true;
            }
            curr = curr.next;
            
        }
        return false;
    }

    public static Node intersectTwoPointers(Node a, Node b) {
        var pointerA = a;
        var pointerB = b;
        while(pointerA != pointerB) {
            // pointerA reaches the end of a list, then redirect it to b
            pointerA = pointerA == null ? b : pointerA.next;
            // pointerB reaches the end of b list, then redirect it to a
            pointerB = pointerB == null ? a : pointerB.next;
        }
        return pointerA;
    }
}
