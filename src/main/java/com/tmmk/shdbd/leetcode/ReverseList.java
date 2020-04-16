package com.tmmk.shdbd.leetcode;

/**
 * 反转连表
 *
 * @author Lost
 * @date 2020-03-13 12:37
 * @see
 */
public class ReverseList {


    public static void main(String[] args) {
        int i = 1;
        ListNode p = new ListNode(i);
        ListNode t = p;
        while (true) {
            i++;
            t.next = new ListNode(i);
            t = t.next;
            if (i == 5) {
                break;
            }
        }
        print(p);
        System.out.println();
//        print(reverse(p));
        System.out.println();
        print(test(p));
    }

    public static ListNode test(ListNode head){
        if(null == head){
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp = null;
        while (null != cur ){
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }



    public static ListNode reverse(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode tmp = new ListNode(head.val);
        ListNode result = tmp;
        while (true) {
            head = head.next;
            if (null == head) {
                return result;
            }
            result = new ListNode(head.val);
            result.next = tmp;
            tmp = result;
        }
    }

    public static void print(ListNode node) {
        while (true) {
            if (null != node) {
                System.out.print(node.val + ">");
            } else {
                System.out.print("null");
                break;
            }
            node = node.next;
        }
    }


    public static ListNode recursion(ListNode node) {
        if (null == node || node.next == null) {
            return node;
        }
        return null;
    }

    /**
     * 反转链表，简版
     * 1、指针移动
     * 2、指针转换
     * @param node
     * @return
     */
    public static ListNode movePointer(ListNode node) {
        if (null == node) {
            return null;
        }
        ListNode pre = null;
        // 指针移动
        ListNode cur = node;
        // 替换使用的临时变量：
        ListNode tmp = null;
        while (null != cur){
            // 优先把要替换的值存储在临时变量中
            tmp = cur.next;
            cur.next = pre;
            // 指针移动
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
