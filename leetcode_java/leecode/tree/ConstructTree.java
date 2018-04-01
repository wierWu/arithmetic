package leecode.tree;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如：前序遍历序列｛ 1， 2， 4，7，3，5，6，8｝和中序遍历序列｛4，7，2，1，5，3，8，6}，重建出下图所示的二叉树并输出它的头结点。
 *
 * @author <a href="mailto:jian.wu@happyelements.com">jian.wu</a>
 * @version 1.0
 * @link http://wiki.jikexueyuan.com/project/for-offer/question-six.html
 * @since 1.0
 */
public class ConstructTree {

    public TreeNode<Integer> constructTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inend) {
        if (preStart > preEnd) {
            return null;
        }

        int value = preorder[preStart];
        int index = inStart;

        while (index <= inend && inorder[index] != value) {
            index++;
        }

        if (index > inend) {
            throw new RuntimeException("input error!");
        }

        TreeNode<Integer> treeNode = new TreeNode<Integer>();
        treeNode.setValue(value);
        //于在中序遍历序列中，有3个数字是左子树结点的值，因此左子树总共有3个左子结点。同样，在前序遍历的序列中，根结点后面的3个数字就是3个左子树结点的值，再后面的所有数字都是右子树结点的值。这样我们就在前序遍历和中序遍历两个序列中，分别找到了左右子树对应的子序列。

        treeNode.setLeft(constructTree(preorder, preStart + 1, preStart + index - inStart, inorder, inStart, index - 1));
        treeNode.setRight(constructTree(preorder, preStart + index - inStart + 1, preEnd, inorder, index + 1, inend));
        return treeNode;
    }

    public static void printTree(TreeNode root) {
        if (root != null) {
            printTree(root.getLeft());
            System.out.print(root.getValue() + " ");
            printTree(root.getRight());
        }
    }

    public TreeNode construct(int[] preorder, int[] inorder) {
        // 输入的合法性判断，两个数组都不能为空，并且都有数据，而且数据的数目相同
        if (preorder == null || inorder == null || preorder.length != inorder.length || inorder.length < 1) {
            return null;
        }
        return constructTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public static void main(String[] args) {
        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};
        ConstructTree root = new ConstructTree();
        TreeNode treeNode = root.construct(preorder, inorder);
        printTree(treeNode);
    }
}
