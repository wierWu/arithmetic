package offer.tree;

/**
 * 二叉搜索树的后序遍历序列
 *
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回 true。否则返回 false。
 * 假设输入的数组的任意两个数字都互不相同。
 *
 * @Link http://wiki.jikexueyuan.com/project/for-offer/question-twenty-four.html
 */
public class VerifySequenceOfBST {

    public static  boolean verifySequenceOfBST(int [] sequen){

        if (sequen==null||sequen.length==0){
            return false;
        }

        return verifySequenceOfBST(sequen,0,sequen.length-1);
    }


    private static  boolean verifySequenceOfBST(int [] sequen,int start,int end){

        if (start>=end){
            return true;
        }

        int root = sequen[end];
        int lEnd = start;
        while (lEnd<end){
            if (sequen[lEnd]<root){
                lEnd++;
            }else {
                break;
            }
        }

        int rEnd =lEnd;
        while (rEnd<end){
            if (sequen[rEnd]>root){
                rEnd++;
            }else {
                return false;
            }
        }

        boolean left =true;
        if (lEnd>=start){
            left=verifySequenceOfBST(sequen,start,lEnd-1);
        }

        boolean right =true;
        if (rEnd<end){
            right = verifySequenceOfBST(sequen,lEnd,end-1);
        }

        return left&& right;



    }


    public static void main(String[] args) {
        //           10
        //         /   \
        //        6     14
        //       /\     /\
        //      4  8  12  16
        int[] data = {4, 8, 6, 12, 16, 14, 10};
        System.out.println("true: " + verifySequenceOfBST(data));
        //           5
        //          / \
        //         4   7
        //            /
        //           6
        int[] data2 = {4, 6, 7, 5};
        System.out.println("true: " + verifySequenceOfBST(data2));
        //               5
        //              /
        //             4
        //            /
        //           3
        //          /
        //         2
        //        /
        //       1
        int[] data3 = {1, 2, 3, 4, 5};
        System.out.println("true: " + verifySequenceOfBST(data3));
        // 1
        //  \
        //   2
        //    \
        //     3
        //      \
        //       4
        //        \
        //         5
        int[] data4 = {5, 4, 3, 2, 1};
        System.out.println("true: " + verifySequenceOfBST(data4));
        // 树中只有1个结点
        int[] data5 = {5};
        System.out.println("true: " + verifySequenceOfBST(data5));
        int[] data6 = {7, 4, 6, 5};
        System.out.println("false: " + verifySequenceOfBST(data6));
        int[] data7 = {4, 6, 12, 8, 16, 14, 10};
        System.out.println("false: " + verifySequenceOfBST(data7));
    }
}
