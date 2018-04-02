package offer.link;

import leecode.tree.ListNode;

/**
 * 两个链表的第一个公共结点
 * 题目：输入两个链表，找出它们的第一个公共结点。
 * @link http://wiki.jikexueyuan.com/project/for-offer/question-thirty-seven.html
 */
public class FindFirstCommonNode {
    /**
     * 如果两个链表有公共结点，那么公共结点出现在两个链表的尾部。
     * 如果我们从两个链衰的尾部开始往前比较，最后一个相同的结点就是我们要找的结点。
     * @param head1
     * @param head2
     * @return
     */

    public ListNode<Integer> findFirstCommonNode(ListNode<Integer> head1,ListNode<Integer> head2){
        int length1 = getListLength(head1);
        int length2 = getListLength(head2);
        int diff = length1 - length2;
        ListNode longListHead = head1;
        ListNode shortListHead = head2;
        if (diff < 0) {
            longListHead = head2;
            shortListHead = head1;
            diff = length2 - length1;
        }
        for (int i = 0; i < diff; i++) {
            longListHead = longListHead.getNext();
        }
        while (longListHead != null && shortListHead != null && longListHead != shortListHead) {
            longListHead = longListHead.getNext();
            shortListHead = shortListHead.getNext();
        }
        // 返回第一个相同的公共结点，如果没有返回null
        return longListHead;
    }
    private static int getListLength(ListNode head) {
        int result = 0;
        while (head != null) {
            result++;
            head = head.getNext();
        }
        return result;
    }
}
