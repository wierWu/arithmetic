package leecode.tree;


import java.util.ArrayList;
import java.util.List;

/**
 * BST 遍历
 *
 * @author <a href="mailto:jian.wu@happyelements.com">jian.wu</a>
 * @version 1.0
 * @since 1.0
 */
public class Order {


    /**
     * 前序遍历
     *
     * @param root
     * @param nodeList
     */
    public void preOrder(TreeNode<Integer> root, List<Integer> nodeList) {
        if (root == null) {
            return;
        }

        nodeList.add(root.getValue());
        preOrder(root.getLeft(), nodeList);
        preOrder(root.getRight(), nodeList);
    }

    /**
     * 中序遍历
     * 出来之后是一个有序的数列
     *
     * @param root
     * @param nodeList
     */
    public void inorder(TreeNode<Integer> root, List<Integer> nodeList) {
        if (root == null) {
            return;
        }

        inorder(root.getLeft(), nodeList);
        nodeList.add(root.getValue());
        inorder(root.getRight(), nodeList);
    }


    /**
     * 后续遍历
     *
     * @param root
     * @param nodeList
     */
    public void postOrder(TreeNode<Integer> root, List<Integer> nodeList) {
        if (root == null) {
            return;
        }

        postOrder(root.getLeft(), nodeList);
        postOrder(root.getRight(), nodeList);
        nodeList.add(root.getValue());
    }


    public TreeNode<Integer> sortArrayToBST(int[] soredNums, int left, int right) {

        if (left > right) {
            return null;
        }

        int mid = (right + left) / 2;
        TreeNode<Integer> node = new TreeNode<Integer>();
        node.setValue(soredNums[mid]);
        node.setLeft(sortArrayToBST(soredNums, left, mid - 1));
        node.setRight(sortArrayToBST(soredNums, mid + 1, right));

        return node;
    }

    public static void main(String[] args) {
        Order order = new Order();
        int[] nums = {1, 2, 3, 4, 5,6,7};
        TreeNode<Integer> treeNode = order.sortArrayToBST(nums, 0, nums.length - 1);
        System.out.println(treeNode.getValue());

        List<Integer> nodelst = new ArrayList<Integer>();
        order.inorder(treeNode, nodelst);
        for (int node :
                nodelst) {
            System.out.println(node);
        }
    }
}
