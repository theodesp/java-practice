package codeSignal.prep;

public class AddTwoHugeNumbers {
    static class ListNode<T> {
        ListNode(T x) {
            value = x;
        }

        T value;
        ListNode<T> next;
    }

    public static void main(String[] args) {
        var l = new ListNode<Integer>(9876);
        l.next = new ListNode<Integer>(5432);
        l.next.next = new ListNode<Integer>(1999);
        var r = new ListNode<Integer>(1);
        l.next = new ListNode<Integer>(8001);
        var res = solution(l, r);
        System.out.println(res);
    }

    static ListNode<Integer> solution(ListNode<Integer> a, ListNode<Integer> b) {
        var result = new ListNode<Integer>(0);
	    var head = result;
        int carry=0;
	    a= reverseList(a);
	    b= reverseList(b);
        while(a != null || b!=null) {
            if(a != null){
	            carry += a.value;
	            a=a.next;
	        }
            if(b != null){
	            carry+=b.value;
	            b= b.next;
	        }
            head.next = new ListNode<Integer>(carry % 10000);
	        head = head.next;
	        carry = carry / 10000;
        }
        if(carry>=1)
	        head.next= new ListNode<Integer>(carry);
	    
	    return reverseList(result.next);
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
