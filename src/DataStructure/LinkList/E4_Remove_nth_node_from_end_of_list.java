package DataStructure.LinkList;

public class E4_Remove_nth_node_from_end_of_list {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        a1.next = a2;
        ListNode head = removeNthFromEnd(a1, 1);
        System.out.println(head.val);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int cnt = 1;
        ListNode point = head;
        ListNode node = head;
        // point到第n个node
        while (cnt != n) {
            point = point.next;
            cnt++;
        }
        // point到最后一个，即删除第一个node
        if(point.next == null){
            return head.next;
        }
        // point不是最后一个，node.next必然存在，node.next.next可能存在也可能为null
        while(point.next.next != null){
            point = point.next;
            node = node.next;
        }
        node.next = node.next.next;
        return head;
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
