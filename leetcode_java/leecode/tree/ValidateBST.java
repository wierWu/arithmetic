package leecode.tree;

/**
 * 验证一个二叉树
 *
 * @author <a href="mailto:jian.wu@happyelements.com">jian.wu</a>
 * @version 1.0
 * @since 1.0
 */
public class ValidateBST {

    public boolean validateBST(TreeNode<Integer> root, int minValue, int maxValue) {
        if (root == null) {
            return true;
        }

        if (root.getValue() >= maxValue || root.getValue() <= minValue) {
            return false;
        }

        return validateBST(root.getLeft(), minValue, root.getValue()) && validateBST(root.getRight(), root.getValue(), maxValue);

    }


    public static void main(String[] args) {

    }
}
