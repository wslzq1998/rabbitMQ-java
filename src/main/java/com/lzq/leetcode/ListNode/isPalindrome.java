package com.lzq.leetcode.ListNode;

import java.util.Stack;

public class isPalindrome {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static boolean isPalindrome(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head,pre = head;
        int k = 0;
        for(pre=head;pre!=null;pre=pre.next) k++;
        int kk = k/2;
        while(kk>0){
            stack.push(cur);
            cur = cur.next;
            kk--;
        }
        if(k%2==1) cur = cur.next;
        while(cur!=null){
            if(stack.pop().val != cur.val)
                return false;
            cur = cur.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(isPalindrome(node1));
    }
}
