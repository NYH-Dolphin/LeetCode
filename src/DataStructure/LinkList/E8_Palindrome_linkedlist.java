package DataStructure.LinkList;

import java.util.List;
import java.util.Stack;

public class E8_Palindrome_linkedlist {


    public boolean isPalindrome(ListNode head) {

        // 只有一个节点
        if (head.next == null) {
            return true;
        }

        // 记录链表一共有几个节点
        int len = 0;
        ListNode point = head;
        while (point != null) {
            len++;
            point = point.next;
        }
        int cnt = 0;
        int mark = len % 2; // 0-偶数 1-奇数
        Stack<Integer> stack = new Stack<>();
        point = head; // 指针回归 head

        while(cnt < len / 2){
            stack.add(point.val);
            cnt++;
            point = point.next;
        }
        if(mark == 1){
            point = point.next;
        }
        while(point != null){
            if(point.val == stack.pop()){
                point = point.next;
            }else{
                return false;
            }
        }
        return stack.size() == 0;
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
