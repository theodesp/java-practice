package codeSignal.prep;

public class MergeTwoLinkedLists {
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
        l.next.next = new ListNode<Integer>(4);
        var r = new ListNode<Integer>(3);
        r.next = new ListNode<Integer>(5);
        r.next.next = new ListNode<Integer>(6);
        var res = solution(l,r);
        System.out.println(res);
    }

    static ListNode<Integer> solution(ListNode<Integer> l1, ListNode<Integer> l2) {
        var result = new ListNode<Integer>(0);
        var res = result;
        while (l1 != null && l2 != null) {
            if (l1.value <= l2.value) {
                res.next = l1;
                l1 = l1.next;
            } else {
                res.next = l2;
                l2 = l2.next;
            }
            res = res.next;
        }

        if (l1 == null) {
            res.next = l2;
        }
        if (l2 == null) {
            res.next = l1;
        }

        return result.next;
    }
    
}
