package leecode.tree;

/**
 * 找出两个节点的，最近公共祖先节点
 *
 * @author <a href="mailto:jian.wu@happyelements.com">jian.wu</a>
 * @version 1.0
 * @link https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
 * @since 1.0
 */
public class LCAForBST {

    /**
     * bst 最近公共祖先
     * @param treeNode
     * @param q
     * @param p
     * @return
     */
    public TreeNode<Integer> lca(TreeNode<Integer> treeNode, TreeNode<Integer> q, TreeNode<Integer> p) {
        if (treeNode == null || treeNode == p || treeNode == q) return treeNode;

        if (treeNode.getValue() > q.getValue() && treeNode.getValue() > p.getValue()) {
            return lca(treeNode.getRight(), q, p);
        } else if (treeNode.getValue() < q.getValue() && treeNode.getValue() < p.getValue()) {
            return lca(treeNode.getLeft(), q, p);
        } else {
            return treeNode;
        }
    }


    /**
     * 二叉树的最近公共父节点
     *
     * @param root
     * @param p
     * @param q
     * @return
     * @link https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.getLeft(), p, q);
        TreeNode right = lowestCommonAncestor(root.getRight(), p, q

        );
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }


}
