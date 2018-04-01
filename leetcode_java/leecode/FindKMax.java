package leecode;

import java.util.PriorityQueue;

/**
 * 寻找第k大的数
 *
 * @author <a href="mailto:jian.wu@happyelements.com">jian.wu</a>
 * @version 1.0
 * @link https://www.jianshu.com/p/33ee33ce8699
 * @link http://www.cnblogs.com/en-heng/p/6336625.html
 * @since 1.0
 */
public class FindKMax {

    public int findKMax(int[] arry, int k, int left, int right) {
        if (arry == null || arry.length == 0 || arry.length < k) {
            return -1;
        }
        if (left > right) {
            return -1;
        }

        int i = quit(arry, left, right);
        if (i == k - 1) {
            return arry[i];
        } else if (i < k - 1) {
            return findKMax(arry, k, i + 1, right);
        } else if (i > k - 1) {
            return findKMax(arry, k, left, i - 1);
        }

        return 0;
    }

    public static void main(String[] args) {
        // 典型输入，单调升序的数组的一个旋转
        int[] array1 = {3, 4, 5, 0, 1, 1, 2};
        FindKMax maxInOrder = new FindKMax();
        int max = maxInOrder.findKMax(array1, 3, 0, array1.length - 1);
        System.out.println(max);
    }

    private int quit(int[] arr, int left, int right) {
        int mid = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= mid) {
                right--;
            }

            if (left < right) {
                arr[left++] = arr[right];
            }

            while (left < right && arr[left] <= mid) {
                left++;
            }

            if (left < right) {
                arr[right--] = arr[left];
            }
        }

        arr[left] = mid;

        return left;
    }


    public int findKByPriority(int[] nums, int k) {
        PriorityQueue<Integer> minQueue = new PriorityQueue<Integer>();
        for (int num :
                nums) {
            if (minQueue.size() < k || minQueue.peek() < num) {
                minQueue.offer(num);
            }

            if (minQueue.size() > k) {
                minQueue.poll();
            }
        }

        return minQueue.peek();
    }
}
