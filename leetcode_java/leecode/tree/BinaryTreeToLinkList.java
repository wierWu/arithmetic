package leecode.tree;

/**
 * 二叉树变成一个链表(后续遍历)
 *
 * @author <a href="mailto:jian.wu@happyelements.com">jian.wu</a>
 * @version 1.0
 * @link https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
 * @since 1.0
 */
public class BinaryTreeToLinkList {

    private TreeNode<Integer> pre;

    public TreeNode<Integer> toLinkList(TreeNode<Integer> head) {
        if (head == null) {
            return null;
        }

        //TODO 特殊处理，先遍历右树
        toLinkList(head.getRight());
        toLinkList(head.getLeft());
        head.setRight(pre);
        head.setLeft(null);
        pre = head;

        return pre;
    }
}
