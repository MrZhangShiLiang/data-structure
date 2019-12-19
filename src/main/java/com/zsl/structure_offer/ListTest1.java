package com.zsl.structure_offer;

/**
 * @author zsl
 * @date 2019/11/25
 */
public class ListTest1 {
    /**
     * 输入一个链表，输出该链表中倒数第k个结点。
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode node = head;
        ListNode nodeTemp = null;
        int count = 1,temp;

        while (node.next!=null){
            node = node.next;
            count++;
        }

        temp = count - k;
        count = 1;
        while (head != null){
            if (temp==count){
                nodeTemp = head;
            }
            count++;
            head = head.next;
        }
        return nodeTemp;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}