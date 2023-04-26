public class ReorderList {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private static ListNode merge(ListNode head1, ListNode head2){
        // corner case
        if(head1==null) return head2;
        if(head2==null) return head1;

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        ListNode l1 = head1;
        ListNode l2 = head2;

        while(l1!=null && l2!=null){
            cur.next = l1;
            l1 = l1.next;
            cur = cur.next;

            cur.next = l2;
            l2 = l2.next;
            cur= cur.next;
        }
        if(l1==null){
            cur.next = l2;
        }
        if(l2==null){
            cur.next = l1;
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        // create two linked lists
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(5);

        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(4);
        head2.next.next = new ListNode(6);

        // merge the two lists
        ListNode merged = merge(head1, head2);

        // print out the merged list
        System.out.print("Merged List: ");
        while (merged != null) {
            System.out.print(merged.val + " ");
            merged = merged.next;
        }
    }
}
