package DataStructure.LinkList;

public class E7_Odd_even_linkedlist {

    public static ListNode oddEvenList(ListNode head) {
        //如果链表小于3个那么直接返回
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        //定义第一条指针
        ListNode onePoint = head;
        //定义第二条指针
        ListNode twoPoint = head.next;
        //定义第一条指针的开始位置
        ListNode oneHead = onePoint;
        //定义第二条指针开始的位置
        ListNode twoHead = twoPoint;
        while (onePoint.next != null && onePoint.next.next != null) {
            //然后这里就是相互的删除中间的元素，也就是逻辑删除
            onePoint.next = onePoint.next.next;
            onePoint = onePoint.next;
            twoPoint.next = twoPoint.next.next;
            twoPoint = twoPoint.next;
        }
        onePoint.next = twoHead;
        return oneHead;
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
