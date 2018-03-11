package leecode.graph;

import leecode.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 把一棵树锯齿输出，（即，从左到右，然后从右到左进入下一个级别并在其间交替）。
 *
 * @author <a href="mailto:jian.wu@happyelements.com">jian.wu</a>
 * @version 1.0
 * @link https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/discuss/33815/My-accepted-JAVA-solution
 * @since 1.0
 */
public class BinaryTreeZigzagLevelOrder {


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        return bfs(root);
    }


    public List<List<Integer>> bfs(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (root == null) {
            return result;
        }

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        int lev = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levList = new ArrayList<Integer>();

            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                if (lev % 2 == 0) {
                    levList.add((Integer) treeNode.getValue());
                } else {
                    levList.add(0, (Integer) treeNode.getValue());
                }

                if (treeNode.getLeft() != null) {
                    queue.offer(treeNode.getLeft());
                }

                if (treeNode.getRight() != null) {
                    queue.offer(treeNode.getRight());
                }
            }

            result.add(levList);
            lev++;
        }


        return result;
    }
}



