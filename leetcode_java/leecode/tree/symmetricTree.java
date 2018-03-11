package leecode.tree;

/**
 * 镜面tree
 *
 * @author <a href="mailto:jian.wu@happyelements.com">jian.wu</a>
 * @version 1.0
 * @since 1.0
 */
public class symmetricTree {

    public boolean isSymetricTree(TreeNode<Integer> treeNode) {
        if (treeNode == null) {
            return false;
        }

        return isMirro(treeNode.getLeft(), treeNode.getRight());
    }

    public boolean isMirro(TreeNode<Integer> q, TreeNode<Integer> p) {
        if (q == null && p == null) {
            return true;
        }

        if (q.getValue() != p.getValue()) {
            return false;
        }

        return isMirro(p.getLeft(), q.getRight()) && isMirro(p.getRight(), q.getLeft());

    }
}
