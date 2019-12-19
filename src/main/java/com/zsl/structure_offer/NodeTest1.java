package com.zsl.structure_offer;

import org.apache.activemq.store.jdbc.LeaseDatabaseLocker;
import org.junit.Test;

import java.util.LinkedList;

/**
 * @author zsl
 * @date 2019/12/2
 * 反转单链表转
 */
public class NodeTest1 {

    @Test
    public void tetsString(){
        String str = "\"aaa\"";

        str+="asd";
        System.out.println(str);
    }

    @Test
    public void test1(){
        NodeTest1 t = new NodeTest1();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        ListNode temp = node;

        while (temp.next!=null){
            System.out.println(temp.val);
            temp = temp.next;
        }
        System.out.println(temp.val);

        System.out.println("**********************");
        ListNode reverseList = t.reverseList(node);
        while (reverseList.next!=null){
            System.out.println(reverseList.val);
            reverseList = reverseList.next;
        }
        System.out.println(reverseList.val);
    }

    //时间复杂度：n+n
    public ListNode reverseList(ListNode head) {
        if (null == head){
            return null;
        }
        LinkedList<Integer> list = new LinkedList<>();
        while (head!=null){
            list.addFirst(head.val);
            head = head.next;
        }

        ListNode root = new ListNode(list.get(0)),temp=root,leaf;

        for (int i = 1; i < list.size(); i++) {
            leaf = new ListNode(list.get(i));
            temp.next = leaf;
            temp = leaf;
        }
        return root;
    }
}


