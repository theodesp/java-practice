package leetcode.top100;

/**
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order, and each of their nodes
 * contains a single digit. Add the two numbers and return the sum as a linked
 * list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * 
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * 
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 */
public class AddTwoNumbers {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        var l = new ListNode(2);
        l.next = new ListNode(4);
        l.next.next = new ListNode(5);

        var r = new ListNode(5);
        r.next = new ListNode(6);
        r.next.next = new ListNode(5);
        r.next.next.next = new ListNode(9);
        r.next.next.next.next = new ListNode(2);
        var res = addTwoNumbers(l, r);
        System.out.println(res);
    }

    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        var temp = new ListNode();
        var res = temp;
        int carry = 0;
        while(l1 != null && l2 != null) {
            var total = l1.val + l2.val + carry;
            carry = total >= 10 ? 1 : 0;
            temp.next = new ListNode(total % 10);
            temp = temp.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while( l1 != null) {
            var total = l1.val + carry;
            carry = total >= 10 ? 1 : 0;
            temp.next = new ListNode(total % 10);
            temp = temp.next;
            l1 = l1.next;
        }

        while(l2 != null) {
            var total = l2.val + carry;
            carry = total >= 10 ? 1 : 0;
            temp.next = new ListNode(total % 10);
            temp = temp.next;
            l2 = l2.next;
        }
        if (carry == 1) {
            temp.next = new ListNode(carry);
        }
        return res.next;
    }
}
