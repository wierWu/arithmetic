package leecode.tree;

/**
 * @author <a href="mailto:jian.wu@happyelements.com">jian.wu</a>
 * @version 1.0
 * @since 1.0
 */
public class MaxTreeDeep {

    public int maxDeep(TreeNode<Integer> node) {
        if (node == null) {
            return 0;
        }

        return Math.max(maxDeep(node.getLeft()), maxDeep(node.getRight())) + 1;
    }

    public int minDeep(TreeNode<Integer> node) {
        if (node == null) {
            return 0;
        }

        //考虑左字数有可能没有的情况
        if (node.getLeft() == null) {
            return 1 + minDeep(node.getRight());
        }

        //考虑右字数有可能没有的情况
        if (node.getRight() == null) {
            return 1 + minDeep(node.getLeft());
        }

        return 1 + (Math.min(minDeep(node.getLeft()), minDeep(node.getRight())));
    }
}
