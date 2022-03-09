public class ID82_RemoveDuplicatesFromSortedListII {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //The idea here was to maintain three pointers to consider overlapping issues.
    //Easier solution with predecessor and sentinel (The reason why i didn't implement this is because i was fearing grater than O(n)
    //time complexity)
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode anchor = new ListNode(-101,head);
        ListNode result = anchor;

        ListNode previous = head;
        if(previous == null) return null;
        ListNode current = previous.next;
        if(current == null) return head;
        if(current.next == null) return current.val != previous.val ? head : null;

        if(previous.val != current.val){
            anchor = previous;
        }

        boolean test = false;
        while(current.next != null){
            if(previous.val != current.val && current.val != current.next.val){
                if(test) anchor.next = current;
                anchor = current;
                test = false;
            } else {
                test = true;
            }
            previous = previous.next;
            current = current.next;
        }

        if(previous.val != current.val){
            anchor.next = current;
        } else {
            anchor.next = null;
        }

        return result.next;
    }

    public static ListNode deleteDuplicatesSentinelPredecessor(ListNode head){
        ListNode sentinel = new ListNode(-101, head);
        ListNode predecessor = sentinel;

        while(head != null){
            if(head.next != null && head.val == head.next.val){
                while(head.next != null && head.val == head.next.val) head = head.next;
                predecessor.next = head.next;
            } else {
                predecessor = head;
            }

            head = head.next;
        }

        return sentinel.next;
    }

    public static void main(String... args) {
        ListNode test = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4 , new ListNode(4 ,new ListNode(5)))))));
        ListNode test2 = new ListNode(1,new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3)))));
        ListNode test3 = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(1))));
        ListNode test4 = new ListNode(1, new ListNode(1));
        ListNode test5 = new ListNode(1, new ListNode(2, new ListNode(2)));
        deleteDuplicates(test5);
    }
}
