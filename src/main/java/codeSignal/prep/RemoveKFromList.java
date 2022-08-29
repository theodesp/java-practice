package codeSignal.prep;

public class RemoveKFromList {
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
        l.next.next= new ListNode<Integer>(2);
        l.next.next.next= new ListNode<Integer>(3);
        l.next.next.next.next= new ListNode<Integer>(4);
        l.next.next.next.next= new ListNode<Integer>(5);
        var res = solution(l, 3);
        System.out.println(res);
    }

    static ListNode<Integer> solution(ListNode<Integer> l, int k) {
        var temp = new ListNode<Integer>(0);
        temp.next = l;
        var curr = temp;
        while(temp != null) {
            while (temp.next != null && temp.next.value == k) {
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
        return curr.next;
    }
    
}
