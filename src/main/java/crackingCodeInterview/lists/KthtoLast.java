package crackingCodeInterview.lists;

/**
 * Implement an algorithm to find the kth to last element of a singly linked list.
 */
public class KthtoLast {
    public static void main(String[] args) {
        var list = new Node(10);
        list.next = new Node(5);
        list.next.next = new Node(7);
        list.next.next.next = new Node(3);
        list.next.next.next.next = new Node(7);
        list.next.next.next.next.next = new Node(5);
        list.next.next.next.next.next.next = new Node(3);
        var res = kthToLast(list, 4);
        System.out.println(res);
    }

    public static int kthToLast(Node head, int k) {
        var slow = head;
        var fast = head;
        var i = 0;
        while (fast.next != null && i < k) {
            fast = fast.next;
            i +=1;
        }
        if (i != k) {
            return 0;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow.data;
    }
}
