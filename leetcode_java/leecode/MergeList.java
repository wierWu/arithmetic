package leecode;

import leecode.tree.ListNode;

/**
 * 合并数组
 *
 * @author <a href="mailto:jian.wu@happyelements.com">jian.wu</a>
 * @version 1.0
 * @since 1.0
 */
public class MergeList {

    public int[] mergeTwoSordArr(int[] a, int[] b) {
        if (a == null || a.length == 1) {
            return b;
        }

        if (b == null || b.length == 1) {
            return a;
        }

        int[] merge = new int[a.length + b.length];
        int p1 = 0, p2 = 0;
        for (int i = 0; i < merge.length; i++) {
            if (p1 >= a.length) {
                merge[i] = b[p2++];
            } else if (p2 >= b.length) {
                merge[i] = a[p1++];
            } else {
                if (a[p1] <= b[p2]) {
                    merge[i] = a[p1++];
                } else {
                    merge[i] = b[p2++];
                }
            }
        }

        return merge;
    }


    /**
     * 合并两个有序的链表
     * @param a
     * @param b
     * @return
     * @link https://leetcode.com/problems/merge-two-sorted-lists/discuss/9716/My-recursive-way-to-solve-this-problem(JAVA-easy-understanding)
     */
    public ListNode<Integer> mergeToSordedLink(ListNode<Integer> a, ListNode<Integer> b) {
        if (a == null) {
            return b;
        }

        if (b == null) {
            return a;
        }

        ListNode<Integer> pre;
        if (a.getValue() <= b.getValue()) {
            pre = a;
            pre.setNext(mergeToSordedLink(a.getNext(), b));
        } else {
            pre = b;
            pre.setNext(mergeToSordedLink(b.getNext(), a));
        }

        return pre;
    }

    public static void main(String[] args) {
        int[] b = {3, 8, 9, 15, 21};
        int[] a = {5, 10, 11, 12, 15, 17, 19, 23, 24};
        MergeList mergeList = new MergeList();
        int[] newA = mergeList.mergeTwoSordArr(a, b);
        for (int i :
                newA) {
            System.out.println(i);
        }
    }
}
