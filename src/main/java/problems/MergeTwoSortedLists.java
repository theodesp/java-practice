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
            // If first is larger than second then move second to result. Otherwise move first to result
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
        // Move rest of the first list to result
        if (a != null) {
            dummy.next = a;
        }
        // Move rest of the second list to result
        if (b != null) {
            dummy.next = b;
        }

        return dummy;
    }
}
