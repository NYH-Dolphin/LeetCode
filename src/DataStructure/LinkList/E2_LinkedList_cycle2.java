package DataStructure.LinkList;

import java.util.ArrayList;
import java.util.HashSet;

public class E2_LinkedList_cycle2 {
    public static void main(String[] args) {
        ListNode n0 = new ListNode(0);
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n1;
        System.out.println(detectCycle(n0).val);
    }


    public static ListNode detectCycle(ListNode head) {
        boolean flag = false;
        ListNode fast = head;// 快指针
        ListNode slow = head;// 慢指针
        // 使用 try-catch 防止 fast 和 slow 的 next 是 null（空指针）
        while(fast != null && slow != null){
            try {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) {
                    flag = true;
                    break;
                }
            }catch (Exception ignored){
                break;
            }
        }
        if(!flag){
            return null;
        }else {
            fast = head;
            while(fast != slow){
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        }
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
