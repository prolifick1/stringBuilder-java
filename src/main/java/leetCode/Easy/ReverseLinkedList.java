package leetCode.Easy;
/*206. Reverse Linked List*/


public class ReverseLinkedList {
    static Integer[] array = new Integer[]{1};

//    public static void main(String[] args) {
//        ListNode head = declaringNode();
//        reverseList(head);
//
//        while (head != null) {
//            System.out.print(head.val);
//            head = head.next;
//        }
//
//    }


    public static ListNode reverseList(ListNode head) {

        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;

        }
        return prev;

    }



    public static ListNode declaringNode() {
        ListNode prev = null;
        ListNode head = null;
        ListNode cur;
        for (int i = 0; i < array.length; i++) {
            cur = new ListNode(array[i]);
            if (head == null) {
                head = cur;
            }
            if (prev != null) {
                prev.next = cur;
            }
            prev = cur;
        }
        return head;
    }


}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next, ListNode prev) {
        this.val = val;
        this.next = next;
    }

}

