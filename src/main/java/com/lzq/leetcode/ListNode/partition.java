package com.lzq.leetcode.ListNode;

public class partition {
    public static class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode partition(ListNode head, int x) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode res = temp;
        while(temp!=null&&temp.next!=null){
            if(temp.next.val>=x) break;
            else temp = temp.next;
        }
        ListNode pre = temp;
        temp = temp.next;
        while (temp!=null&&temp.next!=null){
            if(temp.next.val<x){
                ListNode node = temp.next;
                temp.next = node.next;
                node.next = pre.next;
                pre.next = node;
                pre = pre.next;
            }
            if(temp.next!=null&&temp.next.val<x) continue;
            temp = temp.next;
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(0);
        ListNode node5 = new ListNode(2);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        ListNode node = partition(node1,3);
        System.out.println(1+" "+4+" "+3+" "+0+" "+2+" "+5+" "+2);
        while(node!=null){
            System.out.print(node.val+" ");
            node = node.next;
        }
    }
}
