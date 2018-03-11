package leecode.sort;

/**
 * 从第一个元素开始，该元素可以认为已经被排序
 * 取出下一个元素，在已经排序的元素序列中从后向前扫描
 * 如果该元素（已排序）大于新元素，将该元素移到下一位置
 * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
 * 将新元素插入到该位置中
 * 重复步骤2
 *
 * @author <a href="mailto:jian.wu@happyelements.com">jian.wu</a>
 * @version 1.0
 * @since 1.0
 */
public class InsertSort implements Sort {


    public void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }


        for (int i = 0; i < nums.length; i++) {
            int tmp = nums[i];
            int j = i - 1;
            //从i-1位置向前查找，发现大于nums[i]的，往后移动,停止在<=nums[i ]
            for (; j >= 0 && nums[j] > tmp; j--) {
                nums[j + 1] = nums[j];
            }
            //因为上面停止的地方nums[j]<=nums[i]
            nums[j + 1] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 9, 1, 3, 2, 7, 5, 2, 8};
        InsertSort sort = new InsertSort();
        sort.sort(nums);
        for (int num : nums
                ) {
            System.out.print(num);
            System.out.print(",");
        }
    }
}
