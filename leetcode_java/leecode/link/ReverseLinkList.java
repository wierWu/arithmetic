package leecode.link;

import leecode.tree.ListNode;

import java.util.Stack;

/**
 * 反转链表
 *
 * @author <a href="mailto:jian.wu@happyelements.com">jian.wu</a>
 * @version 1.0
 * @since 1.0
 */
public class ReverseLinkList {


    /**
     * 反转打印
     *
     * @param head
     * @return
     */
    public ListNode<Integer> printReverse(ListNode<Integer> head) {
        if (head == null || head.getNext() == null) {
            return null;
        }

        ListNode<Integer> node = printReverse(head.getNext());
        System.out.println(head.getValue());

        return node;
    }


    /**
     * 反转
     *
     * @param head
     * @return
     */
    public ListNode<Integer> reverseListNode(ListNode<Integer> head) {
        if (head == null || head.getNext() == null) {
            return head;
        }

        ListNode<Integer> node = reverseListNode(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);

        return node;
    }

    public ListNode<Integer> reverseListNode2(ListNode<Integer> head) {
        if (head == null || head.getNext() == null) {
            return null;
        }

        Stack<ListNode<Integer>> nodeStack = new Stack<ListNode<Integer>>();
        nodeStack.add(head);
        while (head.getNext() != null) {
            nodeStack.push(head.getNext());
            head.setNext(null);
            head = head.getNext();
        }

        head = nodeStack.pop();
        ListNode<Integer> pre = head;
        while (!nodeStack.isEmpty()) {
            pre.setNext(nodeStack.pop());
        }

        return head;
    }
}
