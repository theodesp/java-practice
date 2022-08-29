package codeSignal.prep;

public class IsListPalindrome {
    static class ListNode<T> {
        ListNode(T x) {
            value = x;
        }

        T value;
        ListNode<T> next;
    }

    public static void main(String[] args) {
        var l = new ListNode<Integer>(1);
        l.next = new ListNode<Integer>(1000000000);
        l.next.next = new ListNode<Integer>(-1000000000);
        l.next.next.next = new ListNode<Integer>(-1000000000);
        l.next.next.next.next = new ListNode<Integer>(1000000000);
        l.next.next.next.next.next = new ListNode<Integer>(1);
        var res = solution(l);
        System.out.println(res);
    }

    static boolean solution(ListNode<Integer> l) {
        ListNode<Integer> slow = l;
        ListNode<Integer> fast = l;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) { // odd nodes
            slow = slow.next;
        }
        slow = reverseList(slow);
        fast = l;
        while (slow != null) {
            if (slow.value.intValue() != fast.value.intValue()) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    static ListNode<Integer> reverseList(ListNode<Integer> l) {
        ListNode<Integer> prev = null;

        while (l != null) {
            ListNode<Integer> next = l.next;
            l.next = prev;
            prev = l;
            l = next;
            if (next != null) {
                next = next.next;
            }

        }
        return prev;
    }
}
