package com.lzq.leetcode.ListNode;

class addTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    /*
    * 56789
    * 12345
    *
    * 99999
    * 999
    *
    * 249
    * 5649
    * */
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(9);
//        ListNode l4 = new ListNode(9);
//        ListNode l5 = new ListNode(9);
        l1.next = l2;
        l2.next = l3;
//        l3.next = l4;
//        l4.next = l5;
        ListNode s1 = new ListNode(5);
        ListNode s2 = new ListNode(6);
        ListNode s3 = new ListNode(4);
        ListNode s4 = new ListNode(9);
//        ListNode s5 = new ListNode(9);
        s1.next = s2;
        s2.next = s3;
        s3.next = s4;
//        s4.next = s5;
        ListNode ls = addTwoNumbers(l1,s1);
        while(ls!=null){
            System.out.println(ls.val);
            ls = ls.next;
        }
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ll = null;
        ListNode ls = null;
        int s1 = l1.val,s2 = l2.val,sw = 0;
        while(l1!=null||l2!=null){
            if(ls==null) {
                ls = new ListNode((s1 + s2 + sw) % 10);
                ll = ls;
            }
            else {
                ll.next = new ListNode((s1 + s2 + sw) % 10);
                ll = ll.next;
            }

            if(l1==null){
                sw = (s2+sw)/10;
                l2 = l2==null?null:l2.next;
                s1 = 0;
                s2 = l2==null?0:l2.val;
            }else if(l2==null){
                sw = (s1+sw)/10;
                l1 = l1==null?null:l1.next;
                s1 = l1==null?0:l1.val;
                s2 = 0;
            }else{
                sw = (s1+s2+sw)/10;
                l1 = l1.next;
                l2 = l2.next;
                s1 = l1==null?0:l1.val;
                s2 = l2==null?0:l2.val;
            }
        }
        if(sw>0) ll.next = new ListNode(sw);
        return ls;
    }
}
