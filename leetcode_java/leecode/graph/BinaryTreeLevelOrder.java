package leecode.graph;

import leecode.tree.TreeNode;

import java.util.*;

/**
 * 把二叉树按照等级输出
 *
 * @author <a href="mailto:jian.wu@happyelements.com">jian.wu</a>
 * @version 1.0
 * @since 1.0
 */
public class BinaryTreeLevelOrder {

    public List<List<Integer>> levelOrder(TreeNode<Integer> root) {
        return bfs(root);
    }


    public List<List<Integer>> bfs(TreeNode<Integer> root) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();

        if (root == null) {
            return lists;
        }

        LinkedList<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
        queue.offer(root);


        while (!queue.isEmpty()) {
            //current level nodes
            int leveSize = queue.size();

            List<Integer> levelList = new ArrayList<Integer>();
            for (int i = 0; i < leveSize; i++) {
                TreeNode<Integer> curNode = queue.poll();
                levelList.add(curNode.getValue());
                if (curNode.getLeft() != null) {
                    queue.offer(curNode.getLeft());
                }

                if (curNode.getRight() != null) {
                    queue.offer(curNode.getRight());
                }
            }

            lists.add(levelList);

        }

        return lists;
    }


    public List<List<Integer>> dfs(TreeNode<Integer> root, int level, List<List<Integer>> res) {
        if (root == null) {
            return res;
        }

        List<Integer> levList ;
        if (res.size() <= level) {
            levList = new ArrayList<Integer>();
            res.add(levList);
        } else {
            levList = res.get(level);
        }

        levList.add(root.getValue());

        dfs(root.getLeft(), level + 1, res);
        dfs(root.getRight(), level + 1, res);

        return res;

    }

    public static void main(String[] args) {

    }
}
