package offer.tree;

import leecode.tree.TreeNode;

/**
 * bst  转换为双向连表
 * @link http://wiki.jikexueyuan.com/project/for-offer/question-twenty-seven.html
 */
public class BstToDlinkNode {

    TreeNode<Integer>  toDlinkNode(TreeNode<Integer> head){
        if (head==null){
            return null;
        }

        TreeNode<Integer> last =null;
        toDlinkNode(head,last);

        if (last!=null&&last.getLeft()!=null){
            return last.getLeft();
        }

        return null;

    }

    void toDlinkNode(TreeNode<Integer> head,TreeNode<Integer> last){
        if (head==null){
            return;
        }

        if (head.getLeft()!=null){
            toDlinkNode(head.getLeft(),last);
        }

        head.setLeft(last);
        if (last!=null){
            last.setRight(head);
        }

        last=head;

        if (head.getRight()!=null){
            toDlinkNode(head.getRight(),last);
        }

    }
}
