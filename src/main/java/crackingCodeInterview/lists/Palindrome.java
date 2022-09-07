package crackingCodeInterview.lists;

import java.util.*;

/**
 * Implement a function to check if a linked list is a palindrome.
 * 
 * Reverse linked list and check if equal with original
 */
public class Palindrome {
    public static void main(String[] args) {
        var list = new Node(1);
        list.next = new Node(2);
        list.next.next = new Node(3);
        list.next.next.next = new Node(4);
        list.next.next.next.next = new Node(3);
        list.next.next.next.next.next = new Node(2);
        list.next.next.next.next.next.next = new Node(1);
        System.out.println(palindrome(list));
    }

    static boolean palindrome(Node list) {
        return compareLists(list, reverse(list));
    }

    static Node reverse(Node list) {
        var st = new Stack<Integer>();
        Node curr = list;
        while (curr != null) {
            st.push(curr.data);
            curr = curr.next;
        }
        Node temp = new Node(-1);
        Node res = temp;
        while (st.isEmpty() == false) {
            temp.next = new Node(st.pop());
            temp = temp.next;
        }
        return res.next;
    }

    static Node reverseAndClone(Node node) { 
        Node head= null;
        while (node!=null) {
            var n = new Node(node.data);
            n.next = head;
            head = n;
            node = node.next;
        }
        return head;
    }

    static boolean compareLists(Node head1, Node head2) {
        Node temp1 = head1;
        Node temp2 = head2;

        while (temp1 != null && temp2 != null) {
            if (temp1.data == temp2.data) {
                temp1 = temp1.next;
                temp2 = temp2.next;
            } else
                return false;
        }

        return temp1 == null && temp2 == null;
    }

}
