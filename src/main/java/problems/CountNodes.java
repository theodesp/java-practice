public class CountNodes {
    class ListNode {
        public ListNode next;
    }
    // Count the number of nodes in a list.
    int count(ListNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + count(node.next);
    }
}
