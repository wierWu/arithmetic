package offer.tree;

import leecode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树中和为某一值的路径
 *
 *
 * 输入一棵二叉树和一个整数， 打印出二叉树中结点值的和为输入整数的所有路径。从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 *
 * @Link http://wiki.jikexueyuan.com/project/for-offer/question-twenty-five.html
 */
public class FindAllPath {

    /**
     * 由于路径是从根结点出发到叶结点， 也就是说路径总是以根结点为起始点，因此我们首先需要遍历根结点。在树的前序、中序、后序三种遍历方式中，只有前序遍历是首先访问根结点的。

     当用前序遍历的方式访问到某一结点时， 我们把该结点添加到路径上，并累加该结点的值。如果该结点为叶结点并且路径中结点值的和刚好等于输入的整数， 则当前的路径符合要求，我们把它打印出来。如果当前结点不是叶结点，则继续访问它的子结点。当前结点访问结束后，递归函数将自动回到它的父结点。因此我们在函数退出之前要在路径上删除当前结点并减去当前结点的值，以确保返回父结点时路径刚好是从根结点到父结点的路径。
     */

    public void  findPath(TreeNode<Integer> root,int exceptNum){
        if (root==null){
            return;
        }

        if (root.getValue()==exceptNum){
            System.out.println(root.getValue());
        }

        List<Integer> res = new ArrayList<>();
        findPath(root,0,exceptNum,res);

    }

    public void findPath(TreeNode<Integer> root, int curNum, int exceptNum, List<Integer> res){
        if (root!=null){
            curNum+=root.getValue();
            res.add(root.getValue());
            if (curNum<exceptNum){
                findPath(root.getLeft(),curNum,exceptNum,res);
                findPath(root.getRight(),curNum,exceptNum,res);
            }else if(curNum==exceptNum){
                if (root.getLeft()==null&&root.getRight()==null){
                    System.out.println();
                    for (int path:res
                         ) {
                        System.out.print(path);
                        System.out.print(",");
                    }
                }
            }

            //删除当前节点
            res.remove(res.size()-1);
        }


    }
}
