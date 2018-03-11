package leecode.tree;

/**
 * 有序链表转换为bst
 *
 * @author <a href="mailto:jian.wu@happyelements.com">jian.wu</a>
 * @version 1.0
 * @since 1.0
 * @link https://siddontang.gitbooks.io/leetcode-solution/content/tree/convert_sorted_listarray_to_binary_search_tree.html
 */
public class SortedLinkListToBST {


    public TreeNode<Integer> linkListToBst(ListNode<Integer> head, ListNode<Integer> tail) {
        ListNode<Integer> fast = head;
        ListNode<Integer> slow = head;
        if (head == tail) {
            return null;
        }

        while (fast != tail && fast.getNext() != tail) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }

        TreeNode<Integer> node = new TreeNode<Integer>(slow.getValue());
        node.setLeft(linkListToBst(head, slow));
        node.setRight(linkListToBst(slow.getNext(), tail));

        return node;
    }

}
