package codeSignal.prep;

public class ReverseNodesInKGroups {
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
        if (k == 1) {
            return l;
        }
        var temp = new ListNode<Integer>(0);
        temp.next = l;
        var res = temp;

        while(true) {
            var flag = true;
            var curr = temp;
            for (var i = 0; i < k; i++) {
                if (curr.next != null) {
                    curr = curr.next;;
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                var q = curr.next; // save pointer to rest of list
                var t = temp.next;
                reverseList(t, curr); // a is the reversed list
                temp.next = curr;
                t.next = q;
                temp = t;
            } else {
                break;
            }
        }

        return res.next;
    }

    static ListNode<Integer> reverseList(ListNode<Integer> head, ListNode<Integer> tail) {
        ListNode<Integer> prev = null;
        while (prev != tail) {
            ListNode<Integer> next = head.next;
            head.next = prev;
            prev = head;
            head = next;
            if (next != null) {
                next = next.next;
            }
        }
        return prev;
    }
}
