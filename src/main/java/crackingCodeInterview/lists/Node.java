package crackingCodeInterview.lists;

public class Node {
    Node next = null;
    int data;

    public Node(int d) {
        data = d;
    }

    void appendToTail(int d) {
        Node end = new Node(d);
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    Node deleteNode(Node head, int d) {
        var n = head;
        if (n.data == d) {
            return head.next;
        }

        while (n.next != null) {
            if (n.data == d) {
                // delete node
                n.next = n.next.next;
                return head;
            }
            // traverse to next node
            n = n.next;
        }
        return head;
    }

    public void print() {
        var curr = this;
        while(curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }
}
