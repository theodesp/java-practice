package codeSignal.prep;

public class RearrangeLastN {
    static class ListNode<T> {
        ListNode(T x) {
            value = x;
        }
        T value;
        ListNode<T> next;
    }

    public static void main(String[] args) {
        var l = new ListNode<Integer>(1);
        l.next = new ListNode<Integer>(2);
        l.next.next= new ListNode<Integer>(3);
        l.next.next.next= new ListNode<Integer>(4);
        l.next.next.next.next= new ListNode<Integer>(6);
        l.next.next.next.next.next= new ListNode<Integer>(5);
        var res = solution(l, 2);
        System.out.println(res);
    }

    static ListNode<Integer> solution(ListNode<Integer> l, int k) {
        if (k == 0) {
            return l;
        }
        var res = new ListNode<Integer>(0);
        var fast = l; // represents the fast node
        var slow = l; // represents the slow node
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            return l;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
    
        res = slow.next; // save next of slow
        slow.next = null; // point slow next to null

        fast.next= l; // point fast next to original list
        return res; // return saved res
    }
}
