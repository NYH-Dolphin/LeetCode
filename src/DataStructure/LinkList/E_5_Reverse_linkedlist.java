package DataStructure.LinkList;

public class E_5_Reverse_linkedlist {

    public static void main(String[] args) {


    }


    public ListNode reverseList(ListNode head) {
        ListNode n1;
        ListNode n2;
        ListNode n3;
        // 没有节点
        if(head == null){
            return head;
        }
        // 只有一个节点
        if(head == null || head.next == null) {
            return head;
        }
        // 只有两个节点
        if(head.next.next == null){
            n1 = head;
            n2 = head.next;
            n2.next = n1;
            n1.next = null;
            return n2;
        }else{
            n1 = head;
            n2 = head.next;
            while(n2.next != null){
                n3 = n2.next;
                n2.next = n1;
                n1 = n2;
                n2 = n3;
            }
            n2.next = n1;
            head.next = null;
            return n2;
        }
    }

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
}
