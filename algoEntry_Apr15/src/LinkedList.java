public class LinkedList {
    private class ListNode{
        int val;
        ListNode prev, next;
        ListNode(int val){
            this.val = val;
        }
    }

    private int curSize;
    private ListNode head, tail;
    public LinkedList(){
        this.curSize = 0;
        this.head = new ListNode(-1);
        this.tail = new ListNode(-1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int size(){
        return this.curSize;
    }

    public void add(int val){
        ListNode addMe = new ListNode(val);
        ListNode prev = this.tail.prev;
        prev.next = addMe;
        addMe.prev = prev;
        addMe.next = tail;
        tail.prev = addMe;
        this.curSize ++;
    }
    public void indexValidation(int index){
        if(index < 0 || index > this.curSize){
            throw new RuntimeException("Out of Boundary, index: " + index + ", size: "+ this.curSize);
        }
    }

    public ListNode getNode(int index){
        this.indexValidation(index);
        ListNode cur = this.head.next;
        while (index -- >0){
            cur = cur.next;
        }
        return cur;
    }
    public int get(int index){
        ListNode cur = this.getNode(index);
        return cur.val;
    }


    public void add(int index, int val){
        ListNode cur = this.getNode(index);
        ListNode prev = cur.prev;
        ListNode addMe = new ListNode(val);

        prev.next = addMe;
        addMe.prev = prev;

        cur.prev = addMe;
        addMe.next = cur;

        this.curSize ++;
    }

    public void remove(int index){
        ListNode cur = this.getNode(index);

        if (curSize !=0 ) {
            ListNode prev = cur.prev;

            prev.next = cur.next;
            cur.next.prev = prev;

            this.curSize--;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        ListNode cur = head.next;
        if (curSize >0 ) {
            for (int i = 0; i < this.curSize - 1; i++) {
                sb.append(cur.val + ",");
                cur = cur.next;
            }
            sb.append(cur.val);
        }
        sb.append("]");
        return sb.toString();
    }
}
