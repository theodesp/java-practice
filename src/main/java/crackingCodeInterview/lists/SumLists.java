package crackingCodeInterview.lists;

/**
 * You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in reverse order, such that the 1's digit is at the head of the list. 
 * Write a function that adds the two numbers and returns the sum as a linked list.
 * 
 * Ilnput:(7-> 1 -> 6) + (5 -> 9 -> 2).That is,617 + 295. Output: 2 -> 1 -> 9. That is, 912.
 */
public class SumLists {
    public static void main(String[] args) {
        var a = new Node(7);
        a.next = new Node(1);
        a.next.next = new Node(6);
        var b = new Node(5);
        a.next = new Node(9);
        a.next.next = new Node(2);
        var list = sumLists(a, b);
        list.print();
    }

    public static Node sumLists(Node l1, Node l2) {
        Node l3 = new Node(-1);
        Node temp = l3;
        int carry = 0;
        while( l1 != null || l2 != null || carry == 1){
            int sum = 0;
            if(l1 != null){
                sum += l1.data;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.data;
                l2 = l2.next;
            }
            sum += carry;
            carry = sum/10;
            Node node = new Node(sum % 10);
            temp.next = node;
            temp = temp.next;
        }
        return l3.next;
    }
}
