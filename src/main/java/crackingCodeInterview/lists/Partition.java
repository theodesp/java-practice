package crackingCodeInterview.lists;

/**
 * Write code to partition a linked list around a value x, 
 * such that all nodes less than x come before all nodes greater than or equal to x. 
 * If xis contained within the list, the values of x only need to be after the elements less than 
 * x (see below). The partition element x can appear anywhere in the "right partition"; 
 * it does not need to appear between the left and right partitions.
 * 
 *  Input: 3-> 5 -> 8 -> 5 -> 10 -> 2 -> 1[partition=5]
 * 
 *  Output: 3-> 1 -> 2 -> 10 -> 5 -> 5 -> 8
 */
public class Partition {
    public static void main(String[] args) {
        var list = new Node(3);
        list.next = new Node(5);
        list.next.next = new Node(8);
        list.next.next.next = new Node(5);
        list.next.next.next.next = new Node(10);
        list.next.next.next.next.next = new Node(2);
        list.next.next.next.next.next.next = new Node(1);
        var res = partition(list, 5);
        res.print();
    }

    public static Node partition(Node head, int x) {
        Node less = new Node(0);
		Node greater = new Node(0);
		Node l1 = less;
		Node l2 = greater;
		while (head != null) {
			if (head.data < x) {
				l1.next = head;
				l1 = head;
			} else {
				l2.next = head;
				l2 = head;
			}
			head = head.next;
		}
		// make sure there is no cycle.
		// 3->4->1->2. 4->2 change to 4->null
		l2.next = null;
		l1.next = greater.next;
		return less.next;
    }
}
