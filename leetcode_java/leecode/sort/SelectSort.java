package leecode.sort;

/**
 * 选择排序
 * 选择排序算法
 * 在未排序序列中找到最小元素，存放到排序序列的起始位置
 * 再从剩余未排序元素中继续寻找最小元素，然后放到排序序列末尾。
 * 以此类推，直到所有元素均排序完毕。
 *
 * @author <a href="mailto:jian.wu@happyelements.com">jian.wu</a>
 * @version 1.0
 * @since 1.0
 */
public class SelectSort {

    public void sort(int[] nums) {

        if (nums == null || nums.length < 1) {
            return;
        }

        int size = nums.length;
        for (int i = 0; i < size; i++) {
            int k = i;
            for (int j = size - 1; j > i; j--) {
                if (nums[j] < nums[k]) {
                    k = j;
                }
            }

            //交换两数字
            if (k != i) {
                nums[i] ^= nums[k];
                nums[k] ^= nums[i];
                nums[i] ^= nums[k];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 9, 1, 3, 2, 7, 5, 2, 8};
        SelectSort selectSort = new SelectSort();
        selectSort.sort(nums);
        for (int num : nums
                ) {
            System.out.print(num);
            System.out.print(",");
        }
    }

}
