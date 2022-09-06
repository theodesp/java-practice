package crackingCodeInterview.lists;

/**
 * Implement an algorithm to delete a node in the middle (i.e., any node but the first and last node, 
 * not necessarily the exact middle) of a singly linked list, given only access to that node.
 * 
 * Input: the nodec from the linked list a->b->c->d->e->f
Result: nothing is returned, but the new linked list looks like a->b->d->e->f
 */
public class DeleteMiddleNode {
    public static void main(String[] args) {
        var list = new Node(10);
        list.next = new Node(5);
        list.next.next = new Node(7);
        list.next.next.next = new Node(3);
        list.next.next.next.next = new Node(7);
        list.next.next.next.next.next = new Node(5);
        list.next.next.next.next.next.next = new Node(3);
        deleteMiddleNode(list.next.next.next);
        list.print();
    }

    public static void deleteMiddleNode(Node node) {
        if (node == null || node.next == null) {
            return;
        }
        var next = node.next;
        node.data= next.data;
        node.next= next.next;
    }
}
