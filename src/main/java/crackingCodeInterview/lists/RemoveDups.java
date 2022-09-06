package crackingCodeInterview.lists;

import java.util.HashSet;

/**
 * Write code to remove duplicates from an unsorted linked list.
 */
public class RemoveDups {
    public static void main(String[] args) {
        var list = new Node(10);
        list.next = new Node(5);
        list.next.next = new Node(7);
        list.next.next.next = new Node(3);
        list.next.next.next.next = new Node(7);
        list.next.next.next.next.next = new Node(5);
        list.next.next.next.next.next.next = new Node(3);
        var res = removedDuplicates(list);
        print(res);
    }

    public static Node removedDuplicates(Node head) {
        // current and previous node
        Node temp = head, prev = null;
        var seen = new HashSet<Integer>();
        while(temp != null) {
            if (seen.contains(temp.data)) {
                prev.next = temp.next;
            } else {
                seen.add(temp.data);
                prev = temp;
            }
            temp = temp.next;
        }

        return head;
    }


    public static void print(Node head) {
        var curr = head;
        while(curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }
}
