package leecode.sort;

/**
 * @author <a href="mailto:jian.wu@happyelements.com">jian.wu</a>
 * @version 1.0
 * @since 1.0
 */
public class BubbleSort {


    public void sort(int[] nums) {
        if (nums == null || nums.length < 1) {
            return;
        }

        int size = nums.length;
        for (int i = 0; i < size; i++) {
            int next = i + 1;
            if (next < size && nums[next] < nums[i]) {
                nums[i] ^= nums[next];
                nums[next] ^= nums[i];
                nums[i] ^= nums[next];
                i -= 2;
                if (i < -1) {
                    i = -1;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 9,10, 1,1, 11, 2, 7, 5, 2, 8};
        BubbleSort sort = new BubbleSort();
        sort.sort(nums);
        for (int num : nums
                ) {
            System.out.print(num);
            System.out.print(",");
        }
    }
}
