public class MergeTwoSortedLists {
    static class ListNode {
        public ListNode next;
        int value;
    }

    static ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode dummy = new ListNode();
        if (a == null)
            return b;
        if (b == null)
            return a;
        while (a != null && b != null) {
            if (a.value > b.value) {
                dummy.value = b.value;
                dummy.next = new ListNode();
                b = b.next;
            } else {
                dummy.value = a.value;
                dummy.next = new ListNode();
                a = a.next;
            }
        }
        if (a != null) {
            dummy.next = a;
        }
        if (b != null) {
            dummy.next = b;
        }

        return dummy;
    }
}
