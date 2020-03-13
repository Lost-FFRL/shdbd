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
        print(reverse(p));
        System.out.println();
        print(movePointer(p));
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

    public static ListNode movePointer(ListNode head) {
        ListNode result = head;
        while (null != head) {
            ListNode tmp = head.next;
            result.next = tmp;
            tmp = result;
            head = head.next;
        }
        return result;
    }

    public static ListNode recursion(ListNode node) {
        if (null == node || node.next == null) {
            return node;
        }
        return null;
    }
}
