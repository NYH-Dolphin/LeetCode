package DataStructure.LinkList;

public class E_1_LinkedList_cycle {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(3);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(0);
        ListNode a4 = new ListNode(-4);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a2;
        System.out.println(hasCycle(a1));
    }


    public static boolean hasCycle(ListNode head) {
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
        return flag;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}