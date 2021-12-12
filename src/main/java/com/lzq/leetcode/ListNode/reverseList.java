package com.lzq.leetcode.ListNode;

public class reverseList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode reverseList(ListNode head) {
        if(head==null) return null;
        ListNode pre = head,cnt = head.next;
        pre.next = null;
        while(cnt!=null){
            ListNode cur = cnt;
            cnt = cnt.next;
            cur.next = pre;
            pre = cur;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode ll = reverseList(l1);
        while(ll!=null){
            System.out.println(ll.val);
            ll = ll.next;
        }
    }
}
