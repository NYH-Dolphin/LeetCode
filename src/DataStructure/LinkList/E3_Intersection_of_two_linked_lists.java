package DataStructure.LinkList;

public class E3_Intersection_of_two_linked_lists {

    public static void main(String[] args) {

        ListNode a1 = new ListNode(4);
        ListNode a2 = new ListNode(1);
        ListNode c1 = new ListNode(8);
        ListNode c2 = new ListNode(4);
        ListNode c3 = new ListNode(5);
        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(0);
        ListNode b3 = new ListNode(1);
        a1.next = a2;
        a2.next = c1;
        c1.next = c2;
        c2.next = c3;
        b1.next = b2;
        b2.next = b3;

        System.out.println(getIntersectionNode(a1, b1).val);

    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode red = headA;
        ListNode blue = headB;
        int loopCntA = 0;
        int loopCntB = 0;
        while (red != blue) {
            if (red.next != null) {
                red = red.next;
            } else {
                // 第一圈
                if (loopCntA == 0) {
                    loopCntA++;
                    red = headB;
                } else {
                    return null;
                }
            }
            if (blue.next != null) {
                blue = blue.next;
            } else {
                // 第一圈
                if (loopCntB == 0) {
                    loopCntB++;
                    blue = headA;
                } else {
                    return null;
                }
            }
        }
        return red;
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
