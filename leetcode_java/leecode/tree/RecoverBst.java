package leecode.tree;

/**
 * 反转二叉树
 *
 * @author <a href="mailto:jian.wu@happyelements.com">jian.wu</a>
 * @version 1.0
 * @since 1.0
 */
public class RecoverBst {


    private TreeNode<Integer> recover(TreeNode<Integer> node) {

        if (node == null) {
            return null;
        }

        TreeNode<Integer> left = node.getLeft();
        TreeNode<Integer> right = node.getRight();
        if (right != null) {
            node.setLeft(right);
            recover(right);
        }

        if (left != null) {
            node.setRight(left);
            recover(left);
        }

        return node;
    }
}
