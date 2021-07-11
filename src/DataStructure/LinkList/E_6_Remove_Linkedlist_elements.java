package DataStructure.LinkList;

import java.util.ArrayList;

public class E_6_Remove_Linkedlist_elements {

    public static void main(String[] args) {

    }

    public static ListNode removeElements(ListNode head, int val) {
        // 空链表
        if(head == null){
            return null;
        // 一个节点的链表
        }else if(head.next == null){
            if(head.val == val){
                return null;
            }else{
                return head;
            }
        // 两个及以上
        }else {
            ArrayList<Integer> value = new ArrayList<>();
            while(head != null){
                if(head.val != val){
                    value.add(head.val);
                }
                head = head.next;
            }
            // 所有节点的val都等于指定的val，全部删除
            if(value.size() == 0){
                return null;
            }
            //其它情况
            ListNode myHead = new ListNode(value.get(0));
            ListNode point = myHead;
            for(int i = 1; i < value.size(); i++){
                ListNode node = new ListNode(value.get(i));
                point.next = node;
                point = point.next;
            }
            return myHead;
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
