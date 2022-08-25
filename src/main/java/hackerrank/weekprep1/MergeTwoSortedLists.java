package hackerrank.weekprep1;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * Given pointers to the heads of two sorted linked lists, merge them into a single, sorted linked list. 
 * Either head pointer may be null meaning that the corresponding list is empty.
 */
public class MergeTwoSortedLists {
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep) throws IOException {
        while (node != null) {
            System.out.print(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                System.out.print(sep);
            }
        }
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int tests = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int testsItr = 0; testsItr < tests; testsItr++) {
            SinglyLinkedList llist1 = new SinglyLinkedList();

            int llist1Count = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llist1Count; i++) {
                int llist1Item = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist1.insertNode(llist1Item);
            }
          
          	SinglyLinkedList llist2 = new SinglyLinkedList();

            int llist2Count = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llist2Count; i++) {
                int llist2Item = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist2.insertNode(llist2Item);
            }
            printSinglyLinkedList(llist1.head, " ");
            printSinglyLinkedList(llist2.head, " ");
            SinglyLinkedListNode llist3 = mergeLists(llist1.head, llist2.head);

            printSinglyLinkedList(llist3, " ");
        }

        scanner.close();
    }

    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedList temp = new SinglyLinkedList();
        while(head1.next != null && head2.next != null) {
            if (head1.data < head2.data) {
                temp.insertNode(head1.data);
                head1 = head1.next;
            } else {
                temp.insertNode(head2.data);
                head2 = head2.next;
            }
        }
        while(head1 != null){
            temp.insertNode(head1.data);
            head1 = head1.next;
        }
        while(head2 != null){
            temp.insertNode(head2.data);
            head2 = head2.next;
        }
        return temp.head;
    }

}
