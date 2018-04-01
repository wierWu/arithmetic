package leecode.link;

import leecode.tree.ListNode;

/**
 * 链表中倒数第 k 个结点
 *
 * @author <a href="mailto:jian.wu@happyelements.com">jian.wu</a>
 * @version 1.0
 * @link http://wiki.jikexueyuan.com/project/for-offer/question-fifteen.html
 * @since 1.0
 */
public class findKthToTail {

    /**
     * 为了实现只遍历链表一次就能找到倒数第 k 个结点，我们可以定义两 个指针。第一个指针从链表的头指针开始遍历向前走 k-1步，第二个指针保持不动；从第k 步开始，第二个指针也开始从链表的头指针开始遍历。由于两个指针的距离保持在 k-1 ， 当第一个（走在前面的）指针到达链表的尾结点时，第二个指针（走在后面的）指针正好是倒数第 k 个结点
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode<Integer> findKthToTail(ListNode<Integer> head, int k) {

        // 输入的链表不能为空，并且k大于0
        if (k < 1 || head == null) {
            return null;
        }

        ListNode<Integer> fastNode = head;
        for (int i = 1; i < k; i++) {
            if (fastNode.getNext() != null) {
                fastNode = fastNode.getNext();
            } else {
                return null;
            }
        }

        while (fastNode.getNext() != null) {
            fastNode = fastNode.getNext();
            head = head.getNext();
        }

        return head;
    }
}
